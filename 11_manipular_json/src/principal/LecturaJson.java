package principal;

import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaJson {

	public static void main(String[] args) {
		String json="[{\"numeroPedido\":200, \"producto\":\"Galletas\",\"precio\":20.5}," + 
				"{\"numeroPedido\":100, \"producto\":\"Balón\",\"precio\":2.2}]";
		
		//creamos objeto JSONParser
		JSONParser parse=new JSONParser();
		//leemos el documento y lo volcamos en una variable JSONArray
		try {
			JSONArray array=(JSONArray)parse.parse(json);
			/*for(int i=0;i<array.size();i++) {
				JSONObject ob=(JSONObject)array.get(i);
				System.out.println(ob.get("producto"));
			}*/
			/*array.forEach(ob->System.out.println(((JSONObject)ob).get("producto")));*/
			Stream<JSONObject> st=(Stream<JSONObject>)array.stream();
			st.forEach(ob->System.out.println(ob.get("producto")));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
