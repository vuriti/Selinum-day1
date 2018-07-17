package Day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class arrylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> aarylis = new ArrayList<>();
		LinkedList<Integer> aa = new LinkedList<>();
		
		HashSet<String> ravi = new HashSet<>();
		
		LinkedHashSet<String> Teja = new LinkedHashSet<>();
		
		
		Teja.isEmpty();
	
		
		ravi.add("ravi teja");
		ravi.add("teja");
		ravi.add("ravi teja");
		ravi.add("vuriti teja");
		
		for (String temp:ravi) {
			
			System.out.println(temp);
		}
		
 		//this will add at last avible position
		aarylis.add(12);
		aarylis.add(13);
		aarylis.add(14);
	    aarylis.add(15);
	    aarylis.add(16);
	    aarylis.add(17);
	    aarylis.add(18);
	    aarylis.add(19);
	    aarylis.add(3, 78);
	    
	    aa.add(23);
	    
	    System.out.println(aa.isEmpty());
	    
	    for(Integer temp:aarylis) {
	    	System.out.println(temp);
	    	System.out.println(aarylis.size());
	    	System.out.println(aarylis.contains(13));
	    }
	}
}
