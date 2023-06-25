package Collection_Program;

import java.util.ArrayList;
import java.util.Scanner;

class Customer {
	private int id;
	private String name;
	private String email;

	public  Customer() {

	}

	public Customer(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	
}
	public class RCB {

		public static void main(String[] args) {

			ArrayList<Customer> lst = new ArrayList<Customer>();
			Scanner sc = new Scanner(System.in);

			System.out.println("how many customer are visit your shop ?");
			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				int id = 1001+i;
				String name = sc.next();
				String email = sc.next();
				Customer c = new Customer(id, name, email);
				lst.add(c);
				System.out.println("customer visited your shop");

			}
			display(lst);
		}

		private static void display(ArrayList<Customer> lst) {
			for(Customer l:lst) {
				System.out.println(l.getId()+" "+l.getName()+" "+l.getEmail());
			}
			
		}

		 

		
	}

