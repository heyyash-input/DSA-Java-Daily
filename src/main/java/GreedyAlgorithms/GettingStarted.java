package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GettingStarted {
// Activty Seq problem :-
//--------------------------------------------------------------------------------------------------------------
    //below is a code for unsorted arrays:-

    public static void main(String[] args) {

        int start [] = {1 ,3 ,0 ,5 ,8 ,5};
        int end [] = { 2 ,4 ,6 ,7 ,9 ,9};
//--------------------------------------------------------------------------------------------------------------
        //What if arrays are not sorted then we use below sorting mechanism:-
        int activities [][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i ;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
//     Comparator makes sure the sorting sequence of index
        //o -> o[2] (The Lambda Expression)
        //This is the "Key Extractor."
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));;
//---------------------------------------------------------------------------------------------------------------
        //bellow is a code for sorted arrays :-
//        End time basis sorting:-
        //code for 2D:-
        int maxAct = 0 ;
        ArrayList<Integer> ans = new ArrayList<>();
//         1st selection:-
        maxAct = 1 ;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if(activities[i][1] >= lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

//------------------------------------------------------------------------------------------------------------

//        int maxAct = 0 ;
//        ArrayList<Integer> ans = new ArrayList<>();
////         1st selection:-
//        maxAct = 1 ;
//        ans.add(0);
//        int lastEnd = end[0];
//        for (int i = 1; i < end.length; i++) {
//            if(start[i] >= lastEnd){
//                maxAct++;
//                ans.add(i);
//                lastEnd = end[i];
//            }
//        }
        System.out.println("Maximum Activity:" + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();

//-----------------------------------------------------------------------------------------------------------
        //Knapsack Problem:- variables
        int val [] = {60 , 100 , 120 } ;
        int weight [] = {10 , 20 , 30 };
        int W = 50;

        double ratio [][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio [i][0] = i;
            ratio [i][1] = val[i]/(double) weight[i];

            /*
             * Ratio Table Logic:
             * [idx] | [val] | [W] | [ratio]
             * ------------------------------
             * 0   |  60   |  10  |   6.0
             * 1   |  100  |  20  |   5.0
             * 2   |  120  |  30  |   4.0
             */
        }
//        ascending order sorting :-
        Arrays.sort(ratio , Comparator.comparingDouble(o -> o [1]));

        int capacity = W ;
        int finalVal = 0 ;
        for (int i = ratio.length - 1 ; i >= 0 ; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]){
                finalVal += val[idx];
                capacity -= weight[idx];
            }else{
                //include fractional item:-
                finalVal += (ratio[i][1] * capacity);
                capacity = 0 ;
                break;
            }
        }
        System.out.println("Final Value:- " + finalVal);

//-------------------------------------------------------------------------------------------------------------
        // Minimum Absolute Diff:-

        int A [] = {1 , 2 , 3};
        int B [] = {2 , 1, 3 };

        Arrays.sort(A);
        Arrays.sort(B);

        int minAbsDiff = 0 ;
        for (int i = 0; i < A.length; i++) {
            minAbsDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Minimum Absolute Diff:- " + minAbsDiff);
    }

//-------------------------------------------------------------------------------------------------------------



}
