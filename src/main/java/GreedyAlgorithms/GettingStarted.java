package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GettingStarted {
// Activty Seq problem :-
//--------------------------------------------------------------------------------------------------------------
    //below is a code for unsorted arrays:-

    public static void twoDSorting(int activities [] [] ,){
        int maxAct=0;
        ArrayList<Integer> list =  new ArrayList<>();

        maxAct = 1;
        list.add();
        maxAct=1;
    }

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
        int maxAct = 0 ;
        ArrayList<Integer> ans = new ArrayList<>();
//         1st selection:-
        maxAct = 1 ;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if(start[i] >= lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Maximum Activity:" + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
