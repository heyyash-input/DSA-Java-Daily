package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    /*
     * THE "CHOCOLA" FUNDAMENTAL:
     * --------------------------
     * 1. Why sort Descending?
     *    Expensive cuts should be made first when the number of pieces (hp, vp) is small.
     *
     * 2. Why hp=1, vp=1?
     *    You start with a single whole block of chocolate.
     *
     * 3. The Multiplier Logic:
     *    - A Horizontal cut splits all currently existing Vertical pieces.
     *    - A Vertical cut splits all currently existing Horizontal pieces.
     *
     * TIME COMPLEXITY: O(N log N + M log M) due to sorting.
     * SPACE COMPLEXITY: O(1) (auxiliary).
     */
        public static void main(String[] args) {
            int n=4 , m = 6 ;
            Integer costVer[] = {2 ,1 ,3 ,1 , 4};//m-11
            Integer costHor[] = { 4 ,1 ,2};//n-1

            Arrays.sort(costVer, Collections.reverseOrder());
            Arrays.sort(costHor,Collections.reverseOrder());

            int h =0 , v = 0 ; // horizontal and vertical
            int hp =1 , vp =1; // vertical and horizontal pieces
            int cost = 0 ;
            while( h < costHor.length && v < costVer.length){
                //vertical cost < horizontal cost
                if(costVer[v] <= costHor[h]){
                    // horizontal cut
                    cost += (costHor[h] * vp);
                    hp++;
                    h++;
                }else{
                    // vertical cut
                    cost += (costVer[v] * hp);
                    vp++;
                    v++;
                }
            }
            while(h < costHor.length ){
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
            while(v < costVer.length ){
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
            System.out.println("minimum cost of cuts= " + cost);
        }    
}
