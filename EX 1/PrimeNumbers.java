


public class PrimeNumbers {

    public static boolean isPrime(int n) {
        //TODO: implementation

        if (n <= 1) {
            return false;
        } else if(n==2)
            return true;

        for (int i = 2; i <= n/2; ++i) {

            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }

    public static int nextPrime(int n) {
        //TODO: implementation


        int p = n;

        if(isPrime(n)) {

            return n;
        } else {

            while(!isPrime(p)) ++p;

            return p;
        }

    }

    public static void main(String[] args) {
        // TODO: test your implementation!

        int n = 14;
        if (isPrime(n))
            System.out.println("The number " + n + " is a prime number");
        else {
            //System.out.println("The number " + n +" is not a prime number");
            System.out.println("The next Prime number is " + nextPrime(n));
        }

    }

}