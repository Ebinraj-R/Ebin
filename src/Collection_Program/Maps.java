package Collection_Program;

import java.util.HashMap;
import java.util.Iterator;

public class Maps {

	public static void main(String[] args) {
		 HashMap<String,String> hm  =  new  HashMap<String,String>();
		  
		 System.out.println(hm);
		 hm.put("Name","RC 390");
		 hm.put("Manufacturer ", "KTM");
		 System.out.println(hm);
		 System.out.println(hm.put("cc","390"));
		 hm.put("price","3,50,000");
		 hm.put("Mileage","24.5 kmpl");
		 hm.put("TopSpeed ","173 km/hr");
		 
		System.out.println(hm.values());
		 

		 //System.out.println(hm.put("cc","200"));
		// System.out.println(hm.get("cc"));

	}

}
