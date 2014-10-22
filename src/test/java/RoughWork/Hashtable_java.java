package RoughWork;

import java.util.Hashtable;



public class Hashtable_java {

	public static void main(String[] args) {
		Hashtable<String, String> table= new Hashtable<String,String>();
		table.put("place", "korea");
		table.put("name", "om");
		table.put("gender", "male");
		System.out.println(table.get("name"));
		
		

	}

}
