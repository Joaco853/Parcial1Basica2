package a.a;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import unlam.edu.ar.pb2.parcial.src.Entrada;
import unlam.edu.ar.pb2.parcial.src.Feria;
import unlam.edu.ar.pb2.parcial.src.Libro;
import unlam.edu.ar.pb2.parcial.src.Persona;
import unlam.edu.ar.pb2.parcial.src.Stant;
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
	
	// Sebastian
		@Test
		public void queLasPersonasMenores12AniosDebenEntrarConAcompanianteAdulto() {
			String nombreDeLaFeria = "FeriaDelLibro";
			String ubicacionFeria = "La Rural";
			Integer tamaño = 2000;
			Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

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

			String nombre1 = "Martin";
			String apellido1 = "Perez";
			Integer nroDni1 = 42351234;
			Integer edad1 = 11;
			Double dinero1 = 5000.0;
			TipoPersona tipoPersona1 = TipoPersona.MENOR;
			Persona persona1 = new Persona(nombre1, apellido1, nroDni1, edad1, tipoPersona1, dinero1);

			feria.agregarPersona(persona1);

			Integer numeroentrada2 = 2222;
			Boolean sinUsar = true;
			Double precioEntrada = 2000.0;
			Entrada entrada2 = new Entrada(numeroentrada2, sinUsar, precioEntrada);

			feria.agregarEntrada(entrada2);

			Integer numeroentrada = 1111;
			Boolean sinUsar1 = true;
			Double precioEntrada1 = 2000.0;
			Entrada entrada = new Entrada(numeroentrada, sinUsar1, precioEntrada1);

			feria.agregarEntrada(entrada);

			feria.venderEntrada(persona, entrada, diaSemana);
			feria.venderEntrada(persona1, entrada, diaSemana);

			Boolean valorObtenido = feria.verificarQueUnMenorTengaAUnAdulto(persona1);

			boolean valorEsperado = true;
			assertEquals(valorEsperado, valorObtenido);
		}

		@Test // Sebastian
		public void queLosDiasMiercolesLosAdultosMayoresTenganDescuentosEnNovelas() {
			String nombreDeLaFeria = "FeriaDelLibro";
			String ubicacionFeria = "La Rural";
			Integer tamaño = 2000;
			Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

			DayOfWeek diaSemana = DayOfWeek.WEDNESDAY;

			String nombre = "Martin";
			String apellido = "Perez";
			Integer nroDni = 42351234;
			Integer edad = 70;
			Double dinero = 5000.0;
			TipoPersona tipoPersona = TipoPersona.ADULTO_MAYOR;
			Persona adultoMayor = new Persona(nombre, apellido, nroDni, edad, tipoPersona, dinero);

			feria.agregarPersona(adultoMayor);

			String editorial = "Editorial Luz";
			Integer tamanio = 33;
			Integer ubicacion = 5;
			Stant stant = new Stant(editorial, tamanio, ubicacion);

			feria.agregarStant(stant);

			String titulo = "El cambino de los reyes";
			String autor = "Brandon Sanderson";
			String categoria = "Novela";
			Double precio = 3000.0;
			Libro libro = new Libro(titulo, autor, categoria, precio);

			stant.agregarLibro(libro);

			stant.venderLibroNovelas(adultoMayor, libro, diaSemana);

		}

		@Test // Sebastian
		public void queLosDiasMiercolesLosAdultosMayoresConMenosDe60AniosNoTenganDescuentosEnNovelas() {
			String nombreDeLaFeria = "FeriaDelLibro";
			String ubicacionFeria = "La Rural";
			Integer tamaño = 2000;
			Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

			DayOfWeek diaSemana = DayOfWeek.WEDNESDAY;

			String nombre = "Martin";
			String apellido = "Perez";
			Integer nroDni = 42351234;
			Integer edad = 70;
			Double dinero = 5000.0;
			TipoPersona tipoPersona = TipoPersona.ADULTO_MAYOR;
			Persona adultoMayor = new Persona(nombre, apellido, nroDni, edad, tipoPersona, dinero);

			feria.agregarPersona(adultoMayor);

			String editorial = "Editorial Luz";
			Integer tamanio = 33;
			Integer ubicacion = 5;
			Stant stant = new Stant(editorial, tamanio, ubicacion);

			feria.agregarStant(stant);

			String titulo = "El cambino de los reyes";
			String autor = "Brandon Sanderson";
			String categoria = "Novela";
			Double precio = 3000.0;
			Libro libro = new Libro(titulo, autor, categoria, precio);

			stant.agregarLibro(libro);

			stant.venderLibroNovelas(adultoMayor, libro, diaSemana);
		}

		@Test // Sebastian
		public void queLasPersonasMenoresA12AniosTenganDescuentoParaComprarLibrosInfantiles() {
			String nombreDeLaFeria = "FeriaDelLibro";
			String ubicacionFeria = "La Rural";
			Integer tamaño = 2000;
			Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

			String editorial = "Editorial Luz";
			Integer tamanio = 33;
			Integer ubicacion = 5;
			Stant stant = new Stant(editorial, tamanio, ubicacion);

			String nombre = "Martin";
			String apellido = "Perez";
			Integer nroDni = 42351234;
			Integer edad = 11;
			Double dinero = 5000.0;
			TipoPersona tipoPersona = TipoPersona.MENOR;
			Persona menor = new Persona(nombre, apellido, nroDni, edad, tipoPersona, dinero);

			Integer numeroentrada = 2002;
			Boolean sinUsar = true;
			Double precioEntrada = 2000.0;
			Entrada entrada = new Entrada(numeroentrada, sinUsar, precioEntrada);

			String titulo = "El Principito";
			String autor = "Antoine de Saint-Exupéry";
			String categoria = "Infantil";
			Double precio = 30.0;
			Libro libro = new Libro(titulo, autor, categoria, precio);

			feria.agregarStant(stant);
			feria.agregarEntrada(entrada);
			feria.agregarPersona(menor);
			stant.agregarLibro(libro);
			// String categoriaLibroParaMenores = "Infantil";

			Double descuento = libro.getPrecio() - (libro.getPrecio() * 0.2); // Descuento del 20%

			feria.agregarStant(stant);
			stant.agregarLibro(libro);

			assertEquals(descuento, stant.venderLibroInfantil(menor, libro), 0.01);
		}

		@Test // Sebastian
		public void queLasPersonasMAyoresA12AniosNoTenganDescuentoParaComprarLibrosInfantiles() {
			String nombreDeLaFeria = "FeriaDelLibro";
			String ubicacionFeria = "La Rural";
			Integer tamaño = 2000;
			Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

			String editorial = "Editorial Paz";
			Integer tamanio = 33;
			Integer ubicacion = 5;
			Stant stant = new Stant(editorial, tamanio, ubicacion);

			String nombre = "Carlos";
			String apellido = "Perez";
			Integer nroDni = 42351234;
			Integer edad = 30;
			Double dinero = 5000.0;
			TipoPersona tipoPersona = TipoPersona.ADULTO;
			Persona mayor = new Persona(nombre, apellido, nroDni, edad, tipoPersona, dinero);

			Integer numeroentrada = 1265;
			Boolean sinUsar = true;
			Double precioEntrada = 2000.0;
			Entrada entrada = new Entrada(numeroentrada, sinUsar, precioEntrada);

			String titulo = "El Principito";
			String autor = "Antoine de Saint-Exupéry";
			String categoria = "Infantil";
			Double precio = 30.0;
			Libro libro = new Libro(titulo, autor, categoria, precio);

			feria.agregarStant(stant);
			feria.agregarEntrada(entrada);
			feria.agregarPersona(mayor);
			stant.agregarLibro(libro);
			// String categoriaLibroParaMenores = "Infantil";

			feria.agregarStant(stant);
			stant.agregarLibro(libro);

			assertEquals(libro.getPrecio(), stant.venderLibroInfantil(mayor, libro), 0.01);
		}

		@Test // Sebastian
		public void queLosLibrosDeGeneroTerrorSoloPuedanComprarloLosAdultosMayoresDe18() {
			String nombreDeLaFeria = "FeriaDelLibro";
			String ubicacionFeria = "La Rural";
			Integer tamaño = 2000;
			Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

			String editorial = "Editorial Estrella";
			Integer tamanio = 33;
			Integer ubicacion = 5;
			Stant stant = new Stant(editorial, tamanio, ubicacion);

			String nombre = "Gaston";
			String apellido = "Rodriguez";
			Integer nroDni = 23351234;
			Integer edad = 25;
			Double dinero = 5000.0;
			TipoPersona tipoPersona = TipoPersona.ADULTO;
			Persona adulto = new Persona(nombre, apellido, nroDni, edad, tipoPersona, dinero);

			Integer numeroentrada = 1265;
			Boolean sinUsar = true;
			Double precioEntrada = 2000.0;
			Entrada entrada = new Entrada(numeroentrada, sinUsar, precioEntrada);

			String titulo = "Dracula";
			String autor = "Bram Stoker";
			String categoria = "Terror";
			Double precio = 900.0;
			Libro libro = new Libro(titulo, autor, categoria, precio);

			feria.agregarStant(stant);
			feria.agregarEntrada(entrada);
			feria.agregarPersona(adulto);
			stant.agregarLibro(libro);

			feria.agregarStant(stant);
			stant.agregarLibro(libro);

			assertTrue(stant.venderLibroTerror(adulto, libro));

		}

		@Test // Sebastian
		public void queLosLibrosDeGeneroTerrorNoLoPuedanComprarloLosAvisitantesMenoresDe18() {
			String nombreDeLaFeria = "FeriaDelLibro";
			String ubicacionFeria = "La Rural";
			Integer tamaño = 2000;
			Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

			String editorial = "Editorial Estrella";
			Integer tamanio = 33;
			Integer ubicacion = 5;
			Stant stant = new Stant(editorial, tamanio, ubicacion);

			feria.agregarStant(stant);

			String nombre = "Gaston";
			String apellido = "Rodriguez";
			Integer nroDni = 23351234;
			Integer edad = 25;
			Double dinero = 5000.0;
			TipoPersona tipoPersona = TipoPersona.ADULTO;
			Persona adulto = new Persona(nombre, apellido, nroDni, edad, tipoPersona, dinero);

			feria.agregarPersona(adulto);

			String nombre1 = "Juan";
			String apellido1 = "Rodriguez";
			Integer nroDni1 = 53351234;
			Integer edad1 = 9;
			Double dinero1 = 5000.0;
			TipoPersona tipoPersona1 = TipoPersona.MENOR;
			Persona menor = new Persona(nombre1, apellido1, nroDni1, edad1, tipoPersona1, dinero1);

			feria.agregarPersona(menor);

			Integer numeroentrada = 1265;
			Boolean sinUsar = true;
			Double precioEntrada = 2000.0;
			Entrada entrada = new Entrada(numeroentrada, sinUsar, precioEntrada);

			feria.agregarEntrada(entrada);

			String titulo = "Dracula";
			String autor = "Bram Stoker";
			String categoria = "Terror";
			Double precio = 900.0;
			Libro libro = new Libro(titulo, autor, categoria, precio);

			stant.agregarLibro(libro);

			assertFalse(stant.venderLibroTerror(menor, libro));

		}
		
}