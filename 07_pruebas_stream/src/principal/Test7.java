package principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test7 {

	public static void main(String[] args) {
		List<Integer> lista=Arrays.asList(7,21,45,4,2,7,9,10,21,73,7,14,45);
		Stream<Integer> numeros=lista.stream();
		final int LM=50;
		/*System.out.println(numeros
			.anyMatch(n->n>LM));*/
		
		System.out.println(numeros
				.noneMatch(n->{
					System.out.println(n);
					return n>LM;}));
	}

}
