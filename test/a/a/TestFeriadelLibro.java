package a.a;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFeriadelLibro {

	@Test
	public void  QuesePuedaAgregarunStantenunPabellonYQueNoSeaRepetido() {
		
		String NombreEditorial ="Siglo veintiuno";
		Integer metroscuadradosocupados = 20;
		Integer ubicacion = 514;
		Stant stante = new Stant(NombreEditorial, metroscuadradosocupados, ubicacion);
		
		String NombrePabellon ="Pabellon Azul";
		Pabellon pabellon =new Pabellon(NombrePabellon);
		
		pabellon.agregarunstant(stante);
		pabellon.agregarunstant(stante);

		Integer numerodestantsesperados= 1;
		
		assertEquals(numerodestantsesperados.intValue(),pabellon.getstants().size());
	}


	@Test
	public void  QueunaPersonaNoPuedaEntrarMasDeUnaVezConLaMismaEntrada() {
		
		
		Persona persona = new Persona();
		Integer numeroentrada=1111;
		Entrada entrada= new Entrada(numeroentrada);
		
		
		Boolean entradacompradacorrectamente = persona.entradacomprada(entrada);
		Boolean entrocorrectamente = persona.usarentrada(entrada);
		
		assertTrue(entradacompradacorrectamente);
		assertTrue(entrocorrectamente);
	
		Boolean entradacompradacorrectamente2 = persona.entradacomprada(entrada);
		Boolean entrocorrectamente2 = persona.usarentrada(entrada);
		
		assertFalse(entradacompradacorrectamente2);
		assertFalse(entrocorrectamente2);
		
	}
	
	@Test
	public void  QueunaAlumnoPagueLaEntradaUnDiaDomingoPerounDocenteNoYPuedanIngresar() {
		
		Alumno alumno = new Alumno();
		String Dia = "Domingo";
		Integer numeroentrada=1111;
		Entrada entrada= new Entrada(numeroentrada);
		
		Docente docente = new Docente();
		Integer numeroentrada2=2222;
		Entrada entrada2= new Entrada(numeroentrada2);

		
		Boolean entradacompradacorrectamente = alumno.entradacomprada(entrada,Dia);
		Boolean entrocorrectamente = alumno.usarentrada(entrada);
		
		assertTrue(entradacompradacorrectamente);
		assertTrue(entrocorrectamente);
		
		Boolean entradacompradacorrectamente2 = docente.entradacomprada(entrada2);
		Boolean entrocorrectamente2 = docente.usarentrada(entrada2);
		
		assertTrue(entradacompradacorrectamente2);
		assertTrue(entrocorrectamente2);
		
	}
	
}