package principal;

import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		Stream<Integer> numeros=Stream.of(7,21,45,2,9,10,73,14);
		//System.out.println("Total numeros "+numeros.count());
		numeros.forEach(n->System.out.println(n));
	}

}
