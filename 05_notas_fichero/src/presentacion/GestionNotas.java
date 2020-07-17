package presentacion;

import java.util.List;
import java.util.Scanner;

import service.NotasService;

public class GestionNotas {
	public static Scanner sc;

	public static void main(String[] args) {
		int opcion;
		NotasService notas = new NotasService();

		do
		{
			opcion = menu();
			switch (opcion)
			{
				case 1:
					agregarNotas(notas);
					break;
				case 2:
					calcularMedia(notas);
					break;
				case 3:
					totalNotasAprobadas(notas);
					break;
				case 4:
					mostrarNotass(notas);
					break;
				case 5:
					break;
				default:
					System.out.println("\n- Ingrese una opción correcta.\n");
			}
		} while (opcion != 5);
		sc.close();

	}
	
	static int menu ()
	{	
		sc = new Scanner(System.in);
		System.out.println("\n**Menu Notas**");
		System.out.println("1: Agregar notas");
		System.out.println("2: Calcular media de notas");
		System.out.println("3: Total notas aprobadas");
		System.out.println("4: Visualizar notas");
		System.out.println("5: Salir");
		System.out.print("\nSeleccionar opcion: ");
		return sc.nextInt();
	}
	
	static void agregarNotas (NotasService notas) 
	{
		sc = new Scanner(System.in);
		System.out.print("Ingresar nota: ");
		notas.agregarNota(Double.parseDouble(sc.nextLine()));
		
	}
	
	static void calcularMedia (NotasService notas) 
	{
		System.out.println("La media es: " + notas.media());
	}
	
	static void totalNotasAprobadas (NotasService notas) 
	{
		System.out.println("El total de notas aprobadas es: " + notas.aprobados());
	}
	
	static void mostrarNotass (NotasService notas) 
	{
		
			
		notas.notas().forEach(n->System.out.println("Nota: "+n));
	}
	
	

}
