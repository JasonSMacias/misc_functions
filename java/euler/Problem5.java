package problems;
// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?


public class Problem5 {
  public long getSmallestDivisibleBy1to20() {
    OUTER: for (long l = 20; l <= Long.MAX_VALUE; l += 20){
      INNER:for (int i = 1; i <= 20; i++) {
        if (l % i != 0) {
          continue OUTER;
        }
      }
      return l;
    }
    return -1L;
  }
}