package util;

import java.util.function.Predicate;

import model.Pedido;

public class MiFiltro implements Predicate<Pedido>{
	private String seccion;
	public MiFiltro(String seccion) {
		this.seccion=seccion;
	}

	@Override
	public boolean test(Pedido p) {
		return p.getSeccion().equals(seccion);
	}

}
