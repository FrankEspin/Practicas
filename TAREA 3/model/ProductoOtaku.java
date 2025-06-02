package com.akihabara.market.model;

public class ProductoOtaku {
	 private int id;
	 private String nombre;
	 private String categoria;
	 private double precio;
	 private int stock;
	 
	 
	 //Realizamos un constructor que dejaremos vacio
	 public ProductoOtaku() {
	 }
	 
	 //Constructor que recibe todos los datos como parametros
	 public ProductoOtaku (int id, String nombre, String categoria, double precio, int stock) {
		 this.id = id;
		 this.nombre = nombre;
		 this.categoria = categoria;
		 this.precio = precio;
		 this.stock = stock;
	 }
	 
	 
	 //Introducimos los getters y los setters
	 //Get y Set de ID
	 
	 public int getId() {
		 return id;
	 }
	 
	 public void setId (int id) {
		 this.id = id;
	 }
	 
	 		//Get y Set de Nombre
	 	public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	 
	    //Get y Set de Categoria
	    public String getCategoria() {
	        return categoria;
	    }

	    public void setCategoria(String categoria) {
	        this.categoria = categoria;
	    }
	 
	  //Get y Set de Precio
	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }
	    
	  //Get y Set de Stock
	    public int getStock() {
	        return stock;
	    }

	    public void setStock(int stock) {
	        this.stock = stock;
	    }
	 
	    @Override
	    public String toString() {
	        return "ProductoOtaku : " +
	                "ID=" + id +
	                ", Nombre='" + nombre + '\'' +
	                ", Categoría='" + categoria + '\'' +
	                ", Precio=$" + precio +
	                ", Stock=" + stock ;
	    }
	    
}
