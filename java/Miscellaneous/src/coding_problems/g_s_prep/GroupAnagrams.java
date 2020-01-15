package coding_problems.g_s_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/* 	This is another attempt at an interview question that I ran out of time on, 
 * 	reimplemented using the Stream api as much as possible, for practice */

	public class GroupAnagrams {
		/* 	--------------Instructions----------------
		 	create a method that takes in an array of strings and returns a set of 
			sets of anagrams */
		public static void main(String[] args) {
			String[] sArr = {"cat", "dog", "act", "god", "stream", "metras", "ignatius", "tac"};
			Set<Set<String>> anagramSets = groupAnagrams(sArr);
			System.out.println("Should print the following sets:\n"
					+ "\t cat, act, tac"
					+ "\n\t dog, god"
					+ "\n\t stream, metras"
					+ "\n\t ignatius"); 
			System.out.println(anagramSets);
			
		}
		
		private static Set<Set<String>> groupAnagrams(String[] arr) {
			List<String> list = new ArrayList<>(Arrays.asList(arr));
			// Stream to sort and reduce to an array of ordered pairs of the form 
			// {sorted, unsortedOriginal, sorted, unsortedOriginal}
			List<String> sortedPairList = list.stream()
			.map(s -> s.toCharArray())
			.map(cA -> {
				String unsorted = new String(cA);
				Arrays.sort(cA);
				String[] ar = {new String(cA), unsorted};
				List<String> pair = Arrays.asList(ar);
				return pair;
				})
			.reduce(new ArrayList<>(), (partialList, pair) -> {
				partialList.addAll(pair);
				return partialList;
			});
			
			// using list of paired elements to generate a hashmap with those pairs as k v
			Map<String, Set<String>> mapOfSets = new HashMap<String, Set<String>>();
			for (int i = 0; i < sortedPairList.size(); i += 2) {
				Set<String> val = new HashSet<String>();
				String key = sortedPairList.get(i);
				String newString = sortedPairList.get(i + 1);
				val.add(newString);
				Object o = mapOfSets.putIfAbsent(key, val);
				
				if (o != null) {
					mapOfSets.get(key).add(newString);
				}
			}
			
			// returning the map values in a set
			return mapOfSets
				.values()
				.stream()
				.collect(Collectors.toSet());
		}
}
