package problems;

import java.lang.Math;

// The prime factors of 13195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143 ?
public class Problem3 {
	public long getLPF(long l) {
		long retVal = 1;
		if (l < 2) {
			// for negative parameters, using project Euler number
			l = 600851475143L;
		}
		while(l % 2 == 0) {
			retVal = 2;
			l /= 2;
		};
		for(long i = 3; i < Math.sqrt(l); i += 2) {
			while (l % i == 0) {
				l /= i;
				retVal = i;
			}
		}
		if (l > 2) {
			retVal = l;
		}
		return retVal;
	}
}
