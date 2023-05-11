package a.a;

import java.util.HashSet;
import java.util.Objects;


public class Pabellon {

	private HashSet <Stant> Stants = new HashSet<>();
	private String nombrePabellon;

	public Pabellon(String nombrePabellon) {
		// TODO Auto-generated constructor stub
		
		this.nombrePabellon = nombrePabellon;
	}

	public void agregarunstant(Stant stante) {
		
		Stants.add(stante);
		
	}

	public HashSet<Stant> getstants() {
		// TODO Auto-generated method stub
		return Stants;
	}

}