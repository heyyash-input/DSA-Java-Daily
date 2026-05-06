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
    /**
     * LOGIC: SUM OF FIRST N NATURAL NUMBERS
     * Pattern: Accumulative Recursion
     * Tree for n=3:
     *   f(3)
     *    ↳ 3 + f(2)
     *           ↳ 2 + f(1)
     *                  ↳ 1 (Base Case)
     * Total: 3 + 2 + 1 = 6
     */
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
    /**
     * LOGIC: ASCENDING NUMBERS (1 to N)
     * Pattern: Head Recursion
     * Why it prints 1 to 10: The 'print' statement is waiting in the stack.
     * It only executes AFTER the recursive call returns (during Stack Unwinding).
     * Trace: Call(3) -> Call(2) -> Call(1) -> Print(1) -> Print(2) -> Print(3)
     */
    public static void ascendNum(int n){
        if( n==1 ){
            System.out.println(n);
            return ;
        }

        ascendNum(n-1);
        System.out.println(n);
    }

//-----------------------------------------------------------------------------------------------------------
    /**
     * LOGIC: DESCENDING NUMBERS (N to 1)
     * Pattern: Tail Recursion
     * Why it prints 10 to 1: The 'print' happens BEFORE the next recursive call.
     * Trace: Print(3) -> Call(2) -> Print(2) -> Call(1) -> Print(1)
     */
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
    /**
     * LOGIC: FACTORIAL (n!)
     * Tree for n=4:
     *   fact(4) = 4 * fact(3)
     *                  ↳ 3 * fact(2)
     *                         ↳ 2 * fact(1)
     *                                ↳ 1 * fact(0)
     *                                       ↳ 1 (Base Case)
     */
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
    /**
     * LOGIC: FIBONACCI SERIES
     * Pattern: Tree Recursion (Binary Tree)
     *
     *
     * Tree for n=3:
     *            f(3)
     *           /    \
     *        f(2)    f(1) -> returns 1
     *       /    \
     *    f(1)    f(0)
     *     ↳ 1     ↳ 0
     * Result: (1+0) + 1 = 2
     */
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