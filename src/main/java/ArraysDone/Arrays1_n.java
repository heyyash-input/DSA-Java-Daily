package ArraysDone;

import org.apache.tools.ant.types.resources.comparators.Reverse;

import java.util.Arrays;
import java.util.HashMap;

public class Arrays1_n {
    public static void main(String[] args) {
//        int [] arr = {1, 2 ,4 ,8 ,16 ,50 ,75 ,95 ,103};
//        int arr[] = {1, 2, 8, 0, 78, 0, 89};
//        int arr[] = {1,1,0,1,1,1};
//        System.out.println(FindLarget(arr));
//        System.out.println(FindSecondLargest(arr));
//        System.out.println(ExceptionsSecondLargest(arr));
//        System.out.println(MoveZeroToEnd(arr));
//        System.out.println(maxConsecutiveOnes(arr));
        int[] nums = {2, 0, 2, 1, 1, 0};
        int [] arr = {-1 , 2 , -6 , 8 ,-9};
//        DutchNationalFlagAlgo(nums);
//        System.out.println(Arrays.toString(nums));
        System.out.println(MaximumSubarray(arr));

    }

//    public static void Swap(int[] nums , int start , int end){
//                int temp = nums[start];
//                nums[start] = nums[end];
//                nums[end] = temp;
//    }
    public static int FindLarget(int[] arr){
        //Return -1 if array is Empty
        if(arr == null || arr.length == 0 ) return -1;
        //Assume the first number is the max
        int maxVal = arr[0];
        //Create a loop to look at the rest
        for (int i = 1; i < arr.length; i++) {
            //Compare current number with our stored number
            if(arr[i] > maxVal){
                //Update the max number
                maxVal = arr[i] ;
            }
        }
        // return the max value
        return maxVal ;
    }

    public static int FindSecondLargest(int[]arr){
        if(arr == null || arr.length == 0) return 0 ;
        int gold = Integer.MIN_VALUE;
        int silver = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > gold){
                silver = gold ;
                gold = arr[i];
            }else if(arr[i] > silver && arr[i]!=gold) {
                    silver = arr[i];
            }
        }
        return (silver ==Integer.MIN_VALUE) ? -1 : silver ;
    }

    public static int ExceptionsSecondLargest(int[]arr){
        if (arr == null || arr.length==0) {
            throw new IllegalArgumentException("Array must be more than 2 values");
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > first){
                second = first ;
                first = arr[i] ;
            } else if (arr[i] > second && arr[i] != first ) {
                second = arr[i];
            }
        }
        if(second == Integer.MIN_VALUE){
            throw new IllegalArgumentException("No distinct second largest number found");
        }
        return second ;
    }

    public static int MoveZeroToEnd(int[] arr){
        int  write = 0 ;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[write] = arr[i];
                write ++ ;
            }
        }
        int CountZero = write ;
        while (write < arr.length){
            arr[write] = 0 ;
            write ++ ;
        }
        return CountZero;
    }
    public static void Rotate(int[] arr,int k){
        int n=arr.length;
         k = k%n ;
        Reverse(arr,0,n-1);
       Reverse(arr,0,k-1);
       Reverse(arr,k,n-1);

    }
    public static void Reverse(int[]arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int maxConsecutiveOnes(int [] arr ){
        int count = 0 ;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                count++;
            }else {
                count = 0;
            }
            maxLength = Math.max(maxLength,count);
        }
        return maxLength;
    }
// For negative and positve integers we can't use sliding window we need prefix + hashing
    public static int LogenstSubarraySumK(int []arr , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int currSum = 0 ;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            int target = currSum - k;
            if(map.containsKey(target)){
                int len = i - map.get(target);
                maxLength = Math.max(maxLength,len);
            }
            if(!map.containsKey(currSum)){
                map.put(currSum,i);
            }
        }
        return maxLength ;
    }

    public static int[] DutchNationalFlagAlgo(int [] nums){
        int low = 0 ;
        int mid = 0 ;
        int high = nums.length-1 ;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums,low,mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
        return nums;
    }

    public static void swap(int[] nums , int start , int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp ;
    }
//     kadane's algorithm VVIMP:-w  
    public static int MaximumSubarray(int [] arr){
        int maxSum = 0 ;
        int curr = 0 ;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if (curr > maxSum){
                maxSum = curr ;
            }
            if(curr <0){
                curr = 0 ;
            }
        }
        return maxSum;
    }

    public static void reverse(int [] arr , int start , int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++ ;
            end --;
        }
    }
    public static void NextPermutation(int[] nums){

        if (nums == null || nums.length == 0) ;
        int index =0 ;
        int n = nums.length ;

        for (int i = n-1; i > 0 ; i--) {
            if (nums[i-1] < nums[i]){
                index = i-1 ;
                break ;
            }
        }
//        Outer loop for checking just greater element in array
        if(index!= -1){
            for (int i = n-1; i > index; i--) {
//                as we are checking for greater so check Index for i greater element
                if(nums[i] > nums[index]){
                    swap(nums,i , index);
                }
            }
        }
        reverse(nums , index+1 , n-1);
    }
    
}
