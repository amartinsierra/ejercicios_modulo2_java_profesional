package service;

import java.util.List;
import java.util.Vector;

import exceptions.SaldoNegativoException;
import model.Movimiento;

public class CuentaServiceMovimientos extends CuentaLimiteService {
	private List<Movimiento> movimientos=new Vector<Movimiento>();
	
	
	public CuentaServiceMovimientos(double saldo, double limite) {
			
		super(saldo, limite);
	}
	@Override
	public double ingresar(double cantidad) {
		double resultado=super.ingresar(cantidad);
		movimientos.add(new Movimiento(resultado,"Ingreso"));
		return resultado;
	}



	@Override
	public double extraer(double cantidad) throws SaldoNegativoException{
		double resultado=super.extraer(cantidad);
		movimientos.add(new Movimiento(resultado,"Extraer"));
		return resultado;
	}



	public List<Movimiento> obtenerMovimientos(){
		return movimientos;
	}
}
