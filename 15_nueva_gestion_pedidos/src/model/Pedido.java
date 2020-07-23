package model;


import java.util.Date;

public class Pedido {
	private String producto;
	private int unidades;
	private double precioUnitario;
	private String seccion;
	private Date fecha;
	public Pedido(String producto, int unidades, double precioUnitario, String seccion,Date fecha) {
		super();
		this.producto = producto;
		this.unidades = unidades;
		this.precioUnitario = precioUnitario;
		this.seccion = seccion;
		this.fecha=fecha;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
