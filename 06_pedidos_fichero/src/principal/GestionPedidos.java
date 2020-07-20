package principal;

import java.util.List;
import java.util.Scanner;

import model.Pedido;
import service.PedidosService;

public class GestionPedidos {

	private static Scanner sc;
	
	// Presenta un men� de opciones
	
	static void presentarMenu() {
		
		System.out.println("\r\n----- MEN� OPCIONES -----");
		System.out.println();
		System.out.println("1.- Agregar Pedido");
		System.out.println("2.- Procesar Pedido");
		System.out.println("3.- Priorizar Pedido");
		System.out.println("4.- Facturaci�n Pendiente");
		System.out.println("5.- Pedidos Pendientes");
		System.out.println("6.- Salir");
		System.out.println();
	}

	// Lee la opci�n elegida
	
	static int leerOpcionMenu() {		
		sc = new Scanner(System.in);		
		return Integer.parseInt(sc.nextLine());
	}
	
	// Lee el n�mero de pedido
	
	static int leerNumeroPedido() {		
		sc = new Scanner(System.in);		
		System.out.println("Introduce el n�mero de pedido: ");		
		return Integer.parseInt(sc.nextLine());
	}
	
	// Lee la descripci�n del producto
	
	static String leerProducto() {		
		sc = new Scanner(System.in);	
		System.out.println("Introduce el nombre del producto: ");	
		return sc.nextLine();
	}
	
	// Lee el precio del producto
	
	static double leerPrecio() {	
		sc = new Scanner(System.in);	
		System.out.println("Introduce el precio del producto: ");	
		return Double.parseDouble(sc.nextLine());
	}
	
	// Cierra el scanner
	
	static void cerrarScanner() {	
		sc.close();
	}
	
	// Agrega un pedido si no existe el mismo id de pedido
	
	static boolean agregarPedido(PedidosService ps) {		
		int id = 0;
		String producto = "";
		double precio = 0.0;	
		// Solicitud del n�mero de pedido
		// Captura excepci�n si hay error de usuario		
		try {			
			id = leerNumeroPedido();
			
		} catch (NumberFormatException e) {			
			System.out.println("El n�mero de pedido no es v�lido");
			
			return false;
		}
		
		// Solicitud de la descripci�n del producto
		
		producto = leerProducto();
		
		// Solicitud del precio del producto
		// Captura excepci�n si hay error de usuario
		
		try {
			
			precio = leerPrecio();
			
		} catch (NumberFormatException e) {
			
			System.out.println("El precio no es v�lido");
			
			return false;
		}
		
		/* Si los datos son v�lidos se intenta registrar el pedido
		   Datos v�lidos si precio e id son mayor que 0
		   Los requisitos de la aplicaci�n no dicen nada sobre esto
		   Es una posible mejora */
		
		if ((id > 0) && (precio > 0)) {
			
			// Se crea una instancia del pedido con los datos obtenidos

			Pedido pedido = new Pedido(id, producto, precio);

			// Se registra el pedido o se muestra un mensaje si existe el id

			if (!ps.agregarPedido(pedido)) {
				
				System.out.println("\r\nEl n�mero de pedido ya EXISTE. Pedido NO registrado\r\n");
				
				return false;
			}
			
			return true;
		}
		
		System.out.println("\r\nLos datos NO son v�lidos\r\n");
		
		return false;
	}
	
	// Procesa el siguiente pedido
	
	static void procesarSiguiente(PedidosService ps) {
	
		// Se intenta procesar el pedido
		
		Pedido siguiente = ps.procesarPedido();
		
		// Se informa al usuario del resultado
		
		if (siguiente != null) {
			
			System.out.println("Se ha procesado el " + siguiente);
			
		} else {
			
			System.out.println("\r\nNO hay pedidos para procesar");
		}
	}
	
	// Prioriza un pedido
	
	static void priorizar(PedidosService ps) {
		
		if (ps.pedidosPendientes().size() != 0) {
			
			// Solicitud del n�mero de pedido

			int id = leerNumeroPedido();
			
			Pedido pedido = ps.priorizarPedido(id);
		
			if (pedido != null) {

				System.out.println("Se ha priorizado el " + pedido);

			} else {

				System.out.println("\r\nNO se puede priorizar este pedido");
			}
			
		} else {
			
			System.out.println("\r\nNO hay pedidos");
		}
	}
	
	// Muestra la facturacion pendiente
	
	static void facturacion(PedidosService ps) {
		
		System.out.println("\r\nFACTURACI�N PENDIENTE: " + ps.facturacionPendiente());
	}
	
	// Muestra los pedidos pendientes
	
	static void mostrarPendientes(PedidosService ps) {
		
		List<Pedido> pedidos = ps.pedidosPendientes();
		
		// Se muestran los pedidos pendientes si hay
		// Si no, se informa al usuario
		
		if (pedidos.size() != 0) {	
		
			System.out.println("\r\nLISTA DE PEDIDOS PENDIENTES: \r\n");
			
			pedidos.forEach(p -> System.out.println(p));
			
		} else {
			
			System.out.println("\r\nNO hay pedidos pendientes");
		}
	}
	
	public static void main(String[] args) {

		PedidosService servicioPedidos =  new PedidosService();
		
		int opcion;
		
		do {		
			opcion = 0;			
			presentarMenu();			
			/* Captura el error de usuario al marcar una opci�n distinta
			   de int y evita que el programa caiga */			
			try {			
				opcion = leerOpcionMenu();				
			} catch (NumberFormatException e) {
				
				System.out.println();
			}			
			switch (opcion) {			
				case 1:					
					agregarPedido(servicioPedidos);
					break;					
				case 2:					
					procesarSiguiente(servicioPedidos);
					break;					
				case 3:					
					priorizar(servicioPedidos);
					break;					
				case 4:				
					facturacion(servicioPedidos);
					break;					
				case 5:					
					mostrarPendientes(servicioPedidos);
					break;				
				case 6:					
					System.out.println("BYE !");
					break;					
				default:					
					System.out.println("\r\nLa opci�n NO es v�lida. Prueba otra vez");
					break;
			}
			
		} while (opcion != 6);
		
		// Ya no vamos a utilizar el scanner
		
		cerrarScanner();

	}

}