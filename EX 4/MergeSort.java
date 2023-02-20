
import java.util.Comparator;
import java.util.Arrays;

/*********************************************************
 1. Explain the mergesort

 A merge sort is a type of a divide and conquer algorithm used to sort a given array; this means that the array is
 divided into halves and then further sub-divided till division can no longer take place. This happens when you reach a
 single element array as that has no middle to further divide the array on.


 int[] a = {5, 3, 4, 7, 1, 2}

 * 5, 3, 4, 7, 1, 2
 *     /     \
 * 5,3,4     7,1,2      // We divide into two halves
 *  / \       / \
 * 5  3,4    7   1,2    // if L < R, M=L+(R-1)/2
 * |   / \   |   / \
 * 5  3  4   7  1   2   // We divide the array into the smallest unit
 * |  \  /   |   \ /
 * 5   3,4   7   1,2
 *  \  /      \   /
 *  3,4,5       1,2,7   //We merge based on comparision of elements
 *       \     /
 *     1,2,3,4,5,7	    //SORTED



 ----------------------------------------------------

 2.1 Explain the divide-and-conquer principle


 DIVIDE: it divides the unsorted list into many sublists until each containing one element

 CONQUER: Conquer the sublists by solving them as base cases, a list of one element is considered sorted

 Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining.
 This will be the sorted list

 2.2  Yes this version of mergesort requires more memory

 ------------------------------------------------------------


 3.  Yes, it is stable.

 When merging two halves, just make sure to use “L <= R” so that you favor left-half values over right-half values,
 if they are equal.


 **********************************************************/



public class MergeSort {
  //-------------------------------------------------------------------//
  private static <T> void msort(T[] array, T[] copy, int l, int r,
                                Comparator<T> c) {
    int i, j, k;

    if (r > l) {
      // Divide the field to be sorted
      int mid = (r + l) / 2;

      // Sort sublist
      msort(array, copy, l, mid, c);
      msort(array, copy, mid + 1, r, c);

      for (i = mid + 1; i > l; i--)
        copy[i - 1] = array[i - 1];
      for (j = mid; j < r; j++)
        copy[r + mid - j] = array[j + 1];

      for (k = l; k <= r; k++) {
        if (c.compare(copy[i], copy[j]) < 0)
          array[k] = copy[i++];
        else
          array[k] = copy[j--];
      }
    }
  }

  public static <T> void mergeSort(T[] a, Comparator<T> c) {
    // TODO: mergesort for generics
    msort(a, (T[]) new Object[a.length], 0, a.length - 1, c);
  }

  //-------------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test for Strings (sort ascending and descanding)
    String[] Firstnames = { "Ifeanyi", "Agu", "Izu","Nnaemeka", "Max", "Lee", "Lucas", "Dozie", "Ben", "Duke",
            "David", "Jonas", "JohnPaul", "Paul", "Lis", "Lossy",  "Luca", "Luk", "James", "Onyebu", "Timm",
            "Elias", "Maxi", "Nosa",
    };
    Comparator<String> asc = new Comparator<String>() {
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    };
    System.out.println(Arrays.toString(Firstnames));
    mergeSort(Firstnames, asc);
    System.out.println(Arrays.toString(Firstnames));
    System.out.println();

    Comparator<String> desc = new Comparator<String>() {
      public int compare(String o1, String o2) {
        return o2.compareTo(o1);
      }
    };
    System.out.println(Arrays.toString(Firstnames));
    mergeSort(Firstnames, desc);
    System.out.println(Arrays.toString(Firstnames));
  }
}
