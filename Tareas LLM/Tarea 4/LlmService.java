package com.akihabara.market.ia;

import java.io.IOException;
import java.util.Properties;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LlmService {

    private String apiKey;

    public LlmService() {
        cargarApiKey();
    }

    private void cargarApiKey() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println(" Archivo config.properties no encontrado en el classpath");
                return;
            }
            props.load(input);
            this.apiKey = props.getProperty("OPENROUTER_API_KEY");
            System.out.println(" API Key cargada correctamente.");
        } catch (IOException e) {
            System.err.println(" Error al cargar la API Key: " + e.getMessage());
        }
    }


    public String sugerirNombreProducto(String tipo, String franquicia) {
        String prompt = "Sugiere un nombre llamativo y original para un producto otaku del tipo '" + tipo + "' basado en la franquicia '" + franquicia + "'.";
        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("https://openrouter.ai/api/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String requestBody = """
                {
                  "model": "openai/gpt-3.5-turbo",
                  "messages": [{"role": "user", "content": "%s"}]
                }
                """.formatted(prompt);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(requestBody.getBytes(StandardCharsets.UTF_8));
            }

            StringBuilder response = new StringBuilder();
            try (InputStream is = conn.getInputStream();
                 Scanner scanner = new Scanner(is, StandardCharsets.UTF_8)) {
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }
            }

            String json = response.toString();
            // Extraer solo el contenido del mensaje
            int index = json.indexOf("\"content\":\"");
            if (index != -1) {
                int start = index + 11;
                int end = json.indexOf("\"", start);
                if (end > start) {
                    return json.substring(start, end).replace("\\n", "").trim();
                }
            }

            return "Nombre no disponible.";

        } catch (IOException e) {
            System.err.println(" Error al comunicarse con OpenRouter: " + e.getMessage());
            return "Error al generar nombre.";
        }
    }
}

