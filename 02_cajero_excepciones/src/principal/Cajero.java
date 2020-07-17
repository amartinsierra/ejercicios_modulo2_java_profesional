package principal;

import java.util.Scanner;

import exceptions.SaldoNegativoException;
import model.Movimiento;
import service.CuentaServiceMovimientos;

public class Cajero {

	public static void main(String[] args) {
		CuentaServiceMovimientos service;
		double saldoInicial;
		double limite;
		int op;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce saldo inicial: ");
		saldoInicial=Double.parseDouble(sc.nextLine());
		System.out.println("Introduce límite: ");
		limite=Double.parseDouble(sc.nextLine());
		service=new CuentaServiceMovimientos(saldoInicial, limite);
		do {
			menu();
			op=Integer.parseInt(sc.nextLine());
			switch(op) {
				case 1:
					System.out.println("Cantidad: ");
					service.ingresar(Double.parseDouble(sc.nextLine()));
					break;
				case 2:
					System.out.println("Cantidad: ");
					try {
						service.extraer(Double.parseDouble(sc.nextLine()));
					} catch (NumberFormatException e) {				
						System.out.println("La cntidad no es numérica");
					} catch (SaldoNegativoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					mostrarMovimientos(service);
					break;
			}
		}while(op!=4);
	}
	private static void menu() {
		System.out.println("1.- Ingresar: ");
		System.out.println("2.- Extraer: ");
		System.out.println("3.- Consulta de movimientos y saldo: ");
		System.out.println("4.- Salir: ");
	}
	private static void mostrarMovimientos(CuentaServiceMovimientos service) {
		for(Movimiento m:service.obtenerMovimientos()) {
			System.out.println(m);//m.getTipoMovimiento()+":"+m.getCantidad());
		}
		System.out.println("Saldo actual: "+service.getSaldo());
	}
}
