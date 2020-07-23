package principal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDate {

	public static void main(String[] args) {
		Date nf=null;
		Date fecha=new Date();
		System.out.println(fecha);
		System.out.println(fecha.getTime());
		
		DateFormat df=DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, new Locale("es"));
		System.out.println(df.format(fecha));
		
		SimpleDateFormat sdt=new SimpleDateFormat("YY-dd-MM  HH:mm");
		System.out.println(sdt.format(fecha));
		
		
		//parseado fechas
		SimpleDateFormat personalizado=new SimpleDateFormat("dd-MM-yyyy");
		String mifecha="30-22-2020";
		try {
			nf=personalizado.parse(mifecha);
			System.out.println(nf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(nf.after(fecha)) {
			
		}
		
		
	}

}
