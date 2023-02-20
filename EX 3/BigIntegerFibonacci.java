import java.math.*;

public class BigIntegerFibonacci {

        // TODO: Implementation
    	static int fibi1count =0;
        static int fibi2count =0;
        public static BigInteger fib1(int n){

            fibi1count++;
            if(n==0 || n==1)
            {
                return BigInteger.valueOf(1);
            }else
            {
                return fib1(n-1).add(fib1(n-2));
            }

    }
/*****************************************************************************************************************
  
                                                Part 2.   
   
Recursion Tree is like a method for solving the recurrence relations.
A recursion tree is a tree where each node represents the cost of a certain recursive sub-problem. 
We sum up the values in each node to get the cost of the entire algorithm.

*****************************************************************************************************************/
    public static BigInteger fib2(int n){
        // TODO: Implementation
        int result =0;
        int num1= 1;
        int num2= 2;
        if(n==1)
        {
            result=1;
        }
        else if(n==2)
        {
            result=2;
        }
        for(int i=0;i<n-2;i++)
        {

            fibi2count++;
            result = num1 + num2;
            num1=num2;
            num2=result;
        }

        return BigInteger.valueOf(result);


    }
    public static void main(String[] args) {
        // TODO: Include test scenarios
    	 System.out.println(fib1(23));
         System.out.println(fib2(23));
         System.out.println(fibi1count);
         System.out.println(fibi2count);

    }

}

/********************************************************************************************************************

MEMBERS OF THE SAME GROUP (We did some of the work together)

Chiedozie Okolo    

Minh Hoang


**************************************************************************************************************************/