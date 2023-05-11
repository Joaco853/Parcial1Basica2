package a.a;

public class Compra {

	private Double valorcompra;

	Boolean descuentoporcomprarentrada;
	Compra compra;
	Persona persona;
	public Compra(Double valorCompra) {
		// TODO Auto-generated constructor stub
		this.valorcompra=valorCompra;
		descuentoporcomprarentrada=false;
	}

	
	public Compra(Compra compra, Docente docente) {
		// TODO Auto-generated constructor stub
		this.compra = compra;
		this.persona = docente;
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

}
