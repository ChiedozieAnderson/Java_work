import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.out;

public class MedianOfThree {
  //We will use list
  public static int median(int a, int b, int c) {
    // TODO: add implementation
    ArrayList<Integer> myNumberList = new ArrayList<Integer>();
    myNumberList.add(a);
    myNumberList.add(b);
    myNumberList.add(c);

    //Sort the numbers
    Collections.sort(myNumberList);

    int median = myNumberList.get(1);
    return median;

  }

  public static int median2(int a, int b, int c) {
    // TODO: add implementation
    int[] myNumberArray = {a,b,c};
    Arrays.sort(myNumberArray);
    return myNumberArray[1];
  }

  public static void main(String[] args) {
    // TODO: add test cases
    out.println(median(2,42,43));
  }
}
