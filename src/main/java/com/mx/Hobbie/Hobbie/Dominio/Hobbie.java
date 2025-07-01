package com.mx.Hobbie.Hobbie.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //indicar que la clase es una entidad en DB
@Table(name = "HOBBIE")
public class Hobbie {
	
	//Atributo
	@Id
	@Column(name = "ID_HOBBIE", columnDefinition = "NUMBER")
	private int idHobbie;
	
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(100)")
	private String nombre;
	
	@Column(name = "CATEGORIA", columnDefinition = "NVARCHAR2(100)")
	private String categoria;
	
	@Column(name = "ZONA", columnDefinition = "NVARCHAR2(100)")
	private String zona;
	
	@Column(name = "DURACION", columnDefinition = "NUMBER")
	private double duracion;

	public Hobbie() {
	
	}

	public Hobbie(int idHobbie, String nombre, String categoria, String zona, double duracion) {
		this.idHobbie = idHobbie;
		this.nombre = nombre;
		this.categoria = categoria;
		this.zona = zona;
		this.duracion = duracion;
	}

	public int getIdHobbie() {
		return idHobbie;
	}

	public void setIdHobbie(int idHobbie) {
		this.idHobbie = idHobbie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Hobbie [idHobbie=" + idHobbie + ", nombre=" + nombre + ", categoria=" + categoria + ", zona=" + zona
				+ ", duracion=" + duracion + "]";
	}
	
	
	
}
