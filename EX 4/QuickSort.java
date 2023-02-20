import java.sql.Time;
import java.util.Arrays;
import java.util.Random;
 

/*********************************************************
 1. Explain Quick sort

 public class Quicksort {


 * 5 3 4 8 7 1 2
 * ^         ^   // the pivot  here is "2"
 * i         j

 * Increment i when a[i] < 2
 * 5 < 2 -> false
 * Decrement j when a[j] > 2
 * 1 > 2 -> false
 * Swap a[i] and a[j]

 * 1 3 4 8 7 5 2
 * ^         ^   // the pivot  here is "2"
 * i         j

 * Increment i when a[i] < 2
 * 1 < 2

 * 1 3 4 8 7 5 2
 *   ^       ^   // the pivot  here is "2"
 *   i       j
 * 3 < 2 -> false
 * Decrement j when a[j] > 2
 * 5 > 2

 * 1 3 4 8 7 5 2
 *   ^     ^     // the pivot  here is "2"
 *   i     j
 * ... as long i < j

 * 1 3 4 8 7 5 2
 * ^ ^           // the pivot  here is "2"
 * j i
 * 1 > 2 -> false
 * Swap a[i] and a[j]
 * 3 1 4 8 7 5 2
 * ^ ^           // the pivot  here is "2"
 * j i

 * Swap a[i] and a[j]
 *
 * 1 3 4 8 7 5 2
 * ^ ^           // the pivot  here is "2"
 * j i

 * Swap a[i] and the pivot

 * 1 2 4 8 7 5 3
 * ^ ^           // the pivot  here is "2"
 * j i

 * -> Curse of Recursion with old left border(0) and right border is position of i - 1 (0)

 * 1 2 4 8 7 5 3
 * ^             // the pivot  here is "2"
 * i
 * j

 * -> r > l -> false, so don't do this way

 * -> Curse of Recursion with left border = i +1 (2) and old right border (6)
 * 1 2 4 8 7 5 3
 *     ^     ^   // the pivot  here is "3"
 *     i     j

 * Increment i when a[i] < 3
 * 4 < 3 -> false
 * Decrement j when a[j] > 3
 * 5 > 3
 * 1 2 4 8 7 5 3
 *     ^   ^     // the pivot  here is "3"
 *     i   j
 ........
 * 1 2 4 8 7 5 3
 *   ^ ^         // the pivot  here is "3"
 *   j i

 * 2 > 3 -> false
 * Swap a[i] and a[j]
 * 1 4 2 8 7 5 3
 *   ^ ^         // the pivot  here is "3"
 *   j i

 * Swap a[j] and a[i]
 * 1 2 4 8 7 5 3
 *   ^ ^         // the pivot  here is "3"
 *   j i
 * Swap [i] and the pivot
 * 1 2 3 8 7 5 4
 *   ^ ^         // the pivot  here is "3"
 *   j i


 * 1 2 3 4 5 7 8   // SORTED
 .....................................................................................................


 * Worst Case:

 * 1 2 3 4 5 6 7 8
 * the pivot  here= 1
 * -> here we have to swap everything and create new recursions just for one swap
 O(n²)

 * Average case:
 O ((n-1)/2)

 * Best case:
 * Sublists are all equal
 O (n * ln n)

 *************************************************************************/





public class QuickSort {
    public static <T extends Comparable<T>> void quickSort(T[] a) {
        // TODO: quicksort-algorithm for generics
        quickSort(a, 0, a.length - 1);


    }



    private static <T extends Comparable<T>> void quickSort(T[] a, int l, int r) {
        if (r > l) { // [al, . . . ,ar]
            int m = partition(a, l, r); // pivot p = am
            quickSort(a, l, m - 1);
            quickSort(a, m + 1, r);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int l, int r) {
        assert (l <= r);
        T p = a[r], temp;

        int i = l, j = r - 1;
        do {
            while (a[i].compareTo(p) < 0)
                ++i; // find
            while (j > 0 && a[j].compareTo(p) > 0)
                --j;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp; // swap
        }
        while (i < j);

        a[j] = a[i];
        a[i] = a[r];
        a[r] = temp;
        return i; // new index
    }

    public static void main(String[] args){
        Clock[] Clockarray = new Clock[20];
        Random rand = new Random();
        for (int index = 0; index < 20; index++)
        {

            int h = 0 + (int)(Math.random() * ((23 - 0) + 1));
            int min = 0 + (int)(Math.random() * ((59 - 0) + 1));
            Clockarray[index] = new Clock(h,min);
        }
        System.out.println("Clock Array Unsorted....");
        for(int i = 0;i < 20;i++){

            System.out.println(Clockarray[i].toString());
        }

        quickSort(Clockarray);
        for(int i = 0;i < 20;i++){

            System.out.println(Clockarray[i].toString());
        }
    }
}