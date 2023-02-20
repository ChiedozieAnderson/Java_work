import java.util.Arrays;

public class RandomIntArray {

  public static int[] createRandom(int n) {
    // TODO: implementation
    int[] mineArray = new int[n];
    for (int i=0; i<n;i++) {
      mineArray[i] = (int)(Math.random() * (99-5) + 5);
    }
    return mineArray;
  }

  public static String toString(int[] a) {
    // TODO: implementation
    String mineString = "[";
    for (int i=0;i<a.length - 1; i++){
      if (i==0){
        mineString += Integer.toString(a[i]) + ",";
      }
      else {
        mineString += " " + Integer.toString(a[i]) + ",";
      }
    }
    mineString += " " + a[a.length-1] + "]";
    return mineString;
  }


  public static int posMin(int[] a) {
    // TODO: implementation
    int smallest = Integer.MAX_VALUE;
    for (int i=0; i<a.length; i++){
      if(a[i]<smallest){
        smallest=a[i];
      }
    }
    for (int i=0;i<a.length;i++) {
      if (smallest == a[i]) {
        return i;
      }
    }
    return 0;
  }

  public static void swap(int[] a) {
    // TODO: implementation
    int firstNum = a[0];
    int lastNum = a[a.length-1];

    a[0] = lastNum;
    a[a.length-1]= firstNum;
  }
  int[] a = createRandom(5);
  public static void main(String[] args)
  {
    int[] a = createRandom(9);
    System.out.println(toString(a));
    System.out.println(Arrays.toString(a));
    System.out.println(posMin(a));
    swap(a);
    System.out.println(Arrays.toString(a));
  }
}
