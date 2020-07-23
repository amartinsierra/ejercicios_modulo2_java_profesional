package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Pedido;

public class Utilidades {
	static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public static String pedidoToString(Pedido p) {
		return p.getProducto()+","+p.getUnidades()+","+p.getPrecioUnitario()+","+p.getSeccion()+","+sdf.format(p.getFecha());
	}
	public static Pedido stringToPedido(String f) {
		String[] partes=f.split("[,]");
		try {
			return new Pedido(partes[0],
					Integer.parseInt(partes[1]),
					Double.parseDouble(partes[2]),
					partes[3],
					sdf.parse(partes[4]));
		}
		catch(ParseException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
