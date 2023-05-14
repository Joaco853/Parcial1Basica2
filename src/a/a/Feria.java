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
 
}