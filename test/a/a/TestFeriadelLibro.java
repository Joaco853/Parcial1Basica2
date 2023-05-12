package a.a;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
	
	@Test
	public void  Quesiunalumnopagounaentradatengaun10porcientodedescuentoencomprasmayoresde2000() {
		
		Alumno alumno = new Alumno();
		String Dia = "Domingo";
		Integer numeroentrada=1111;
		Entrada entrada= new Entrada(numeroentrada);
		alumno.entradacomprada(entrada,Dia);
		Double ValorCompra=4000.0;
		Compra compra = new Compra(ValorCompra);
		
		Double Valorobtenido1 = alumno.valorrealizacompra(compra);

		Alumno alumno2 = new Alumno();
		String Dia2 = "Lunes";
		Integer numeroentrada2=2222;
		Entrada entrada2= new Entrada(numeroentrada2);
		alumno2.entradacomprada(entrada2,Dia2);
		Double ValorCompra2=4000.0;
		Compra compra2 = new Compra(ValorCompra2);
		
		Double Valorobtenido2 = alumno2.valorrealizacompra(compra2);

		Double Valoresperado1= 3600.0;
		Double Valoresperado2= 4000.0;

		assertEquals(Valorobtenido1, Valoresperado1);
		assertEquals(Valorobtenido2, Valoresperado2);
		
		
	}
	
	@Test
	public void  Queundocenterealicevariascomprasenunstant() {
		
		String NombreEditorial ="Siglo veintiuno";
		Integer metroscuadradosocupados = 20;
		Integer ubicacion = 514;
		Stant stante = new Stant(NombreEditorial, metroscuadradosocupados, ubicacion);

		
		Docente docente = new Docente();
		Integer numeroentrada2=2222;
		Entrada entrada2= new Entrada(numeroentrada2);
		
		Double ValorCompra=4000.0;
		Compra compra = new Compra(ValorCompra);
		docente.valorrealizacompra(compra);
		
		stante.agregarunaventa(compra,docente);
		stante.agregarunaventa(compra,docente);
		
		Integer numerodestantsesperados= 2;

		assertEquals(numerodestantsesperados.intValue(),stante.Ventas.size());

}
	
	@Test
	public void agregarUnaPersonaALaListaDeVisitantesQueFueALaFeria() {
		 Feria feria;
		    Alumno alumno;
		    Docente docente;
		    Persona visitante;
		    List<Persona> personasQueEntraron;

		    feria = new Feria("Feria del Libro");
		    personasQueEntraron = new ArrayList<>();

		    alumno = new Alumno();
		    Entrada entradaAlumno = new Entrada(1000);
		    alumno.entradacomprada(entradaAlumno, "Lunes");
		    personasQueEntraron.add(alumno);
		

		    docente = new Docente();
		    Entrada entradaDocente = new Entrada(1010);
		    docente.entradacomprada(entradaDocente);
		    personasQueEntraron.add(docente);
		    

		    visitante = new Persona();
		    Entrada entradaVisitante = new Entrada(1050);
		    visitante.entradacomprada(entradaVisitante);
		    personasQueEntraron.add(visitante);
		    
		    feria.agregarVisitante(alumno);
		    feria.agregarVisitante(docente);
		    feria.agregarVisitante(visitante);
		    
		    assertEquals(3, feria.getVisitantes().size());
		    assertEquals(personasQueEntraron,feria.getVisitantes());

		}
	
	@Test
	public void aplicarDescuentoSiTieneDescuentoLaCategoriaQueTengaElLibro() {
        Libro libro = new Libro("El Quijote", "Miguel de Cervantes", "Novela", 100.0);
        
        Compra compra = new Compra(libro, 100.0);
        compra.setDescuentoporcomprarentrada(true);

        assertEquals(80.0, compra.valorLibroPorDescuento(), 0.001);
    }
	
	@Test
	public void queNoSeApliqueElDescuentoSiLaCategoriaNoTieneDescuento() {
		Libro libro = new Libro("fantasma de canterville", "Oscar Wilde", "Fantasia", 100.0);
        
        Compra compra = new Compra(libro, 100.0);
        compra.setDescuentoporcomprarentrada(true);

        assertEquals(100.0, compra.valorLibroPorDescuento(), 0.001);
	}
	
	@Test
	public void hacerUnaBusquedaDeUnLibroPorNombreYDevuelveElLibro() {
	Stant stant;
	Libro libro1;
	Libro libro2;
	Libro libro3;
	
	stant = new Stant("Editorial Luna",50,2);
	libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 29.99);
    libro2 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Novela", 24.99);
    libro3 = new Libro("1984", "George Orwell", "Ciencia ficción", 19.99);

    stant.agregarLibro(libro1);
    stant.agregarLibro(libro2);
    stant.agregarLibro(libro3);
    
    String nombre = "Cien años de soledad";
    List<Libro> resultado = stant.buscarLibroPorNombre(nombre);
    
    Assert.assertNotNull(resultado);
    Assert.assertFalse(resultado.isEmpty());
    for(Libro libro: resultado) {
    	Assert.assertEquals(nombre, libro.getTitulo());
    }
	}
    
	@Test
    public void hacerUnaBusquedaDeUnLibroPorNombreYSiNoLoEncuentraDevuelvaVacio() {
    	Stant stant;
    	Libro libro1;
    	Libro libro2;
    	Libro libro3;
    	
    	stant = new Stant("Editorial Luna",50,2);
    	libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 29.99);
        libro2 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Novela", 24.99);
        libro3 = new Libro("1984", "George Orwell", "Ciencia ficción", 19.99);

        stant.agregarLibro(libro1);
        stant.agregarLibro(libro2);
        stant.agregarLibro(libro3);
        
        String nombre = "El Principito";
        List<Libro> resultado = stant.buscarLibroPorNombre(nombre);
        
        Assert.assertNotNull(resultado);
        Assert.assertTrue(resultado.isEmpty());
	}
	
}