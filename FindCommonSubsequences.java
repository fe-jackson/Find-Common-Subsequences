//Fe Jackson
//Program 3

import java.util.*;

public class FindCommonSubsequences {
	private ArrayList<String> string_list;
	private LinkedList<String> common_substring_list;

	public FindCommonSubsequences (Collection<? extends CharSequence> to_search) {
		string_list = new ArrayList<String>();
		Iterator<? extends CharSequence> it = to_search.iterator ();
		
		while (it.hasNext ())
			string_list.add(it.next().toString());
	
		common_substring_list = new LinkedList <String> ();
		makeList();	
	}

	public ArrayList<String> getCommonSubsequences () {
		ArrayList<String> get = new ArrayList<String>(common_substring_list);
		return get;
	}
	
	private void makeList () {
		int length = string_list.size ();
		
		if (length ==  1) {
			if (string_list.get (0).length () >= 5) 
				common_substring_list.add (string_list.get (0));
		}
		else if (length > 1) {
			String first_string = string_list.get (0);
			String cur_string = string_list.get (1);
			int cur_index = 1;
			boolean no_common_substrings = false;

			if (first_string.length () < 5 || cur_string.length() < 5) 
				no_common_substrings = true;
			else {	
				if (compareTwo (first_string, cur_string) == true){
					checkWholeList (); //check the rest of the list for matches
					optimizeList ();
				}
			}
		}
	}

	private boolean compareTwo (String str1, String str2) {			
		int first_index = 0;
		int last_index = 5;
		int temp;
		int str1_length = str1.length ();
		boolean substring_found = false;

		while (last_index <= str1_length) {
			if (substring_found = str2.contains (str1.substring (first_index, last_index))) {
				common_substring_list.add (str1.substring (first_index, last_index));
				temp = last_index + 1;
			
				while (substring_found == true && temp < str1_length) {
					if (substring_found = str2.contains (str1.substring (first_index, temp)))
						common_substring_list.add (str1.substring (first_index, temp));
					
					++temp;
				}
			}
			++first_index;
			++last_index;
		}
	
		if (common_substring_list.isEmpty() == false)
			substring_found = true;
	
		return substring_found;
	}
					
	private void checkWholeList () {
		int length = string_list.size (); //the length (size) of string_list
		int cur_index1; //the current index in string_list
		int cur_index2; //the current index in common_substring_list
		String cur_string;

		for(cur_index1 = 2; cur_index1 < length && common_substring_list.isEmpty () == false; ++cur_index1) {
			cur_string = string_list.get(cur_index1);
			cur_index2 = 0;	

			while (cur_index2 < common_substring_list.size ()) {
				if (cur_string.contains (common_substring_list.get(cur_index2)))
					++cur_index2;
				else
					common_substring_list.remove (cur_index2);
			}
			++cur_index1;
		}
	}

	private void optimizeList () {
		int index1 = 0;
		int index2;
		String cur;
		LinkedList <String> temp = new LinkedList<String>();
		int biggest;
		int length;
		
		while (index1 < common_substring_list.size ()) {
			if (common_substring_list.get(index1).length() > 15)
				common_substring_list.remove(index1);
			else
				++index1;
		}
	
		for (index1 = 0; index1 < common_substring_list.size (); ++index1) { 
			cur = common_substring_list.get (index1);
			index2 = index1 + 1;
			
			while (index2 < common_substring_list.size ()) {
				if (index2 != index1 && cur.contains (common_substring_list.get(index2))) {
					common_substring_list.remove(index2);
					
					if (index1 > index2)
						--index1;
				}
				else if (index2 != index1 && common_substring_list.get(index2).contains (cur)) {
					common_substring_list.remove (index1);
					index2 = common_substring_list.size ();
					--index1;
				}
				else
					++index2;
			}
		}
		while (common_substring_list.isEmpty () == false) {
			length = common_substring_list.size ();
			cur = common_substring_list.get(0);
			biggest = 0;

			for (index1 = 1; index1 < length; ++index1) {
				if (common_substring_list.get(index1).length() > cur.length()) {
					biggest = index1;
					cur = common_substring_list.get(index1); 
				}
			}
			temp.add (cur);
			common_substring_list.remove(biggest);
		}
		common_substring_list.addAll (temp);
	}
}
