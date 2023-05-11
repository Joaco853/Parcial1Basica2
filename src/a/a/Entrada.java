package a.a;

import java.util.Objects;

public class Entrada {

	public static Integer numerodeentrada;
	private boolean sinusar;

	public Entrada(Integer entrada) {
		// TODO Auto-generated constructor stub
		this.numerodeentrada=entrada;
		this.sinusar =true;
	}

	public boolean usar() {
		// TODO Auto-generated method stub
		
		Boolean usada = false;
		
		if(sinusar==true) {
			sinusar=false;
			usada=true;
		}
		
		return usada;
	}


}
