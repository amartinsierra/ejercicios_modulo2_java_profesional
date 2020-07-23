package principal;

import java.util.Calendar;
import java.util.Locale;

public class TestCalendar {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance(new Locale("es_ES"));
		System.out.println(cal);
		System.out.println("Año: "+cal.get(Calendar.YEAR));
		System.out.println("Mes: "+cal.get(Calendar.MONTH));
		System.out.println("Día: "+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Hora: "+cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minutos: "+cal.get(Calendar.MINUTE));
		System.out.println("Dia semana: "+cal.get(Calendar.DAY_OF_WEEK));
	}

}
