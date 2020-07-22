package principal;

import java.util.stream.Stream;

public class Test6 {

	public static void main(String[] args) {
		Stream<String> nombres=Stream.of("Pepe","Lucas","Ana","Ana","Marcos","Pepe","Marta","Juan","Lucas","Elena");
		/*nombres	
			.distinct()
			.map(s->s.length())
			.forEach(n->System.out.println(n));*/
		System.out.println(nombres
			.distinct()
			.mapToInt(s->s.length())
			.sum());

	}

}
