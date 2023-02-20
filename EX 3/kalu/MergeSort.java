import java.util.Arrays;
import java.util.Random;

/**
 * author: copypasteearth
 * date: 7/17/2019
 */
public class MergeSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void merge(int leftFirst, int leftLast, int rightFirst, int rightLast, T[] array){
        T[] tempArray = Arrays.copyOf(array,array.length);
        int index = leftFirst;
        int saveFirst = leftFirst;

        while((leftFirst <= leftLast) && (rightFirst <= rightLast)){
            if(array[leftFirst].compareTo(array[rightFirst]) < 0){
                tempArray[index] = array[leftFirst];
                leftFirst++;
            }else{
                tempArray[index] = array[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while(leftFirst <= leftLast){
            tempArray[index] = array[leftFirst];
            leftFirst++;
            index++;
        }
        while(rightFirst <= rightLast){
            tempArray[index] = array[rightFirst];
            rightFirst++;
            index++;
        }
        for(index = saveFirst; index <= rightLast;index++){
            array[index] = tempArray[index];
        }
    }
    public static <T extends Comparable<T>> void mergeSort(int first, int last,T[] array){
        if(first < last){
            int middle = (first + last) / 2;
            mergeSort(first,middle,array);
            mergeSort(middle+1,last,array);
            merge(first,middle,middle+1,last,array);
        }
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

            System.out.println(Clockarray[i]);
        }
        MergeSort<Clock> msClock = new MergeSort<Clock>();
        msClock.mergeSort( 0, Clockarray.length-1,Clockarray);
        System.out.println("Clock Array Sorted");
        for(Clock i: Clockarray) {
            System.out.println(i);
        }
    }
}


