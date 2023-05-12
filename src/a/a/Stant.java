package a.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stant {
	
	 private ArrayList<Libro> libros = new ArrayList<>();
	String editorial;
	Integer metroscuadradosocupados;
	Integer ubicacion;
	ArrayList<Compra> Ventas = new ArrayList<>();

	
	public Stant(String editorial, Integer metroscuadradosocupados, Integer ubicacion) {
		this.editorial=editorial;
		this.metroscuadradosocupados=metroscuadradosocupados;
		this.ubicacion=ubicacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ubicacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stant other = (Stant) obj;
		return Objects.equals(ubicacion, other.ubicacion);
	}

	public void agregarunaventa(Compra compra, Persona persona) {
		// TODO Auto-generated method stub
		Compra venta= new Compra(compra,persona);
		Ventas.add(venta);
	}
	
	public void agregarLibro(Libro libro) {
	    libros.add(libro);
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public ArrayList<Compra> getVentas() {
		// TODO Auto-generated method stub
		return Ventas;
	}
	public List<Libro> buscarLibrosPorAutor(String autor) {
	    List<Libro> librosEncontrados = new ArrayList<>();
	    for (Libro libro : libros) {
	        if (libro.getAutor().equals(autor)) {
	            librosEncontrados.add(libro);
	        }
	    }
	    return librosEncontrados;
	}
	
}