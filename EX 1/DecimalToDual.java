public class DecimalToDual {

  public static String transformDual(int dec) {
    // TODO: Implement your solution here
    int remainder ;
    String output= "";

    if (dec == 0){
      System.out.println("0");
    }
    if (dec < 0){
      System.out.println("Error Message");
    }
    while (dec > 0){
      remainder = dec % 2;
      output = remainder + output;
      dec = dec/2;
    }
    return output;
  }

  public static void main(String[] args) {
    // TODO: Test your solution with appropriate test cases
    System.out.println(transformDual(10));
  }
}
