package principal;

import java.io.IOException;
import java.io.PrintStream;

public class Escritura {

	public static void main(String[] args) {
		String ruta="pruebas.txt";
		try(PrintStream out=new PrintStream(ruta)) {			
			out.println("Es la linea 1");
			out.println(4500);
			out.println("fin del texto");
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
