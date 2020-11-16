package problems;

import java.util.*;
import java.util.Map.Entry;

// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20? (232792560)

public class Problem5 {
  // Brute force
  public long getSmallestDivisibleBy1to20() {
    OUTER: for (long l = 20; l <= Long.MAX_VALUE; l += 20){
      for (int i = 1; i <= 20; i++) {
        if (l % i != 0) {
          continue OUTER;
        }
      }
      return l;
    }
    return -1L;
  }

  public long getSmallestDivisibleBy1to20UsingPrimeFactors() {
    List<Map> PFFrequenciesList = new ArrayList<>();
    Map<Long, Integer> solutionMap = new HashMap<>();
    for (int i = 2; i <= 20; i++) {
      PFFrequenciesList.add(getPrimeFactors(i));
    }
    for (Map m : PFFrequenciesList) {
      for (Map.Entry<Integer, Integer> entry : (Set<Map.Entry<Integer, Integer>>)m.entrySet()) {
        if (solutionMap.putIfAbsent(entry.getKey() * 1L, entry.getValue()) != null) {
          solutionMap.replace(entry.getKey() * 1L, Math.max(entry.getValue(), solutionMap.get(entry.getKey() * 1L)));
        }
      }
    }
    long retVal = 1;
    for (Map.Entry<Long, Integer> entry : solutionMap.entrySet()) {
      retVal *= Math.pow(entry.getKey(), entry.getValue());
    }
    return retVal;
  }
  
  // Returns a frequency map of primes representing prime factors of a number, for prime factor solution
  private Map getPrimeFactors(int n) {
    Map<Integer, Integer> primeFactorFrequencies = new HashMap<>();
    int twoCount = 0;
    while (n % 2 == 0) {
      twoCount++;
      n /= 2;
    }
    if(twoCount != 0) {
      primeFactorFrequencies.put(2, twoCount);
    }

    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      while (n % i == 0) {
        if(primeFactorFrequencies.putIfAbsent(i, 1) != null){
          int freq = primeFactorFrequencies.get(i);
          primeFactorFrequencies.replace(i, freq + 1);
        }
        n /= i;
      }
    }
    if (n > 1) {
			if (primeFactorFrequencies.putIfAbsent(n, 1) != null) {
        primeFactorFrequencies.replace(n, primeFactorFrequencies.get(n) + 1);
      }
		}
    return primeFactorFrequencies;
  }
}