package principal;

import java.util.stream.Stream;

public class Test11 {

	public static void main(String[] args) {
		Stream<Integer> numeros=Stream.of(7,2,3,2,8,5);
		System.out.println(numeros
			.distinct()
			.reduce((n1,n2)->n1*n2));

	}

}
