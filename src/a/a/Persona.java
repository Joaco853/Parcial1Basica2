package a.a;

import java.util.ArrayList;

public class Persona {
	
	ArrayList<Entrada> Entradas = new ArrayList<>();
	Boolean pagoentradas = false;

	
	public Boolean entradacomprada(Entrada entrada) {
		// TODO Auto-generated method stub
		Boolean Entradanueva=false;

		//Pregunta si la persona ya tiene o no la entrada entrada y si no la tiene la compra
		
		if(!Entradas.contains(entrada)){
			Entradanueva= true;
			Entradas.add(entrada);
		
			return Entradanueva;
		}
		
		return Entradanueva;
	}
	
	public Boolean usarentrada(Entrada entrada) {
		
		Boolean Entradausadacorrectamente=false;
		
			for (Entrada entrada2 : Entradas) {
				if(entrada2.equals(entrada)){
					if(entrada2.usar()) {
					Entradausadacorrectamente =true;
					return true;
					}
				}
			}
		
		return Entradausadacorrectamente;
		
	}

	public Boolean entradacomprada(Entrada entrada, String dia) {
		// TODO Auto-generated method stub
		return null;

	}
	public Boolean pagarentrada() {
		// TODO Auto-generated method stub
		pagoentradas = true;

		return pagoentradas;
	}
	public Boolean nopagaentrada() {
		// TODO Auto-generated method stub
		return true;
	}
}