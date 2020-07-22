package model;

public class Pedido {
	private int numeroPedido;
	private String producto;
	private double precio;
	public Pedido(int numeroPedido, String producto, double precio) {
		super();
		this.numeroPedido = numeroPedido;
		this.producto = producto;
		this.precio = precio;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroPedido;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
		if (numeroPedido != other.numeroPedido)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pedido [numeroPedido=" + numeroPedido + ", producto=" + producto + ", precio=" + precio + "]";
	}
	
	
}
