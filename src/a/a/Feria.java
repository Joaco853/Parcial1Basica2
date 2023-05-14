package a.a;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import unlam.edu.ar.pb2.parcial.src.Entrada;
import unlam.edu.ar.pb2.parcial.src.Persona;
import unlam.edu.ar.pb2.parcial.src.Stant;
import unlam.edu.ar.pb2.parcial.src.TipoPersona;

public class Feria {
	// attributes
	private String nombreDeLaFeria;
	private String ubicacion;
	private Integer tamaño;
	Boolean pagoentradas = false;
	LocalDate fechaActual = LocalDate.now();
	DayOfWeek diaDeLaSemana = fechaActual.getDayOfWeek();

	// collections
	private ArrayList<Persona> personas;
	private Set<Entrada> entradas;
	private Map<Persona, Entrada> asignacionEntrada = new HashMap<>();
	private Set<Stant> stants;

	// constructor
	public Feria(String nombreDeLaFeria, String ubicacion, Integer tamaño) {
		super();
		this.nombreDeLaFeria = nombreDeLaFeria;
		this.ubicacion = ubicacion;
		this.tamaño = tamaño;
		this.personas = new ArrayList<>();
		this.entradas = new HashSet<>();
		this.stants = new HashSet<>();
	}

	// getters ands setters

	public String getNombreDeLaFeria() {
		return nombreDeLaFeria;
	}

	public void setNombreDeLaFeria(String nombreDeLaFeria) {
		this.nombreDeLaFeria = nombreDeLaFeria;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getTamaño() {
		return tamaño;
	}

	public void setTamaño(Integer tamaño) {
		this.tamaño = tamaño;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public Set<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Map<Persona, Entrada> getAsignacionEntrada() {
		return asignacionEntrada;
	}

	public void setAsignacionEntrada(Map<Persona, Entrada> asignacionEntrada) {
		this.asignacionEntrada = asignacionEntrada;
	}

	// methods
	// se realiza la venta de una entrada pero con las siguientes condiciones:
	// 1- si es un alumno y ademas son los dias viernes, sabados y domingos debe
	// pagar la entrada
	// 2- si es una docente los dias domingos no debe pagar la entrada
	// 3- si no es ninguna de las anteriores debe pagar la entrada
	// si se requiere se puede modificar para mas tipos de personas.
	public void venderEntrada(Persona persona, Entrada entrada, DayOfWeek diaSemana) {
		Double pago = 0.0;
		for (Entrada entrada1 : entradas) {
			if (entrada1.equals(entrada)) {
				if (persona.getTipoPersona() == TipoPersona.ALUMNO) {
					if (diaDeLaSemana == DayOfWeek.FRIDAY || diaDeLaSemana == DayOfWeek.SATURDAY
							|| diaDeLaSemana == DayOfWeek.SUNDAY) {
						getAsignacionEntrada().put(persona, entrada);
						pago = persona.getDinero() - entrada.getPrecioEntrada();
						persona.setDinero(pago);
					}

				} else if (persona.getTipoPersona() == TipoPersona.DOCENTE && diaSemana == DayOfWeek.SUNDAY) {
					getAsignacionEntrada().put(persona, entrada);
				} else {
					getAsignacionEntrada().put(persona, entrada);
					pago = persona.getDinero() - entrada.getPrecioEntrada();
					persona.setDinero(pago);
				}
			}
		}

	}

	public void agregarPersona(Persona persona) {
		this.personas.add(persona);

	}

	public Integer obtenerCantidadPersonas() {
		return personas.size();

	}

	public void agregarEntrada(Entrada entrada) {
		this.entradas.add(entrada);

	}

	public Integer obtenerCantidadDeEntradas() {
		return this.entradas.size();

	}

	public void agregarStant(Stant stant) {
		this.stants.add(stant);

	}

	public Boolean verificarQueUnMenorTengaAUnAdulto(Persona persona) {
		Boolean requiereAcompaniante = false;
		for (Persona persona1 : personas) {
			if (persona1.getEdad() <= 12) {
				return requiereAcompaniante = true;

			}
		}
		return requiereAcompaniante;
	}

}