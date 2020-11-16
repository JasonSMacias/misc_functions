package problems;

public class Driver {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please supply a problem number");
      System.exit(1);  
    }
    try {
      Integer.parseInt(args[0]);
    }catch (NumberFormatException e){
      System.out.println("Argument must be a number that corresponds to a problem");
      System.exit(1);
    }
    switch (args[0]) {
      case "1":
        Problem1 prob1 = new Problem1();  
        System.out.println(prob1.sumMultiples());
        break;
      case "2":
        Problem2 prob2 = new Problem2();
        System.out.println(prob2.fibEvensSum(4_000_000));
        break;
      case "3":
        Problem3 prob3 = new Problem3();
        System.out.println(prob3.getLPF(-1));
        break;
      case "4":
        Problem4 prob4 = new Problem4();
        System.out.println(prob4.findLargestPalidrome());
        break;
      case "5":
        Problem5 prob5 = new Problem5();
        System.out.println(prob5.getSmallestDivisibleBy1to20UsingPrimeFactors());
        break;
      default:
        System.out.println("There is not a problem corresponding to the argument supplied");
        System.exit(1);
    }    
  }
}
