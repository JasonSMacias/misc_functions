package problems;

public class Driver {
  static Problem1 prob1 = new Problem1();
  static Problem2 prob2 = new Problem2();
  static Problem3 prob3 = new Problem3();
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println(prob1.sumMultiples());
      System.out.println(prob2.fibEvensSum(4_000_000));
      System.out.println(prob3.getLPF(-1));
      System.exit(0);
    }
    try {
      Integer.parseInt(args[0]);
    }catch (NumberFormatException e){
      System.out.println("Argument must be a number that corresponds to a problem");
      System.exit(1);
    }
    switch (args[0]) {
      case "1":
        System.out.println(prob1.sumMultiples());
        break;
      case "2":
        System.out.println(prob2.fibEvensSum(4_000_000));
        break;
      case "3":
        System.out.println(prob3.getLPF(-1));
        break;
      default:
        System.out.println("There is not problem corresponding to the argument supplied");
        System.exit(1);
    }    
  }
}
