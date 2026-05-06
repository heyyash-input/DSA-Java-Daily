package RecursionDone;

public class Recursion1_n {
    public static void main(String[] args) {
        int n = 10;
//        descendingNum(n);
//        System.out.println(fact(n));
//        ascendNum(n);
//        System.out.println(firstNatural(5));
        System.out.println(fibo(n));

    }

//-----------------------------------------------------------------------------------------------------------

    public static int firstNatural(int n){
        if(n == 1){
            return 1 ;
        }
//        int fnm = firstNatural(n-1);
//        int fn = n + fnm ;
//        return fn  ;
        return n + firstNatural(n-1);
    }

//-----------------------------------------------------------------------------------------------------------

    public static void ascendNum(int n){
        if( n==1 ){
            System.out.println(n);
            return ;
        }

        ascendNum(n-1);
        System.out.println(n);
    }

//-----------------------------------------------------------------------------------------------------------

    public static int descendingNum(int n){
        if( n == 1){
            // important for printing 1
            System.out.println(n);
            return -1 ;
        }
        System.out.println(n+" ");
        return descendingNum(n-1);
    }

//-------------------------------------------------------------------------------------------------------------

    public static int fact (int n ){
        if(n == 0 ){
            return 1 ;
        }
//        int fnm1 = fact(n-1);
//        int fn = n * fact(n-1);
//        return n ;
        // i did direct method:-
        return n * fact(n-1);
    }

//--------------------------------------------------------------------------------------------------------------

    public static int fibo (int n){
        if( n == 0 ||  n == 1){
            return n;
        }
//        int fnm1  = fibo(n-1) ;
//        int fnm2 = fibo(n-2);
//        int fn = fnm1 + fnm2 ;
//        return fn ;
        return fibo(n-1) + fibo(n-2);
    }

//--------------------------------------------------------------------------------------------------------------


}
