package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class EscrituraAppend {

	public static void main(String[] args) {
		String ruta="pruebas.txt";
		
		try(FileOutputStream fout=new FileOutputStream(ruta, true);
			PrintStream out=new PrintStream(fout)) {			
			out.println("Nueva linea");
			out.println("nuevo fin del texto");
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
