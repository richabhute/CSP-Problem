import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashSet;

public class CSP_Puzzle extends CSP {
	
	public boolean isGood(Object X, Object Y, Object x, Object y) {
		//if X is not even mentioned in by the constraints, just return true
		//as nothing can be violated
		if(!C.containsKey(X))
			return true;
		
		//check to see if there is an arc between X and Y
		//if there isn't an arc, then no constraint, i.e. it is good
		if(!C.get(X).contains(Y))
			return true;
		
		//not equal constraint
		if(!x.equals(y)) 
			return true;
		
		return false;
	}
		
	public static void main(String[] args) throws Exception {
		CSP_Puzzle csp = new CSP_Puzzle();
	
		String[] vars = {"Englishman", "Spainiard", "Ukrainian", "Norwegian", "Japanese", 
						 "Coffee", "Tea", "Milk", "Orange-juice", "Water", "Dog", "Snails", 
						 "Fox", "Horse", "Zebra", "Old-Gold", "Kools", "Chesterfield", 
						 "Lucky-Strike", "Parliament", "Red", "Green", "Ivory", "Yellow", "Blue"};
		
		String[] houses = {"1", "2", "3", "4", "5"};
		String[][] pairs = {
								{"Englishman", "Blue"}, {"Englishman", "Yellow"}, {"Englishman", "Green"}, 
								{"Englishman", "Ivory"}, 
								{"Spainiard", "Snails"}, {"Spainiard", "Fox"}, {"Spainiard", "Horse"}, 
								{"Spainiard", "Zebra"},
								{"Coffee", "Red"}, {"Coffee", "Ivory"}, {"Coffee", "Yellow"}, {"Coffee", "Blue"}, 
								{"Ukrainian", "Coffee"}, {"Ukrainian", "Milk"},{"Ukrainian", "Orange-juice"},
								{"Ukrainian", "Water"}, 
								{"Ukrainian", "Coffee"},
								{"Old-Gold", "Dog"}, {"Old-Gold", "Fox"}, {"Old-Gold", "Horse"}, {"Old-Gold", "Zebra"},
								{"Kools", "Red"}, {"Kools", "Green"}, {"Kools", "Ivory"}, {"Kools", "Blue"},
								{"Kools", "Dog"}, {"Kools", "Zebra"}, {"Kools", "Snails"},{"Kools", "Fox"},
								{"Chesterfield", "Dog"}, {"Chesterfield", "Snails"}, {"Chesterfield", "Horse"},
								{"Chesterfield", "Zebra"},
								{"Lucky-Strike", "Coffee"}, {"Lucky-Strike", "Tea"}, {"Lucky-Strike", "Milk"},
								{"Lucky-Strike", "Water"},
								{"Japanese", "Old-Gold"}, {"Japanese", "Kools"}, {"Japanese", "Chesterfield"}, {"Japanese", "Lucky-Strike"},
								{"Norwegian", "Red"}, {"Norwegian", "Green"}, {"Norwegian", "Ivory"}, {"Norwegian", "Yellow"}, 
								{"Green", "Ivory"},{"Red", "Blue"}, {"Red", "Green"}, {"Red", "Ivory"}, {"Red", "Yellow"},{"Green", "Yellow"}, {"Green", "Blue"},
								 {"Blue", "Yellow"}, 
								{"Yellow", "Ivory"}, {"Blue", "Ivory"}, {"Englishman", "Spainiard"}, 
								{"Englishman", "Ukrainian"}, {"Englishman", "Japanese"}, {"Englishman", "Norwegian"}, 
								{"Spainiard", "Ukrainian"}, {"Spainiard", "Norwegian"}, {"Spainiard", "Japanese"}, 
								{"Norwegian", "Japanese"}, {"Norwegian", "Ukrainian"}, {"Ukrainian", "Japanese"}, 
								{"Coffee", "Tea"}, {"Coffee", "Milk"}, {"Coffee", "Orange-juice"}, {"Coffee", "Water"}, 
								{"Milk", "Water"}, {"Milk", "Orange-juice"}, {"Milk", "Tea"}, {"Orange-juice", "Water"}, 
								{"Tea", "Water"}, {"Orange-juice", "Tea"}, {"Dog", "Fox"}, {"Dog", "Snails"}, {"Dog", "Zebra"}, 
								{"Dog", "Horse"}, {"Fox", "Horse"}, {"Fox", "Snails"}, {"Fox", "Zebra"}, {"Horse", "Zebra"},
								{"Horse", "Snails"}, {"Horse", "Snails"}, {"Snails", "Zebra"}, {"Old-Gold", "Parliament"}, 
								{"Old-Gold", "Kools"}, {"Old-Gold", "Chesterfield"}, {"Old-Gold", "Lucky-Strike"}, 
								{"Kools", "Parliament"}, {"Kools", "Lucky-Strike"}, {"Kools", "Chesterfield"}, 
								{"Chesterfield", "Lucky-Strike"}, {"Chesterfield", "Parliament"}, {"Parliament", "Lucky-Strike"}
								
							};

	
		for(Object X : vars) 
			csp.addDomain(X, houses);

		for(Object[] p : pairs)
			csp.addBidirectionalArc(p[0], p[1]);
			
			
		Search search = new Search(csp);
		//System.out.println(search.BacktrackingSearch());

		Map<Object, Object> assign = search.BacktrackingSearch();
		Set<Object> house1 = new HashSet<Object>(); 
		Set<Object> house2 = new HashSet<Object>();
		Set<Object> house3 = new HashSet<Object>();
		Set<Object> house4 = new HashSet<Object>();
		Set<Object> house5 = new HashSet<Object>();
		assign.entrySet().forEach(entry->{
			
			if(entry.getValue() == "1")
				house1.add(entry.getKey());
			
			if(entry.getValue() == "2")
				house2.add(entry.getKey());

			if(entry.getValue() == "3")
				house3.add(entry.getKey());	

			if(entry.getValue() == "4")
				house4.add(entry.getKey());		
			
			if(entry.getValue() == "5")
				house5.add(entry.getKey());
			    		
 		});

 		 System.out.println("1: " + house1);
 		 System.out.println("2: " + house2);
 		 System.out.println("3: " + house3);
 		 System.out.println("4: " + house4);
 		 System.out.println("5: " + house5);
	}
}




//String.valueOf(number)





