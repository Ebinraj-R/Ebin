package Collection_Program;

import java.util.Enumeration;
import java.util.Stack;

public class Cursor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		s.push(10);
		s.push(30);
		s.push(40);
		s.push(50);
		System.out.println(s);
		
	//	System.out.println(s.pop());
	//	System.out.println(s);
	//	System.out.println(s.peek());
	//	System.out.println(s.search(20));
		System.out.println(s.empty());
		Enumeration e = s.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
			
		}

	}

}
