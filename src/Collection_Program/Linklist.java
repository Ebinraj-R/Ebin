package Collection_Program;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Linklist {

	public static void main(String[] args) {
	LinkedList  lst =  	 new LinkedList();
	
	lst.add(20);
	lst.add(null);
	lst.add("ebin");
	lst.add(20);
	lst.add(75);
	lst.add(54);
//	System.out.println(lst.getLast());
//System.out.println(lst.pollLast());
//	System.out.println(lst.peekLast());
   System.out.println(lst);

	//lst.pollFirst();
	//lst.getFirst();
	
/*	Iterator itr = lst.iterator();
	lst.remove();
	
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}*/
   
   ListIterator lit = lst.listIterator();
   
   while (lit.hasNext()) {
	   System.out.println(lit.next());
   }
   
   
   while(lit.hasPrevious()) {
	   System.out.println(lit.previous());
   }
  
	
	}

}
