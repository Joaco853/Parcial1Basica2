package a.a;


public class Alumno extends Persona {

	private String institucion;

	public Alumno(String nombre, String apellido, Integer nroDni, Integer edad, TipoPersona tipoPersona,
			String institucion, Double dinero) {
		super(nombre, apellido, nroDni, edad, tipoPersona, dinero);
		this.institucion = institucion;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

}
