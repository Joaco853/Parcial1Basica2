package a.a;

import java.util.HashSet;

public class Pabellon {
		private HashSet <Stant> Stants = new HashSet<>();
		private String nombrePabellon;

		public Pabellon(String nombrePabellon) {
			this.nombrePabellon = nombrePabellon;
		}

		public void agregarunstant(Stant stante) {
			
			Stants.add(stante);
			
		}

		public HashSet<Stant> getstants() {
			return Stants;
		}

		public String getNombrePabellon() {
			return nombrePabellon;
		}

		public void setNombrePabellon(String nombrePabellon) {
			this.nombrePabellon = nombrePabellon;
		}

}