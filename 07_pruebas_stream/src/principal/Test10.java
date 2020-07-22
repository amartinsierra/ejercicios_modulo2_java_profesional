package principal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test10 {

	public static void main(String[] args) {
		Stream<String> cursos=Stream.of("Principios de Java","JavaScript","PHP",".NET","c++","Aprenda Java ya","Python","Java EE","Todo Java","Linux");
		String palabra="Java";
		List<String> resultado=cursos
			.filter(s->s.contains(palabra))
			.collect(Collectors.toList());
		
		resultado.forEach(t->System.out.println(t));

	}

}
