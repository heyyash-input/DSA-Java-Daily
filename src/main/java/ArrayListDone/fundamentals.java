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

    }

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
}
