package a.a;

public class Compra {
	
	private Libro libro;
	private Double valorcompra;
	Boolean descuentoporcomprarentrada;
	Compra compra;
	Persona persona;
	
	public Compra(Libro libro, Double valorcompra) {
		this.libro = libro;
		this.descuentoporcomprarentrada = false;
		this.valorcompra = valorcompra;
	}


	public Compra(Double valorCompra) {
		// TODO Auto-generated constructor stub
		this.valorcompra=valorCompra;
		descuentoporcomprarentrada=false;
	}

	
	public Compra(Compra compra, Persona persona) {
		// TODO Auto-generated constructor stub
		this.compra = compra;
		this.persona = persona;
	}


	public void setDescuentoporcomprarentrada(Boolean descuentoporcomprarentrada) {
		this.descuentoporcomprarentrada = descuentoporcomprarentrada;
	}


	public double valorapagarcompra() {
		// TODO Auto-generated method stub
		if(descuentoporcomprarentrada) {
			valorcompra=valorcompra*0.9;
			return valorcompra;
		}
		return valorcompra;
	}
	
	public double valorLibroPorDescuento() {
		if(descuentoporcomprarentrada && libro.getCategoria().equals("Novela")) {
			return valorcompra*0.8;
		}
		return valorcompra;
	}
}
