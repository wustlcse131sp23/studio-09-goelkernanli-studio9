package studio9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import support.cse131.NotYetImplementedException;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2; key="be", value=2; key="or", value=1; key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {
		Map<String, Integer> ret = new HashMap<>();
		/*
		 * while (words.size() > 0) { String check = words.get(0); int count = 0; for
		 * (int i = 0; i < words.size(); i++) if (words.get(i).equals(check)) { count++;
		 * words.remove(i); i--; } ret.put(check, count); }
		 */
		for (String i : words) {
			if (!ret.containsKey(i))
				ret.put(i, 1);
			else {
				int x = ret.get(i);
				ret.remove(i);
				ret.put(i, x+1);
			}
		}

		return ret;
	}
}
