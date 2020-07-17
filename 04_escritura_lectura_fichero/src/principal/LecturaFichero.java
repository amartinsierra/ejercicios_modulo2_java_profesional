package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFichero {

	public static void main(String[] args) {
		String ruta="pruebas.txt";
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){
			/*String linea=bf.readLine();
			while(linea!=null) {
				System.out.println(linea);
				linea=bf.readLine();
			}*/
			String linea;
			while((linea=bf.readLine())!=null) {
				System.out.println(linea);
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
