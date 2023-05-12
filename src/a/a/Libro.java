package a.a;

public class Libro {
	private String titulo;
	private String autor;
	private String categoria;
	private Double precio;
	
	public Libro(String titulo, String autor, String categoria, Double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getAutor() {
		// TODO Auto-generated method stub
		return autor;
	}

	public String getTitulo() {
		// TODO Auto-generated method stub
		return titulo;
	}
	
	
}
