package Collection_Program;

import java.util.ArrayList;

public class List {

	public static void main(String[] args) {
	 ArrayList al = new ArrayList();
	 al.add(10);
	 al.add("stem");
	 al.add(23);
	 al.set(1,"ebin");
	 al.add(23);
	 System.out.println(al.contains("ebin"));
	System.out.println(al.size()); 
	System.out.println(al.lastIndexOf(23));
	System.out.println(al.toArray());
	 
	 ArrayList al2 = new ArrayList();
	 
	 al2.addAll(al);
	 System.out.println(al);
	 al2.add(54);
	 System.out.println(al2);

	}

}
