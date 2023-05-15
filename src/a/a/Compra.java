package a.a;

public class Compra {
	
	private Libro libro;
	private Double valorcompra;
	Boolean descuentoporcomprarentrada;
	Compra compra;
	Persona persona;
	private Boolean pagoentrada ;
	
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

	public Compra(Double valorCompra2, Persona persona) {
		// TODO Auto-generated constructor stub
		this.valorcompra = valorCompra2;
		this.pagoentrada  = persona.getPagoentrada();
		
	}
	public void setDescuentoporcomprarentrada(Boolean descuentoporcomprarentrada) {
		this.descuentoporcomprarentrada = descuentoporcomprarentrada;
	}


	public Double valorapagarcompra() {
		// TODO Auto-generated method stub
		if(pagoentrada) {
			this.valorcompra=valorcompra*0.9;
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
