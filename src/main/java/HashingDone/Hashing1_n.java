package HashingDone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Hashing1_n {
    public static void main(String[] args) {
//        int arr [] = {1,2,3,5,6,7,8 ,8,9};
        int nums [] = {2, 7, 11, 15};
        int target = 9 ;
//        System.out.println(ContainsDuplicate(arr));
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    public static boolean ContainsDuplicate(int [] arr){
        HashSet<Integer> seen = new HashSet<>();
        for (int n : arr){
            if(seen.contains(n)){
                return true ;
            }
            seen.add(n);
        }
        return false;
    }

    public static int[] twoSum(int [] nums , int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int compliment =  target - current ;
            if (map.containsKey(compliment)){
                return new int []{map.get(compliment) , i};
            }
            map.put(current,i);
        }
        return new int[] {};
    }


}
