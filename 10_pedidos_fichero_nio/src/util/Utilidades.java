package util;

import model.Pedido;

public class Utilidades {
	public static Pedido construirPedido(String cadena, String separador) {
		String[] datos=cadena.split(separador);
		return new Pedido(Integer.parseInt(datos[0]),
				  datos[1],
				  Double.parseDouble(datos[2]));
	}
	public static String construirCadena(Pedido pedido,String separador) {
		return pedido.getNumeroPedido()+separador+pedido.getProducto()+separador+pedido.getPrecio();
	}
}
