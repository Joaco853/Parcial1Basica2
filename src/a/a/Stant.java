package a.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import unlam.edu.ar.pb2.parcial.src.Libro;
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
		this.metrosCuadradosOcupado =metroscuadradosocupado;
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
}