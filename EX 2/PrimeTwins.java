import java.util.Arrays;

public class PrimeTwins {

  public static int[][] primeTwins(int number) {
    // TODO: implementation
	  int p =0;
      int q = 0;
      int[][] twins = new int[number][2];

      int temp = 2;


      for(int i=0;i<number;i++)
      {

         do
              {
                  p= nextPrime(temp);
                  q = p + 2;
                  temp = p;


              } while(  ! (  isPrime(q) ) );
          twins[i][0] = p;
          twins[i][1] = q;

      }



      return twins;
	  
  }

  public static int[][] primeTriplets(int number) {
    // TODO: implementation
	  int p = 0;
      int q = 0;
      int r = 0;

      int pTemp = 0;
      int qTemp = 0;
      int rTemp = 0;

      int[][] triplets = new int[number][3];

      int fPrime = 2;
      int fPrime2 = 2;


      for(int i=0;i<number;i++)
      {
          do
          {
              p= nextPrime(fPrime);
              q= p + 2;
              r= p + 6;
              fPrime = p;

          }while( !(isPrime(q) && isPrime(r) ));


          do
          {


              pTemp= nextPrime(fPrime2);
              qTemp= pTemp + 4;
              rTemp= pTemp + 6;
              fPrime2 = pTemp;

          }while( !(isPrime(qTemp) && isPrime(rTemp) ));

          if(pTemp<p)
          {
              p= pTemp;
              q= qTemp;
              r= rTemp;
              fPrime=pTemp;
          }
          if(p<pTemp)
          {
              fPrime2=p;

          }

          triplets[i][0] = p;
          triplets[i][1] = q;
          triplets[i][2] = r;
      }

          return triplets;

  }

  public static void main(String[] args) {
    // TODO: include tests here

      int[][] twins = primeTwins(10);
      for(int i=0;i<twins.length;i++)
      {
          System.out.println(Arrays.toString(twins[i]));
      }



      System.out.println("------------------");

      int[][] triplets = primeTriplets(10);
      for(int i=0;i<twins.length;i++)
      {
          System.out.println(Arrays.toString(triplets[i]));
      }

  }

  public static boolean isPrime(int n)
  {
      if(n > 1)
      {
          for(int i =2;i<n;i++)
          {
              if(n%i==0)
              {
                  return false;
              }
          }
      }else
      {return false;}

      return true;

  }

  public static int nextPrime(int n)
  {

      for (int i=n+1; i<Integer.MAX_VALUE; i++)
          {
              if(isPrime(i))
              {
                  return i;
              }
          }

      return 0;
  }
}
