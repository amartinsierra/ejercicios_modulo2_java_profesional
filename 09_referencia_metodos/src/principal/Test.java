package principal;

import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		Stream<String> nombres=Stream.of("Pepe","Lucas","Ana","Ana","Marcos","Pepe","Marta","Juan","Lucas","Elena");
		nombres	
			.distinct()
			.map(String::length)
			.forEach(System.out::println);
		
	}

}
