package problems;

// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
// Find the largest palindrome made from the product of two 3-digit numbers.
public class Problem4 {
	public int findLargestPalidrome() {
    int retVal = 0;
    for (int smallest = 100; smallest < 1000; smallest++) {
      for (int i = smallest; i < 1000; i++) {
        int prod = i * smallest;
        String prodString = String.valueOf(prod);
        String revProdString = new StringBuilder(prodString).reverse().toString();
        if (prodString.equals(revProdString)) {
          retVal = prod > retVal ? prod : retVal;
        }
      }
    }
    return retVal;
	}
}
