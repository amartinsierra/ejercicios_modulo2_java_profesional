package principal;

import service.PersonasService;

public class TestFront {

	public static void main(String[] args) {
		PersonasService service=new PersonasService();
		service.personasAgrupadasPorDominio()
			.forEach((k,V)->{
				System.out.println("Dominio "+k+" :");
				V.forEach(p->System.out.println(p.getNombre()));
			});
	}

}
