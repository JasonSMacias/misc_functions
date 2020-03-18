package cracking.ch1;

import java.util.ArrayList;
import java.util.List;

public class Question1_3 {
	
	// my first attempt, works, seems not too time complex - 
	// solution from book turned out to be essentially the same as this, but a little 
	// more concise
	public String urlify(String s, int l) {
		char[] sArr = s.toCharArray();
		List<Integer> spaceIndexes = new ArrayList<>();
		int lastNonSpaceIndex = -1;
		int count = 0;
		String toReturn = null;
		for (int i = 0; i < sArr.length; i++) {
		
			if (sArr[i] == ' ' && sArr[i+1] == ' ') {
				lastNonSpaceIndex = i-1;
				break;
			}
			
			if (sArr[i] == ' ' && sArr[i+1] != ' ') {
				spaceIndexes.add(i);
			}
			
		}
		if (spaceIndexes.isEmpty()) {
			toReturn = s;
		}
		else {
			count = 0;
			for (int i = lastNonSpaceIndex; i > -1; i--) {
				if (sArr[i] != ' ') {
					sArr[i + (spaceIndexes.size() - count) * 2] = sArr[i];
				}
				else {
					sArr[i + (spaceIndexes.size() - count) * 2] = '0';
					sArr[(i + (spaceIndexes.size() - count) * 2) - 1] = '2';
					sArr[(i + (spaceIndexes.size() - count) * 2) - 2] = '%';
					count++;
					
				}
			}
			toReturn = new String(sArr);
		}
		
		return toReturn.trim();
	}
}
