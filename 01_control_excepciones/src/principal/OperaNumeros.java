package principal;

import java.util.Scanner;

public class OperaNumeros {

	public static void main(String[] args) {
		int numerador,denominador,resultado;
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Introduce numerador: ");
			numerador=Integer.parseInt(sc.nextLine());
			System.out.println("Introduce denominador: ");
			denominador=Integer.parseInt(sc.nextLine());
			resultado=numerador/denominador;
			System.out.println("La división es "+resultado);
		}
		/*
		catch(NumberFormatException ex){
			System.out.println(ex.getMessage());
		}
		catch(ArithmeticException ex) {
			System.out.println(ex.getMessage());
		}*/
		catch(NumberFormatException|ArithmeticException ex) {
			System.out.println(ex.getMessage());
			return;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error inesperado ");
		}
		finally {
			System.out.println("Programa finalizado");
			sc.close();
		}
	}

}
