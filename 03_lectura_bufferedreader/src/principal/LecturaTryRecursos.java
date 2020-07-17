package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaTryRecursos {

	public static void main(String[] args) {
		
		
		try(InputStreamReader ir=new InputStreamReader(System.in);
			BufferedReader bf=new BufferedReader(ir)) {
			System.out.println("Introduce tu nombre: ");
			String nombre=bf.readLine();
			System.out.println("Te llamas "+nombre);			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		

	}

}
