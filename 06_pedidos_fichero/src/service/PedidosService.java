package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidosService {
	private final String RUTA="pedidos.txt";
	private final String SEPARADOR="-";
	private double facturacion=0;
	public boolean agregarPedido(Pedido pedido) {
		if(!existePedido(pedido)) {
			try(PrintStream ps = new PrintStream(new FileOutputStream(RUTA,true))){
				ps.println(pedido.getNumeroPedido()+SEPARADOR+pedido.getProducto()+SEPARADOR+pedido.getPrecio());
				return true;
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean existePedido(Pedido pedido) {
		try(BufferedReader bf = new BufferedReader(new FileReader(RUTA))){
			String linea;
			while((linea=bf.readLine())!=null) {
				//transformamos la línea en un array de atributos del pedido
				String[] datos=linea.split(SEPARADOR);
				//obtenemos el código, que es el primer elemento
				int codigo=Integer.parseInt(datos[0]);
				if(codigo==pedido.getNumeroPedido()) {
					return true;
				}
			}
		} 
		catch(FileNotFoundException ex) {
			try(PrintStream salida=new PrintStream(RUTA)){
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return false;
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
		try(PrintStream ps = new PrintStream(new FileOutputStream(RUTA,false))){
			pedidos.forEach(p->
					ps.println(p.getNumeroPedido()+SEPARADOR+p.getProducto()+SEPARADOR+p.getPrecio())
				);
			
		} catch(IOException e) {
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
		Pedido pedido=null;
		try(BufferedReader bf = new BufferedReader(new FileReader(RUTA))){
			String linea;
			while((linea=bf.readLine())!=null) {
				//transformamos la línea en un array de atributos del pedido
				String[] datos=linea.split(SEPARADOR);
				if(numeroPedido==Integer.parseInt(datos[0])) {
					pedido=new Pedido(Integer.parseInt(datos[0]),
									  datos[1],
									  Double.parseDouble(datos[2]));
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return pedido;
	}
	
	public double facturacionPendiente() {
		facturacion=0;
		pedidosPendientes().forEach((Pedido p)->facturacion+=p.getPrecio());
		return facturacion;
		
	}
	//elimina todos los pedidos, cuyo nombre de producto
	//contenga ese texto
	public void eliminarPedidos(String producto) {
		List<Pedido> pedidos=pedidosPendientes();
		pedidos.removeIf(p->p.getProducto().contains(producto));
		volcarPedidos(pedidos);
			
	}
	
	public List<Pedido> pedidosPendientes() {
		List<Pedido> lista=new ArrayList<>();
		try(BufferedReader bf = new BufferedReader(new FileReader(RUTA))){
			String linea;
			while((linea=bf.readLine())!=null) {
				//transformamos la línea en un array de atributos del pedido
				String[] datos=linea.split(SEPARADOR);
				lista.add(new Pedido(Integer.parseInt(datos[0]),
									  datos[1],
									  Double.parseDouble(datos[2])));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
