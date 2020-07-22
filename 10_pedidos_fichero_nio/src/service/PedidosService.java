package service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Pedido;
import util.Utilidades;

public class PedidosService {
	private final String RUTA="pedidos.txt";
	private final String SEPARADOR="-";
	private Path path;
	public PedidosService() {
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
	public boolean agregarPedido(Pedido pedido) {
		if(!existePedido(pedido)) {
			try{
				Files.writeString(path, 
						Utilidades.construirCadena(pedido, SEPARADOR)+System.lineSeparator(), 
						StandardCharsets.UTF_8,
						StandardOpenOption.APPEND);
				return true;
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean existePedido(Pedido pedido) {
		try {
			return Files.lines(path)
				.anyMatch(p->Utilidades.construirPedido(p, SEPARADOR).equals(pedido));
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Pedido procesarPedido() {
		List<Pedido> pedidos=pedidosPendientes();
		Pedido pedido=null ;
		if(pedidos.size()>0) {
			pedido=pedidos.remove(0);		
			volcarPedidos(pedidos);
		}
		return pedido;
	}
	//reconstruye el fichero con la nueva lista de pedidos
	private void volcarPedidos(List<Pedido> pedidos) {
		try {
			Files.write(
					path, 
					pedidos
						.stream()
						.map(p -> Utilidades.construirCadena(p, SEPARADOR))
						.collect(Collectors.toList()), 
					Charset.forName("UTF-8"),
					StandardOpenOption.TRUNCATE_EXISTING);//para linux, añadir tb CREATE
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	public Pedido priorizarPedido(int numeroPedido) {
		Pedido pedido,aux;
		pedido=obtenerPedido(numeroPedido);
		//obtenemos la lista de peidos pedientes,
		//para operar en memoria
		List<Pedido> pedidos=pedidosPendientes();
		if(pedido!=null) {
			int pos=pedidos.indexOf(pedido);
			//se intercambia con el anterior, si no es el primero
			if(pos>0) {
				//intercambiamos el pedido por el de la
				//posición anterior
				aux=pedidos.get(pos-1);
				pedidos.set(pos-1, pedido);
				pedidos.set(pos, aux);
			}
		}
		volcarPedidos(pedidos);
		return pedido;
	}
	private Pedido obtenerPedido(int numeroPedido) {		
		try {
			return Files.lines(path)
					.map(s->Utilidades.construirPedido(s, SEPARADOR))
					.filter(p->p.getNumeroPedido()==numeroPedido)
					.findFirst()
					.orElse(null);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public double facturacionPendiente() {
		try {
			return Files.lines(path)
					.mapToDouble(s->Utilidades.construirPedido(s, SEPARADOR).getPrecio())
					.sum();
			/*return Files.lines(path)
					.mapToDouble(s->Utilidades.construirPedido(s, SEPARADOR).getPrecio())
					.reduce((n1,n2)->n1+n2)
					.getAsDouble();*/
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return 0;
		}
		
	}
	//elimina todos los pedidos, cuyo nombre de producto
	//contenga ese texto
	public void eliminarPedidos(String producto) {
		List<Pedido> pedidos=pedidosPendientes();
		pedidos.removeIf(p->p.getProducto().contains(producto));
		volcarPedidos(pedidos);
			
	}
	
	public List<Pedido> pedidosPendientes() {
		try(Stream<String> st=Files.lines(path)) {
			return st
					.map(s->Utilidades.construirPedido(s, SEPARADOR))
					.collect(Collectors.toList());
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
