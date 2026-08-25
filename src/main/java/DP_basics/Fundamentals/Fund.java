package DP_basics.Fundamentals;

public class Fund {
//--------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        int n =5 ;
        int f [] = new int [n+1]; // 0,0,0,0 :

        /// Fibonacci:
        System.out.println(fibonacci(n,f));

        /// Fibonacci using memoization:
        System.out.println(fiboTab(n));

        /// Climb stairs using tabulation:
        System.out.println(climbStairs(5));
    }
//--------------------------------------------------------------------------------------------------------------------------------
    /// Memooization:-
    public static int fibonacci(int n , int f []){
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){ // already calculated:
            return f[n];
        }
        f[n] = fibonacci(n-1 , f) + fibonacci(n-2 , f );
        return f[n];
    }
//--------------------------------------------------------------------------------------------------------------------------------

    /// Tabulation:-
    public static int fiboTab(int n ){
        int dp [] = new int[n+1];
        dp[0] = 0 ;
        dp[1] = 1 ;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

//--------------------------------------------------------------------------------------------------------------------------------

    /// Climbing stairs:
    public static int climbStairs(int n){

        int dp[] = new int [n+1];
        dp[0] = 1 ;
        dp[1] = 1 ;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
//--------------------------------------------------------------------------------------------------------------------------------
}
