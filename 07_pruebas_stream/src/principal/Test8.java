package principal;

import java.util.stream.Stream;

public class Test8 {

	public static void main(String[] args) {
		Stream<String> nombres=Stream.of("Pepe","Lucas","Ana","Ana","Marcos","Pepe","Marta","Juan","Lucas","Elena");
		System.out.println(nombres
			.distinct()
			.max((n1,n2)->n1.length()-n2.length())
			.get());

	}

}
