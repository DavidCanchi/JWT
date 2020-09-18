package com.practica.entity;

public class Persona {
	private String nombre;
	private String password;
	public Persona(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
