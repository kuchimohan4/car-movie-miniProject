package prac;

import java.util.Iterator;
import java.util.UUID;

public class prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String aString=UUID.randomUUID().toString();
		String lit=aString.split("-",2)[0];
		System.out.println(lit);
		
		
	}

}
