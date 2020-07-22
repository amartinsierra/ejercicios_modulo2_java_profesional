package principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test2 {

	public static void main(String[] args) {
		Stream<String> cursos=Stream.of("Principios de Java","JavaScript","PHP",".NET","c++","Aprenda Java ya","Python","Java EE","Todo Java","Linux");
		//muestra el primer título que contanga la palabra Java, según orden alfabético, y si no
		//existe que muestre no encontrado
		System.out.println(cursos
				.map(String::toLowerCase)
				.filter(p->p.contains("java"))
				.sorted()
				.findFirst()
				.orElse("No encontrado")
				);

	}

}
