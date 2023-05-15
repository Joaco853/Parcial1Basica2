package a.a;


public class Entrada{
		private Integer numeroEntrada;
		private Boolean sinUsar;
		private Double PrecioEntrada;

		public Entrada(Integer numeroEntrada, Boolean sinUsar, Double precioEntrada) {
			super();
			this.numeroEntrada = numeroEntrada;
			this.sinUsar = sinUsar;
			PrecioEntrada = precioEntrada;
		}

		public Integer getNumeroEntrada() {
			return numeroEntrada;
		}

		public void setNumeroEntrada(Integer numeroEntrada) {
			this.numeroEntrada = numeroEntrada;
		}

		public Boolean getSinUsar() {
			return sinUsar;
		}

		public void setSinUsar(Boolean sinUsar) {
			this.sinUsar = sinUsar;
		}

		public Double getPrecioEntrada() {
			return PrecioEntrada;
		}

		public void setPrecioEntrada(Double precioEntrada) {
			PrecioEntrada = precioEntrada;
		}


}
