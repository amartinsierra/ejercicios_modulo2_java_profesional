package principal;

import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		Stream<Integer> st=Stream.generate(()->(int)(Math.random()*500+1));
		st.forEach(i->System.out.println(i));
	}

}
