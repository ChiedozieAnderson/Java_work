import java.util.Arrays;

public class PerfectShuffle {

    public static int[] interleave(int[] a1, int[] a2) {
        // TODO: implementation
        int[] mineArray = new int[a1.length + a2.length];

        int counter = 0;

        for (int i=0;i<mineArray.length;i=i+2){
            mineArray[i]=a1[counter];
            counter++;
        }
        counter=0;
        for (int i=1;i<mineArray.length;i=i+2){
            mineArray[i]=a2[counter];
            counter++;
        }
        return mineArray;
    }

    public static int[] perfectShuffle(int[] a) {
        // TODO: implementation
        if(a.length % 2 == 0){
            int[] a1 = new int[a.length/2];
            int[] a2 = new int[a.length/2];

            for (int i=0;i<a1.length;i++){
                a1[i] = a[i];
            }
            for (int i=0; i< a2.length;i++){
                a2[i] = a[i+ a1.length];
            }
            return interleave(a1,a2);
        }
        return a;
    }

    public static int shuffleNumber(int n) {
        // TODO: implementation
        if((n%2==0) && n>1){
            int[] mineArray1 = new int[n];
            for (int i=0;i<n;i++){
                mineArray1[i] = (int)(Math.random() * (99-5) + 5);
            }
            int[] mineArray2 = perfectShuffle(mineArray1);
            int counter = 1;

            while ( !(Arrays.equals(mineArray1,mineArray2)) ){
                mineArray2=perfectShuffle(mineArray2);
                counter+=1;
            }
            return counter;
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO: implementation
        int[] h1 = {1,3,5};
        int[] h2 = {2,4,6};
        System.out.println(Arrays.toString(interleave(h1,h2)));

        int[] b = {1,2,3,8,9,10};
        System.out.println(Arrays.toString(perfectShuffle(b)));

        System.out.println(Integer.toString(shuffleNumber(52)));
    }
}
