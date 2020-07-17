package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class NotasService {
	private final String ruta = "notas.txt";
	int aprobados=0;
	double media=0;
	public void agregarNota(double nota) {
		try(PrintStream ps = new PrintStream(new FileOutputStream(ruta,true))){
			ps.println(nota);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public double media() {
		media=0;
		List<Double> notas=notas();
		notas.forEach(n->media+=n);
		return media/notas.size();
	}
	public int aprobados() {
		/*aprobados=0;
		notas().forEach(n->{
			if(n>=5) {
				aprobados++;
			}
		});
		return aprobados;*/
		int aprobados=0;
		try(BufferedReader bf = new BufferedReader(new FileReader(ruta))){
			String nota;
			while((nota=bf.readLine())!=null) {
				if(Double.parseDouble(nota)>=5) {
					aprobados++;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return aprobados;
	}
	public List<Double> notas(){
		List<Double> notas = new ArrayList<>();
		try(BufferedReader bf = new BufferedReader(new FileReader(ruta))){
			String nota;
			while((nota=bf.readLine())!=null) {
				notas.add(Double.parseDouble(nota));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return notas;
	}
}
