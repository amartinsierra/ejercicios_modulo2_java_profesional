package principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test5 {

	public static void main(String[] args) {
		List<Integer> lista=Arrays.asList(7,21,45,4,2,7,9,10,21,73,7,14,45);
		Stream<Integer> numeros=lista.stream();
		numeros
		.distinct()
		.filter(n->n%2==0)
		.sorted((n1,n2)->n2-n1)
		.forEach(n->System.out.println(n));

		System.out.println("Contenido lista ");
		lista.forEach(n->System.out.println(n));
	}

}
