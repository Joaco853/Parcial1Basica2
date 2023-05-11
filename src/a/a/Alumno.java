package a.a;

public class Alumno extends Persona {

	String[] dias = new String[] {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	
	public Alumno() {
		super();
	}
	
	@Override
	public Boolean entradacomprada(Entrada entrada, String dia) {
		Boolean Entradanueva=false;

		if(diaentrada(dia)) {
		
		//Pregunta si la persona ya tiene o no la entrada entrada y si no la tiene la compra
		
		if(!Entradas.contains(entrada)){
			Entradanueva= true;
			Entradas.add(entrada);
		
			return Entradanueva;
		}
		}
		
		
		return Entradanueva;
	}

	
//	Los Viernes,Sabados y Domingos los Alumnos no ingresan gratis
	public Boolean diaentrada(String dia) {
		Boolean aceptado=false;
		// TODO Auto-generated method stub
		Integer i=0;
		for (String diaas : dias) {
			i++;
			if(dia.equals(diaas) && i>=4) {
				aceptado=pagarentrada();
				return aceptado;
			}
		}
		
		return aceptado=nopagaentrada();
	}





}
