package a.a;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import unlam.edu.ar.pb2.parcial.src.Libro;
import unlam.edu.ar.pb2.parcial.src.Persona;
import unlam.edu.ar.pb2.parcial.src.TipoPersona;
import unlam.edu.ar.pb2.parcial.src.Transaccion;

public class Stant {
	private String Nombre;
	private Integer metrosCuadradosOcupado;
	private Integer ubicacion;

	ArrayList<Transaccion> Ventas;
	ArrayList<Libro> libros;
	private String categoriaStant;

	public Stant(String nombreEditoria, Integer metrosCuadradosOcupado, Integer ubicacion) {
		super();
		this.Nombre = nombreEditoria;
		this.metrosCuadradosOcupado = metrosCuadradosOcupado;
		this.Ventas = new ArrayList<>();
		this.ubicacion = ubicacion;
		this.libros = new ArrayList<>();
	}

	public Stant(String nombreAutor, Integer metroscuadradosocupado, Integer ubicacion, String categoriaStant) {
		this.Nombre = nombreAutor;
		this.metrosCuadradosOcupado = metroscuadradosocupado;
		this.ubicacion = ubicacion;
		this.setCategoriaStant(categoriaStant);
	}

	// Setter And Getters

	public String getNombreStant() {
		return Nombre;
	}

	public void setNombreStant(String nombreEditoria) {
		Nombre = nombreEditoria;
	}

	public Integer getMetrosCuadradosOcupado() {
		return metrosCuadradosOcupado;
	}

	public void setMetrosCuadradosOcupado(Integer metrosCuadradosOcupado) {
		this.metrosCuadradosOcupado = metrosCuadradosOcupado;
	}

	public ArrayList<Transaccion> getVentas() {
		return Ventas;
	}

	public void setVentas(ArrayList<Transaccion> ventas) {
		Ventas = ventas;
	}

	public Integer getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	// Methods
	public void agregarLibro(Libro libro) {
		this.libros.add(libro);
	}

	public void obtenerCantidadDeLibros() {
		this.libros.size();
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public String getCategoriaStant() {
		return categoriaStant;
	}

	public void setCategoriaStant(String categoriaStant) {
		this.categoriaStant = categoriaStant;
	}

	public double venderLibroInfantil(Persona visitante, Libro libro) {
		Double presio = libro.getPrecio();
		if (libro.getCategoria().equals("Infantil") && visitante.getEdad() < 12) {
			presio = libro.getPrecio() - (libro.getPrecio() * 0.2);
			Double nuevoDinero = visitante.getDinero() - presio;
			visitante.setDinero(nuevoDinero);
			return presio;
		}
		return presio;
	}

	public boolean venderLibroTerror(Persona persona, Libro libro) {
		Double presio = 0.0;
		if (libro.getCategoria().equals("Terror") && persona.getEdad() >= 18) {
			presio = libro.getPrecio();
			Double nuevoDinero = persona.getDinero() - presio;
			persona.setDinero(nuevoDinero);
			return true;
		}
		return false;

	}

	public void venderLibroNovelas(Persona persona, Libro libro, DayOfWeek diaSemana) {
		Double presio = 0.0;
		presio = libro.getPrecio();

		double descuento = 20.0;
		double montoDescuento = presio * (descuento / 100.0);
		double montoFinal = presio - montoDescuento;

		for (Libro libro11 : libros) {
			if (libro11.getCategoria().equals(libro.getCategoria())
					&& persona.getTipoPersona() == TipoPersona.ADULTO_MAYOR && diaSemana == DayOfWeek.WEDNESDAY) {
				if (persona.getEdad() > 60) {
					Double nuevoDinero = persona.getDinero() - montoFinal;
					persona.setDinero(nuevoDinero);
				} else {
					Double nuevoDinero = persona.getDinero() - presio;
					persona.setDinero(nuevoDinero);

				}

			}
		}

	}
}