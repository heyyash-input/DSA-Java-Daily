package DP_basics.Fundamentals.Knapsack_Types;

public class Knapsack_Fund {

    /// Knapsack:-
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

    public static void main(String args[]) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapsackRec(val , wt , W , val.length)); //output:-  75

    }
}
