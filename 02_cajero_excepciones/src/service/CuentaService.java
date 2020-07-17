package service;

import exceptions.SaldoNegativoException;

public class CuentaService {
	/*
	 atributo para almacenar el saldo de la cuenta
	 constructores (al menos dos) que permitan inicializar la cuenta
	 metodos: extraer dinero a partir de una cantidad, 
	 ingresar dinero a partir de una cantidad y método que devuelva el saldo actual 
	 */
	private double saldo;

	public CuentaService(double saldo) {
		super();
		this.saldo = saldo;
	}

	public CuentaService() {
		super();
	}
	public double ingresar(double cantidad) {
		saldo+=cantidad;
		return cantidad;
	}
	public double extraer(double cantidad) throws SaldoNegativoException{
		if(cantidad>saldo) {
			throw new SaldoNegativoException();
		}
		saldo-=cantidad;
		return cantidad;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}



