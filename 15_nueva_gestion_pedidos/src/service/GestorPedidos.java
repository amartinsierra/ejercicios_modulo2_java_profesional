package service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Pedido;
import util.MiFiltro;
import util.Utilidades;

public class GestorPedidos  {
	Path path;
	String RUTA="pedidos.txt";
	public GestorPedidos() {
		path=Paths.get(RUTA);
		if(!Files.exists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Stream<Pedido> streamPedido(){
		try {
			return Files.lines(path,StandardCharsets.UTF_8)
				.map(s->Utilidades.stringToPedido(s));
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	//almacena el pedido recibido
	public void grabarPedido(Pedido pedido) {
		try {
			Files.writeString(path, Utilidades.pedidoToString(pedido)+System.lineSeparator(), 
					StandardCharsets.UTF_8,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	//media de ventas pedidos de esa seccion
	public double promedioSeccion(String seccion) {
		return streamPedido()
				.filter(p->p.getSeccion().equals(seccion))
				.collect(Collectors.averagingDouble(p->p.getPrecioUnitario()*p.getUnidades()));
		
	}

	//ventas totales de el producto indicado
	public double totalProducto(String producto) {
		return streamPedido()
				.filter(p->p.getProducto().equals(producto))
				.collect(Collectors.summingDouble(p->p.getPrecioUnitario()*p.getUnidades()));
				
	}

	//devuelve el pedido con venta superior
	
	public Pedido pedidoSuperior() {
		return streamPedido()
				.max((p1,p2)->
					p1.getPrecioUnitario()*p1.getUnidades()<p2.getPrecioUnitario()*p2.getUnidades()?-1:1)
				.orElse(null);
	}

	//devuelve lista de pedidos de una sección
	public List<Pedido> pedidosSeccion(String seccion) {
		MiFiltro mifiltro=new MiFiltro(seccion);
		return streamPedido()
				.filter(mifiltro)
				.collect(Collectors.toList());
	}
	//devuelve el pedido con fecha más reciente
	public Pedido pedidoMasReciente() {
		return streamPedido()
				.max((p1,p2)->p1.getFecha().compareTo(p2.getFecha()))
				.orElse(null);
	}
	//devuelve lista de pedidos, posteriores a la fecha indicada
	public List<Pedido> pedidosPosterioresFecha(Date fecha) {
		return streamPedido()
				.filter(p->p.getFecha().after(fecha))
				.collect(Collectors.toList());
	}
	
	
	//lista de nombres de sección, no repetidas
	public List<String> secciones() {
		return streamPedido()
				.map(p->p.getSeccion())
				.distinct()
				.collect(Collectors.toList());
	}
	
	
	

}
