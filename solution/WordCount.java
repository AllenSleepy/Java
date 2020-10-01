import java.util.*;

public class WordCount {
	/**
	 * Gets the top occurrence in the book and case insensitive
	 * @param book The target book
	 * @param top The top occurrence
	 * @param words The top words
	 * @param frequencies The frequencies of the words
	 * @return The total number of words
	 */
	public static int topOccurrence(Book book, int top, List<String> words, List<Integer> frequencies) {
		int totalWords = 0;
		// Creating wordCountMap which holds words as keys and their occurrences as values
		HashMap<String, Integer> wordCountMap = new HashMap();
		for (String line : book.getBody()) {
			System.out.println(line);
			String[] string = line.toLowerCase().split("([,.\\s]+)");
			totalWords += string.length;
			for (String str : string) {
				// If word is already present in map, updating its count
				if (wordCountMap.containsKey(str)) {
					wordCountMap.put(str, wordCountMap.get(str) + 1);
				}
				else {
					// Otherwise inserting the word as key and 1 as its value
					wordCountMap.put(str, 1);
				}
			}
		}

		ValueComparator bvc =  new ValueComparator(wordCountMap);
		TreeMap<String, Integer> sortedMap = new TreeMap(bvc);
		sortedMap.putAll(wordCountMap);
		// System.out.println(sortedMap);
		int idx = 0;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			if (idx < top) {
				words.add(entry.getKey());
				frequencies.add(entry.getValue());
			}
			idx++;
		}

		return totalWords;
	}


	static class ValueComparator implements Comparator<String> {
		Map<String, Integer> base;
		public ValueComparator(Map<String, Integer> base) {
			this.base = base;
		}

		public int compare(String a, String b) {
			if (base.get(a) >= base.get(b)) return -1;
			else return 1;
		}
	}
}
