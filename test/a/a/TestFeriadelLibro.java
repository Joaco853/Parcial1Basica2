package a.a;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import unlam.edu.ar.pb2.parcial.src.Entrada;
import unlam.edu.ar.pb2.parcial.src.Feria;
import unlam.edu.ar.pb2.parcial.src.Persona;
import unlam.edu.ar.pb2.parcial.src.TipoPersona;

public class TestFeriadelLibro {
	@Test // Sebastian
	public void queSePuedaAgregarUnaPersonaAlaFeria() {
		String nombreDeLaFeria = "FeriaDelLibro";
		String ubicacionFeria = "La Rural";
		Integer tamaño = 2000;
		Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

		String nombre = "Juan";
		String apellido = "Perez";
		Integer nroDni = 42351234;
		Integer edad = 30;
		TipoPersona tipoPersona = TipoPersona.ADULTO;
		Double dinero = 5000.0;
		Persona persona = new Persona(nombre, apellido, nroDni, edad, tipoPersona, dinero);

		// se agrega una persona al array para luego verificar su existencia en la misma
		feria.agregarPersona(persona);
		Integer valorObtenido = feria.obtenerCantidadPersonas();
		Integer valorEsperado = 1;
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test // Sebastian
	public void queSePuedaAgregarUnaEntradaAlaFeria() {
		String nombreDeLaFeria = "FeriaDelLibro";
		String ubicacionFeria = "La Rural";
		Integer tamaño = 2000;
		Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

		Integer numeroentrada = 1111;
		Boolean sinUsar = true;
		Double precioEntrada = 2000.0;
		Entrada entrada = new Entrada(numeroentrada, sinUsar, precioEntrada);

		// se agrega una entrada al array para luego verificar su existencia en la misma
		feria.agregarEntrada(entrada);
		Integer valorObtenido = feria.obtenerCantidadDeEntradas();
		Integer valorEsperado = 1;

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test // Sebastian
	public void queLaFeriaLeVendaUnaEntradaAUnaPersona() {
		String nombreDeLaFeria = "FeriaDelLibro";
		String ubicacionFeria = "La Rural";
		Integer tamaño = 2000;
		Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

		// se "muestra" el dia de la semana con respecto a la fecha actual
		LocalDate fechaActual = LocalDate.now();
		DayOfWeek diaSemana = fechaActual.getDayOfWeek();

		String nombre = "Juan";
		String apellido = "Perez";
		Integer nroDni = 42351234;
		Integer edad = 30;
		TipoPersona tipoPersona = TipoPersona.ADULTO;
		Double dinero = 5000.0;
		Persona persona = new Persona(nombre, apellido, nroDni, edad, tipoPersona, dinero);

		feria.agregarPersona(persona);

		Integer numeroentrada = 1111;
		Boolean sinUsar = true;
		Double precioEntrada = 2000.0;
		Entrada entrada = new Entrada(numeroentrada, sinUsar, precioEntrada);

		feria.agregarEntrada(entrada);

		feria.venderEntrada(persona, entrada, diaSemana);

		// Verificar si la persona tiene una entrada
		boolean verficarSiPersonaTieneEntrada = feria.getAsignacionEntrada().containsKey(persona);
		assertTrue(verficarSiPersonaTieneEntrada);

		// Verificar que la entrada es la correcta
		assertEquals(numeroentrada, feria.getAsignacionEntrada().get(persona).getNumeroEntrada());

	}
}