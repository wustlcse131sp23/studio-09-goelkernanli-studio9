package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Integer> x = new HashMap<>();
		do {
			System.out.println("Enter name");
			String n = in.next();
			System.out.println("Enter height");
			int h = in.nextInt();
			x.put(n, h);
			System.out.println("continue? (Y/N)");
		}while (in.next().equals("Y"));
		
		do {
			System.out.println("Which student");
			System.out.println(x.get(in.next()) + " is the students hieght");
			System.out.println("continue? (Y/N)");
		}while (in.next().equals("Y/N"));
	
		
		throw new NotYetImplementedException();

	}
}
