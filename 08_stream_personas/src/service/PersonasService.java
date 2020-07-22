package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Persona;

public class PersonasService {
	List<Persona> personas=new ArrayList<>();
	public PersonasService() {
		personas.add(new Persona("Alex","al@gg.com",20));				
		personas.add(new Persona("Juan","alfd@gg.com",29));
		personas.add(new Persona("Elena","al@gg.es",17));
		personas.add(new Persona("Marta","alaaoi@gg.com",34));
		personas.add(new Persona("Lucas","alert@gg.es",44));
		personas.add(new Persona("Alicia","sdfl@gg.com",35));
		personas.add(new Persona("Marta","alfd@nn.es",35));
		personas.add(new Persona("Angel","dasas@vv.org",45));
	}
	//persona más joven
	public Persona obtenerMasJoven() {
		return personas
			.stream()
			.min((p1,p2)->p1.getEdad()-p2.getEdad())
			.orElse(null);
	}
	//el número de personas cuya edad es superior a la media
	public int superiorMedia() {
		/*double media=
				personas.stream()
					.mapToDouble(p->p.getEdad())
					.average()
					.orElse(0);*/
		double media=
				personas.stream()
					.collect(Collectors.averagingDouble(p->p.getEdad()));
		
		return (int)personas
					.stream()
					.filter(p->p.getEdad()>media)
					.count();
	}
	//personas ordenadas por edad
	public List<Persona> ordenadasPorEdad(){
		return personas
			.stream()
			.sorted((p1,p2)->p1.getEdad()-p2.getEdad())
			.collect(Collectors.toList());
	}
	//personas ordenadas por edad
	public List<Persona> ordenadasPorNombreYEdad(){
			Comparator<Persona> comp=(p1,p2)->p1.getNombre().compareTo(p2.getNombre());
			return personas
				.stream()
				.sorted(comp
						.thenComparing((a1,a2)->a1.getEdad()-a2.getEdad()))
				.collect(Collectors.toList());
	}
	//lista nombres de personas
	public List<String> nombres(){
		return personas.stream()
			.map(p->p.getNombre())
			.collect(Collectors.toList());
	}
	//dominio sea igual al indicado
	public List<Persona> personasDominio(String dominio){
		return personas.stream()
					.filter(p->p.getEmail().endsWith(dominio))
					.collect(Collectors.toList());
	}
	
	public Set<Persona> personasEdadSuperiorValor(int edad){
		return personas.stream()
				.filter(p->p.getEdad()>edad)
				.collect(Collectors.toSet());
	}
	
	public Map<String,Persona> personasOrdenadasClaveEmail(){
		return personas.stream()
			.sorted((p1,p2)->p1.getEmail().compareTo(p2.getEmail()))
			.collect(Collectors.toMap(p->p.getEmail(), p->p));
	}
	
	public Map<String,List<Persona>> personasAgrupadasPorDominio(){
		return personas.stream()
				.collect(Collectors.groupingBy(p->p.getEmail().split("[.]")[1]));
	}
	
}
