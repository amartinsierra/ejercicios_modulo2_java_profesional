package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lectura {

	public static void main(String[] args) {
		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader bf=null;
		try {
			bf=new BufferedReader(ir);
			System.out.println("Introduce tu nombre: ");
			String nombre=bf.readLine();
			System.out.println("Te llamas "+nombre);
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(bf!=null) {
					bf.close();
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
