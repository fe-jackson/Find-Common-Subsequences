//Fe Jackson
//Program 3

import java.util.Scanner;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.io.File;

class ReadLines {
    public static void main(String[] args) {
	if (args.length != 1)
	    System.out.println("You didn't provide an input file name.");
	else {
	    List<String> list = new ArrayList<String>();
	    List<String> substring_list = new ArrayList <String>();
	    FindCommonSubsequences search;
	    int index;
	    int length;

	    try {
		Scanner sc = new Scanner(new File(args[0]));
		while (sc.hasNextLine()) {
		    String line = sc.nextLine();
		    list.add(line);
		}
	    } 
	    catch (Exception e) {
		System.out.println("Error: " + e.getMessage());
	    }

	    search = new FindCommonSubsequences (list);
	    substring_list.addAll (search.getCommonSubsequences ());
	    length = substring_list.size ();
	    System.out.println ("Found the following DNA sequences in all strands:");
	    for (index = 0; index < length; ++index) {
		System.out.println (substring_list.get (index));
	    }
	}
    }
}
