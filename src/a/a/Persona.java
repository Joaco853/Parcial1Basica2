package a.a;

import java.util.ArrayList;

import unlam.edu.ar.pb2.parcial.src.TipoPersona;

public class Persona {
	// Attributes
	private String nombre;
	private String Apellido;
	private Integer NroDni;
	private Integer Edad;
	private TipoPersona tipoPersona;
	private Double dinero;

	// Constructor
	public Persona(String nombre, String apellido, Integer nroDni, Integer edad, TipoPersona tipoPersona,
			Double dinero) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
		NroDni = nroDni;
		Edad = edad;
		this.tipoPersona = tipoPersona;
		this.setDinero(dinero);
	}

	// Abstracts Class

	// Getters and Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Integer getNroDni() {
		return NroDni;
	}

	public void setNroDni(Integer nroDni) {
		NroDni = nroDni;
	}

	public Integer getEdad() {
		return Edad;
	}

	public void setEdad(Integer edad) {
		Edad = edad;
	}

	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}
	
}
