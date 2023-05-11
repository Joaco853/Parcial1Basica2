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

}
