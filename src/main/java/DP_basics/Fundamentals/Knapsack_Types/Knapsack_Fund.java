package DP_basics.Fundamentals.Knapsack_Types;

public class Knapsack_Fund {
//------------------------------------------------------------------------------------------------------------------------------

    ///Knapsack:-
    public static int knapsackRec(int val[] , int wt[] , int W , int i ) {
        //Carry parameters
        // base condition:
        if(W == 0 || i == 0){
            return 0 ;
        }
        // check the condition first:
        if(wt[i-1] <= W){
            //include:
            // M1:- add profit also
           int ans1 = val[i-1] + knapsackRec(val , wt , W-wt[i-1] , i-1 );
            //exclude:
           int ans2 =  knapsackRec(val , wt , W , i-1);
            return Math.max(ans1 , ans2);
        }else{
            return knapsackRec(val , wt , W , i-1);
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------

    ///knapsack memo:-
    public static int knapsackMemo(int val[] , int wt[] , int W , int i , int dp [][] ) {
        // base condition:
        if(W == 0 || i == 0){
            return 0 ;
        }
        // lets check for every grid if we have calculated or not:
        if(dp[i][W] != -1){
            return dp[i][W];
        }

        // check the condition first:
        if(wt[i-1] <= W){
            //include:
            // M1:- add profit also
            int ans1 = val[i-1] + knapsackMemo(val , wt , W-wt[i-1] , i-1 , dp);
            //exclude:
            int ans2 =  knapsackMemo(val , wt , W , i-1 , dp);

            dp[i][W] = Math.max(ans1 , ans2);
            return dp[i][W];

        }else{
            dp[i][W] = knapsackMemo(val , wt , W , i-1 , dp);
            return dp[i][W];
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------

    public static void main(String args[]) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        /// Knapsack using recursion:-
        System.out.println(knapsackRec(val , wt , W , val.length)); //output:-  75

        /// For memoization initate 2D matrix grid with -1:-
        int dp[] [] = new int [val.length+1][W+1];
        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // M2:- no using 'j' initiating values in 'W' instead:
                dp[i][j] = -1 ;
            }
        }

        /// Knapsack with DP using Memoization table:-
        System.out.println(knapsackMemo(val,wt , W , val.length, dp));
    }

//------------------------------------------------------------------------------------------------------------------------------
}
