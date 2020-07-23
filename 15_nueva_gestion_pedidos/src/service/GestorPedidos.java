package service;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import model.Pedido;

public class GestorPedidos  {
	Path path;
	String dir="pedidos.txt";
	
	//almacena el pedido recibido
	public void grabarPedido(Pedido pedido) {
		
	}

	//media de ventas pedidos de esa seccion
	public double promedioSeccion(String seccion) {
		
	}

	//ventas totales de el producto indicado
	public double totalProducto(String producto) {
		
	}

	//devuelve el pedido con venta superior
	
	public Pedido pedidoSuperior() {
		
	}

	//devuelve lista de pedidos de una sección
	public List<Pedido> pedidosSeccion(String seccion) {
		
	}
	//devuelve el pedido con fecha más reciente
	public Pedido pedidoMasReciente() {
		
	}
	//devuelve lista de pedidos, posteriores a la fecha indicada
	public List<Pedido> pedidosPosterioresFecha(Date fecha) {
		
	}
	
	
	//lista de nombres de sección, no repetidas
	public List<String> secciones() {
		
		
	}
	
	
	

}
