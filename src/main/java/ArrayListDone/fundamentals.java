package ArrayListDone;

import java.util.ArrayList;

public class fundamentals {

    public static void main(String[] args) {
        //Declaration:-
        // Java Collection framework part:-
//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<String> list1 =new ArrayList<>();
//        ArrayList<Boolean> list2 = new ArrayList<>();
//        //operations:-
//
//        // ADD O (1)
//        list.add(2);
//        list.add(5);
//        list.add(9);
//        list.add(6);
//        list.add(8);
//        System.out.println(list);

        //GET O (1)
//        list.get(1); // pass the index value

        //Remove O (n) :-we will search then remove
//        list.remove(3);

        //Set O (n) - find and then change
//        list.set(1,10);

        //Contains element  O(n)
//        list.contains(3);

        //List size
//        list.size();

//---------------------------------------------------------------------------------------------------------------
        //Print reverse of arrayList
//        for (int i = list.size()-1; i >= 0 ; i--) {
//            System.out.print(list.get(i)+" ");
//        }
//        System.out.println();

//---------------------------------------------------------------------------------------------------------------

        //Find maximum:-
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < list.size(); i++) {
//           if (  max < list.get(i) ){
//               max = list.get(i);
//           }
//        }
//        System.out.println("max element " + max);

// --------------------------------------------------------------------------------------------------------------

        //Container with most water:
        // Example 1 array from LeetCode
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // Call the two-pointer method and capture the result
        int result = containerWithMostWater(heights);

        System.out.println("Maximum water container can store: " + result);
        // Expected Output: 49

//-------------------------------------------------------------------------------------------------------------

        ///Pair sum:-
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        int target = 5 ;
//        System.out.println(pairSum1(list, target));

//----------------------------------------------------------------------------------------------------------------

        ///Pair sum 2 :-
        ArrayList<Integer> list = new ArrayList<>();
        // [11 , 15 , 6 , 8 , 9 , 10 ] --> Roted and sorted
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16 ;
        System.out.println(pairSum2(list, target));

    }
//---------------------------------------------------------------------------------------------------------------

    /// Container with most water:-
    public static int containerWithMostWater(int height []) {

        int maxArea =0 ;
        int left =0  , right = height.length - 1 ;

        while (left < right){

            int heightCurr = Math.min(height[left] , height[right]);

            int width = right - left ;

            int areaCurr = heightCurr * width ;

            maxArea = Math.max(maxArea , areaCurr);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

//--------------------------------------------------------------------------------------------------------------
   /// brute force:-
//    public static boolean pairSum1(ArrayList<Integer> list , int target){
//
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i+1; j < list.size(); j++) {
//                if(list.get(i) + list.get(j) == target){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    ///TwoPointer:
    public static boolean pairSum1(ArrayList<Integer> list , int target){
        int left = 0 , right = list.size()-1;
        while(left < right){
            //case 1:
            if(list.get(left) + list.get(right) == target){
                return true ;
            }

            //case 2:
             if (list.get(left) + list.get(right) < target ) {
                left++;
            }
             //case 3:
                else{
                right -- ;
            }

        }
        return false;
    }

//--------------------------------------------------------------------------------------------------------------


    /// pair sum 2 :-
    public static boolean pairSum2(ArrayList<Integer> list , int target){

        //breaking point pivot:-
        int bp = -1 ;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i+1)) {
                //breaking point we got
                bp = i ;
                break;
            }
        }

        int left = bp + 1 ; // smallest
        int right = bp ; // largest

        while (left != right) {

            if (list.get(left) + list.get(right) == target) {
                return true;
            }

            //Important pointer technique BS involved:-
            if (list.get(left) + list.get(right) < target) {
                left = (left + 1) % n;
            } else {
                right = (n + right - 1) % n;
            }
        }
        return false;
    }
//---------------------------------------------------------------------------------------------------------------


}
