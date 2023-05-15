package a.a;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

public class TestFeriadelLibro {
	
	@Test // Joaquin
	public void QuesePuedaAgregarUnStantEnUnPabellonYQueNoSeaRepetido() {

		String NombreEditorial = "Siglo veintiuno";
		Integer metroscuadradosocupados = 20;
		Integer ubicacion = 514;

		Stant stant = new Stant(NombreEditorial, metroscuadradosocupados, ubicacion);

		String NombrePabellon = "Pabellon Azul";
		Pabellon pabellon = new Pabellon(NombrePabellon);

		pabellon.agregarunstant(stant);
		pabellon.agregarunstant(stant);

		Integer numerodestantsesperados = 1;

		assertEquals(numerodestantsesperados.intValue(), pabellon.getstants().size());
	}

	@Test // Joaquin
	public void QueunaPersonaNoPuedaEntrarMasDeUnaVezConLaMismaEntradaALaFeria() {
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

		Integer numeroentrada = 1111;
		Boolean sinUsar = true;
		Double precioEntrada = 2000.0;
		Entrada entrada = new Entrada(numeroentrada, sinUsar, precioEntrada);

		feria.agregarEntrada(entrada);

		// Verificamos que la persona no está presente en el mapa de asignación de
		// entradas

		assertFalse(feria.getAsignacionEntrada().containsKey(persona));

		// Vendemos una entrada a una persona

		feria.venderEntrada(persona, entrada, diaSemana);
		// Verificamos que la persona este presente en el mapa

		assertTrue(feria.getAsignacionEntrada().containsKey(persona));

		// Intentamos venderle nuevamente la entrada, por ende al no poder vender la
		// misma entrada que poseé no puede volver a utilizarla
		feria.venderEntrada(persona, entrada, diaSemana);

		// Verificamos que no se haya realizado la venta nuevamente
		Integer valorEsperado = 1;
		Integer valorObtenido = feria.getAsignacionEntrada().size();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test // Joaquin
	public void QueUnAlumnoPagueLaEntradaUnDiaDomingoPeroUnDocenteNoYPuedanIngresarAmbos() {
		String nombreDeLaFeria = "FeriaDelLibro";
		String ubicacionFeria = "La Rural";
		Integer tamaño = 2000;
		Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

		DayOfWeek diaSemana = DayOfWeek.SUNDAY;

		String nombre = "Juan";
		String apellido = "Perez";
		Integer nroDni = 42351234;
		Integer edad = 16;
		String institucion = "Jose Hernandez";
		Double dinero = 5000.0;
		TipoPersona tipoPersona = TipoPersona.ALUMNO;
		Alumno alumno = new Alumno(nombre, apellido, nroDni, edad, tipoPersona, institucion, dinero);

		feria.agregarPersona(alumno);

		String nombreDocente = "Romina";
		String apellidoDocente = "Mendez";
		Integer nroDniDocente = 39323234;
		Integer edadDocente = 30;
		String institucionDocente = "Jose Hernandez";
		Double dineroDocente = 15000.0;
		TipoPersona tipoPersonaDocente = TipoPersona.DOCENTE;
		Docente docente = new Docente(nombreDocente, apellidoDocente, nroDniDocente, edadDocente, tipoPersonaDocente,
				institucionDocente, dineroDocente);

		feria.agregarPersona(docente);

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

		feria.venderEntrada(alumno, entrada, diaSemana);

		// se le descuenta el dinero por el valor de la entrada ya que lo dias
		// viernes,sabados y domingos deben pagar los alumnos
		Double valorEsperado = 3000.0;
		Double valorObtenido = alumno.getDinero();
		assertEquals(valorEsperado, valorObtenido);

		// las docentes no deben abonar el dia domingo
		feria.venderEntrada(docente, entrada, diaSemana);
		Double valorEsperado1 = 15000.0;
		Double valorObtenido1 = docente.getDinero();
		assertEquals(valorEsperado1, valorObtenido1);

	}
	
	@Test	// Joaquin
	public void  QueSiunAlumnoPagounaEntradaTengaun10PorcientodeDescuentoenCompras() {
		
		String nombreDeLaFeria = "FeriaDelLibro";
		String ubicacionFeria = "La Rural";
		Integer tamaño = 2000;
		Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);

		DayOfWeek diaSemana = DayOfWeek.SUNDAY;

		String nombre = "Juan";
		String apellido = "Perez";
		Integer nroDni = 42351234;
		Integer edad = 16;
		String institucion = "Jose Hernandez";
		Double dinero = 5000.0;
		TipoPersona tipoPersona = TipoPersona.ALUMNO;
		Alumno alumno = new Alumno(nombre, apellido, nroDni, edad, tipoPersona, institucion, dinero);
		
		Integer numeroentrada = 1111;
		Boolean sinUsar = true;
		Double precioEntrada = 2000.0;
		Entrada entrada = new Entrada(numeroentrada, sinUsar, precioEntrada);

		feria.agregarEntrada(entrada);
		
		feria.venderEntrada(alumno, entrada, diaSemana);

		
		Double ValorCompra=4000.0;
		Compra compra = new Compra(ValorCompra, alumno);
		
		Double Valorobtenido1 = compra.valorapagarcompra();

		Double Valoresperado1= 3600.0;

		assertEquals(Valorobtenido1, Valoresperado1);
	
	}
	
	@Test	// Joaquin
	public void  QueSeRegistrenLasVentasEnUnStant() {
		
		String NombreEditorial ="Siglo veintiuno";
		Integer metroscuadradosocupados = 20;
		Integer ubicacion = 514;
		Stant stante = new Stant(NombreEditorial, metroscuadradosocupados, ubicacion);

		DayOfWeek diaSemana = DayOfWeek.SUNDAY;

		
		String nombreDeLaFeria = "FeriaDelLibro";
		String ubicacionFeria = "La Rural";
		Integer tamaño = 2000;
		Feria feria = new Feria(nombreDeLaFeria, ubicacionFeria, tamaño);
		
		String nombreDocente = "Romina";
		String apellidoDocente = "Mendez";
		Integer nroDniDocente = 39323234;
		Integer edadDocente = 30;
		String institucionDocente = "Jose Hernandez";
		Double dineroDocente = 15000.0;
		TipoPersona tipoPersonaDocente = TipoPersona.DOCENTE;
		Docente docente = new Docente(nombreDocente, apellidoDocente, nroDniDocente, edadDocente, tipoPersonaDocente,
				institucionDocente, dineroDocente);

		feria.agregarPersona(docente);

		Integer numeroentrada = 1111;
		Boolean sinUsar1 = true;
		Double precioEntrada1 = 2000.0;
		Entrada entrada = new Entrada(numeroentrada, sinUsar1, precioEntrada1);

		feria.agregarEntrada(entrada);

		feria.venderEntrada(docente, entrada, diaSemana);

		
		Double ValorCompra=4000.0;
		Compra compra = new Compra(ValorCompra);
				
		stante.agregarunaventa(compra,docente);
		stante.agregarunaventa(compra,docente);
		
		Integer numerodestantsesperados= 2;

		assertEquals(numerodestantsesperados.intValue(),stante.Ventas.size());

}
	
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
		@Test // Jonatan
		public void agregarUnaPersonaALaListaDeVisitantesQueFueALaFeria() {
			Feria feria;
			Alumno alumno;
			Docente docente;
			Persona visitante;
			List<Persona> personasQueEntraron;
			DayOfWeek dia = DayOfWeek.SUNDAY;

			feria = new Feria("Feria del Libro", "San Justo", 1000);
			personasQueEntraron = new ArrayList<>();

			docente = new Docente("Mary", "Jane", 987654321, 35, TipoPersona.DOCENTE, "Colegio ABC", 50.0);
			alumno = new Alumno("Magnus", "Carlsen", 123456789, 15, TipoPersona.ALUMNO, "Instituto XYZ", 50.0);
			visitante = new Persona("Alex", "Rose", 567891234, 30, TipoPersona.ADULTO, 100.0);

			Entrada entradaAlumno = new Entrada(1000, true, 1000.0);
			Entrada entradaDocente = new Entrada(1000, true, 1000.0);
			Entrada entradaVisitante = new Entrada(1000, true, 1000.0);

			feria.agregarEntrada(entradaAlumno);
			feria.agregarEntrada(entradaDocente);
			feria.agregarEntrada(entradaVisitante);

			feria.venderEntrada(alumno, entradaAlumno, dia);
			feria.venderEntrada(docente, entradaDocente, dia);
			feria.venderEntrada(visitante, entradaVisitante, dia);

			feria.agregarPersona(alumno);
			feria.agregarPersona(docente);
			feria.agregarPersona(visitante);

			personasQueEntraron.add(alumno);
			personasQueEntraron.add(docente);
			personasQueEntraron.add(visitante);

			assertEquals(3, feria.getPersonas().size());
			assertEquals(3, feria.getEntradas().size());
			assertEquals(personasQueEntraron, feria.getPersonas());
		}

		@Test // Jonatan
		public void aplicarDescuentoSiTieneDescuentoLaCategoriaQueTengaElLibro() {
			Feria feria;
			Stant stant;
			Libro libro;
			Entrada entrada;
			Persona visitante;
			DayOfWeek dia = DayOfWeek.SUNDAY;  
			
			visitante = new Persona("Jhon", "Wick", 567891234, 30, TipoPersona.ADULTO, 100.0);
			feria = new Feria("Feria del Libro", "San Justo", 50);
			entrada = new Entrada(1000,true,1000.0);
		
			feria.agregarEntrada(entrada);
			feria.agregarPersona(visitante);
			feria.venderEntrada(visitante, entrada, dia);
			
			feria = new Feria("Feria del Libro","San Justo", 1000);
			stant = new Stant("Editorial Luna", 50, 2);
			libro = new Libro("El Quijote", "Miguel de Cervantes", "Novela", 100.0);
			String categoria = "Novela";
			
			Double descuento = libro.getPrecio() - (libro.getPrecio()*0.2);

			feria.agregarStant(stant);
			stant.agregarLibro(libro);
			
			assertEquals(descuento,stant.DescuentosPorCategoria(visitante, libro, categoria), 0.01);
		}
		
		@Test // Jonatan
		public void queNoSeApliqueElDescuentoSiLaCategoriaNoTieneDescuento() {
			Feria feria;
			Stant stant;
			Libro libro;
			Entrada entrada;
			Persona visitante;
			DayOfWeek dia = DayOfWeek.SUNDAY;  
			
			visitante = new Persona("Willy", "Smith", 567891234, 33, TipoPersona.ADULTO, 100.0);
			feria = new Feria("Feria del Libro", "San Justo", 50);
			entrada = new Entrada(1000,true,1000.0);
		
			feria.agregarEntrada(entrada);
			feria.agregarPersona(visitante);
			feria.venderEntrada(visitante, entrada, dia);
			
			feria = new Feria("Feria del Libro","San Justo", 1000);
			stant = new Stant("Editorial Luna", 50, 2);
			libro = new Libro("1984", "George Orwell", "Ciencia ficción", 19.99);
			String categoria = "Fantasia";
			
			

			feria.agregarStant(stant);
			stant.agregarLibro(libro);
			 
			//Deberia Devolver el precio normal del libro sin descuentos
			assertEquals(libro.getPrecio(),stant.DescuentosPorCategoria(visitante, libro, categoria), 0.01);
		}
		
		@Test // Jonatan
		public void hacerUnaBusquedaDeUnLibroPorNombreYDevuelveElLibro() {
			Feria feria;
			Stant stant;
			Libro libro1;
			Libro libro2;
			Libro libro3;
			
			feria = new Feria("Feria del Libro", "San Justo", 50);
			stant = new Stant("Editorial Sol", 50, 2);
			libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 29.99);
			libro2 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Novela", 24.99);
			libro3 = new Libro("1984", "George Orwell", "Ciencia ficción", 19.99);
			
			feria.agregarStant(stant);
			stant.agregarLibro(libro1);
			stant.agregarLibro(libro2);
			stant.agregarLibro(libro3);
			
			String nombre = "Cien años de soledad";
			List<Libro> resultado = stant.buscarLibroPorNombre(nombre);

			assertNotNull(resultado);
			assertTrue(resultado.isEmpty());
			for (Libro libro : resultado) {
				assertEquals(nombre, libro.getTitulo());
			}
		}
		
		@Test // Jonatan
		public void hacerUnaBusquedaDeUnLibroPorNombreYSiNoLoEncuentraDevuelvaVacio() {
			Feria feria;
			Stant stant;
			Libro libro1;
			Libro libro2;
			Libro libro3;
			
			feria = new Feria("Feria del Libro", "San Justo", 50);
			
			stant = new Stant("Editorial Luna", 50, 2);
			
			libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 29.99);
			libro2 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Novela", 24.99);
			libro3 = new Libro("1984", "George Orwell", "Ciencia ficción", 19.99);
			
			feria.agregarStant(stant);
			stant.agregarLibro(libro1);
			stant.agregarLibro(libro2);
			stant.agregarLibro(libro3);

			String nombre = "El Principito";
			List<Libro> resultado = stant.buscarLibroPorNombre(nombre);

			assertNotNull(resultado);
			assertTrue(resultado.isEmpty());
		}
		
		@Test // Jonatan
		public void buscaLosLibrosSegunSuCategoriaYDevuelveUnaListaConLosLibros() {
			Feria feria;
			Stant stant;
			Libro libro1;
			Libro libro2;
			Libro libro3;
			
			feria = new Feria("Feria del Libro", "San Justo", 50);
			stant = new Stant("Editorial Estrella", 50, 2);
			
			libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 29.99);
			libro2 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Novela", 24.99);
			libro3 = new Libro("1984", "George Orwell", "Ciencia ficción", 19.99);
			
			feria.agregarStant(stant);
			
			stant.agregarLibro(libro1);
			stant.agregarLibro(libro2);
			stant.agregarLibro(libro3);

			String categoria = "Novela";
			List<Libro> resultado = stant.buscarPorCategoria(categoria);

			for (Libro libro : resultado) {
				assertEquals(categoria, libro.getCategoria());
			}
		}
		
		@Test // Jonatan
		public void buscaLosLibrosSegunSuCategoriaYSiNoHayLibrosDeEsaCategoriaDevuelvaUnaListaVacia() {
			Feria feria;
			Stant stant;
			Libro libro1;
			Libro libro2;
			Libro libro3;
			
			feria = new Feria("Feria del Libro", "San Justo", 50);
			stant = new Stant("Editorial Estrella", 50, 2);
			
			feria.agregarStant(stant);
			
			libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 29.99);
			libro2 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Novela", 24.99);
			libro3 = new Libro("1984", "George Orwell", "Ciencia ficción", 19.99);

			stant.agregarLibro(libro1);
			stant.agregarLibro(libro2);
			stant.agregarLibro(libro3);

			String categoria = "Fabula";
			List<Libro> resultado = stant.buscarPorCategoria(categoria);

			assertNotNull(resultado);
			assertTrue(resultado.isEmpty());

		}
		
}