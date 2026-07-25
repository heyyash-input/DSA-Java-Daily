package SlidingWindowDone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SlidingWindow1_n {
    public static void main(String[] args) {
//        int arr[] = {3,4,5,6,6,9,10};
//        int k = 1 ;
//        String s  = "abciiidef";
        String s  =  "ADOBECODEBANC", t = "ABC" ;
//        System.out.println(TemplateSlidingWindow(arr,k));
//        System.out.println(MaxVowelsWindow(s,k));
//        System.out.println(MinimumSub(arr,k));
//        System.out.println(sumGreater10(arr,k));
//        System.out.println(SubarrayVariableSmallest(arr,k));
        System.out.println(MinimumWindowSubstring(s,t));
    }

//----------------------------------------------------------------------------------------------------------------

//    Practice these by hard always asked in interview
    public static int TemplateSlidingWindow(int [] arr,int k){
        int i = 0 ;
        int windowsum = 0;
        int maxSum = 0 ;
        for (int j = 0; j < arr.length; j++) {
//            expansion Phase:-
            windowsum += arr[j];
            if(j>=k-1){
                maxSum = Math.max(maxSum,windowsum);
//            Shrinking Phase:-
               windowsum -= arr[i];
               i++;
            }
        }
        return maxSum;
    }

//---------------------------------------------------------------------------------------------------------------

    public static int MaxVowelsWindow(String s , int k){
        int i = 0 ;
        int maxsum = 0;
        int count = 0 ;
        for (int j = 0; j < s.length(); j++) {
            char curr = s.charAt(j);
            if("aeiou".indexOf(curr)!=-1){
                count++;
            }
            if (j>=k-1){
                maxsum = Math.max(maxsum,count);
                char outgoing = s.charAt(i);
                if("aeiou".indexOf(outgoing)!=-1){
                   count--;
                }
                i++;
            }
        }
        return maxsum ;
    }

//---------------------------------------------------------------------------------------------------------------

    public static int MaximunSub(int [] arr , int k){
        int i = 0 ;
        int window = 0 ;
        int  maxSum = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            window+=arr[j];
            if (i-j+1 == k){
                 maxSum = Math.max(maxSum,window);
                 window-=arr[i];
                 i++ ;
            }
        }
        return maxSum ;
    }

//--------------------------------------------------------------------------------------------------------------

    public static  int MinimumSub(int [] arr , int k){
        int minSum = Integer.MAX_VALUE ;
        int i = 0 ;
        int window = 0 ;
        for (int j = 0; j < arr.length; j++) {
            window+=arr[j];
            if(j-i+1 == k){
                minSum = Math.min(minSum,window);
                window-=arr[i];
                i++;
            }
        }
        return minSum;
    }

//--------------------------------------------------------------------------------------------------------------

    public static int sumGreater10(int [] arr , int k){
        int i = 0 ;
        int window = 0 ;
        int sum = 0 ;
        int count = 0 ;
        for (int j = 0; j < arr.length; j++) {
            window+=arr[j];

            if (j-i+1==k){
                if (window > 10){
                    count ++ ;
                }
                sum = Math.max(sum,window);
                window-=arr[i];
                i++;
            }
        }
        return sum;
    }

//---------------------------------------------------------------------------------------------------------------

//    VVVIMP
//    Variable subarray
//    This was also asked in interview personally recommend you
    public static int SubarrayVariableSmallest(int[] arr,int k ){
        int i = 0 ;
        int minLength = Integer.MAX_VALUE ;
        int curr = 0 ;
        for (int j = 0; j < arr.length; j++) {
            curr += arr[j];
            while (curr >= k){
                minLength = Math.min(minLength,j-i+1);
                curr-=arr[i];
                i++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0 ;
        }
        return minLength;
    }

//-------------------------------------------------------------------------------------------------------------

    public static int LargestWindow(int [] arr , int k){
        if (arr == null || arr.length == 0) return 0;
        int i=0;
        int maxlength = Integer.MIN_VALUE;
        int curr =0;
        for (int j = 0; j < arr.length; j++) {
            curr+=arr[j];
            while (curr>k){
                curr-=arr[i];
                i++;
            }
            // 3. Record AFTER the while loop.
            // At this point, we are GUARANTEED the window is legal (sum <= k).
            maxlength = Math.max(maxlength, j - i + 1);
        }
        return maxlength ;
    }

//---------------------------------------------------------------------------------------------------------------

    // Count Ocurrance of Anagrams
    public static int CountOccurance(String pat , String txt){
        int k = pat.length();
        int n = txt.length();
        // Edge case: if pattern is longer than text, no anagram can exist
        if (k > n) return 0;
        // Frequency arrays to store character counts (26 for 'a'-'z')
        int patCount[] = new int[26];
        int txtCount[] = new int[26];
        int result = 0;
        // STAGE 1: The Warm-up
        // Fill the target pattern counts and the first window of the text
        for (int i = 0; i < k; i++) {
            patCount[pat.charAt(i) - 'a']++;
            txtCount[txt.charAt(i) - 'a']++;
        }
        // STAGE 2: The Sliding Window
        // Start from index 'k' (the first character after the initial window)
        for (int i = k; i < n; i++) {
            // Step A: Check if current state is an anagram
            if (Arrays.equals(patCount, txtCount)) {
                result++;
            }
            // Step B: Update the window (One-In, One-Out)
            // 1. Add the "Newcomer" at the right edge
            txtCount[txt.charAt(i) - 'a']++;

            // 2. Remove the "Departing" character at the left edge (i - k)
            txtCount[txt.charAt(i - k) - 'a']--;
        }
        // STAGE 3: Final Check
        // The loop finishes before checking the very last window position
        if (Arrays.equals(patCount, txtCount)) {
            result++;
        }
        return result;
    }

//-----------------------------------------------------------------------------------------------------------------

// VVIMPP:- Interview Related:- (Pattern Sliding window (variable size + marking)):-
    public static String  MinimumWindowSubstring(String s , String t){
      int countS [] =  new int [128];
      int countT [] = new int  [128];
      int i = 0 ;
      int n = s.length();
      int k = t.length();
      int minlength = Integer.MAX_VALUE;
      int have = 0;
      int need = 0 ;
        int start = 0 ;
        // STEP 1: Fill requirements
        for (char c : t.toCharArray()) {
            if (countT[c] == 0) need++;
            countT[c]++;
        }

      for(int j=0 ; j<n ; j++){
         char expand = s.charAt(j);
         countS[expand]++ ;

        if (countT[expand] > 0 &&  countS[expand] == countT[expand]){
            have++;
          }
        while(have == need){
            if (j-i+1 < minlength){
                minlength = j-i+1;
                start =  i ;
            }
             char shrink = s.charAt(i);
             if (countT[shrink] >0 && countS[shrink] == countT[shrink]){
                 have--;
             }
             countS[shrink]--;
             i++;
        }
      }
      return minlength == Integer.MAX_VALUE? "":s.substring(start,start+minlength) ;
    }

//----------------------------------------------------------------------------------------------------------------

    public static int LongestSubstringWithoutRepeatingCharacter(String s){
        int maxLength = Integer.MIN_VALUE;
        int i = 0 ;
        int count []= new int [128];
        for (int j = 0; j <s.length() ; j++) {
            char curr = s.charAt(j);
            count[curr]++; // expand
            while (count[curr] > 1){
                    char shrink = s.charAt(i);
                    maxLength =  Math.max(maxLength,j-i+1);
                    count[shrink]-- ; // shrink from back
                    i++;
            }
        }
        return maxLength;
    }

//---------------------------------------------------------------------------------------------------------------

//    Majority elements Questions:-
//    n/3:-
///    for any n/k majority add more k+1  and counts , Boyr Moore Voting thoerm:-
    public static List<Integer> majorityElement(int [] nums){
        List<Integer> result = new ArrayList<>() ;
        int cand1 = Integer.MIN_VALUE , c1 = 0 ;
        int cand2 = Integer.MAX_VALUE , c2 = 0 ;
        int n = nums.length;
//        The Game:-
        for (int i = 0; i < n; i++) {
            if(nums[i] == cand1){
                c1++;
            } else if (nums[i] == cand2) {
                c2++;
            } else if (c1 == 0) {
                cand1 = nums[i];
                c1 = 1 ;
            } else if (c2 == 0) {
                cand2 = nums[i];
                c2 = 1 ;
            }else{
                c1--;
                c2--;
            }
        }
//        Audit Level:-
        c1=0 ; c2 =0 ;
        for (int i = 0; i < n; i++) {
            if(cand1 == nums[i]){
                c1++;
            } else if (cand2 == nums[i]) {
                c2++;
            }
        }
        if (cand1>n/2) result.add(cand1);
        if (cand2>n/2) result.add(cand2);
        return result ;
    }

//--------------------------------------------------------------------------------------------------------------

//    Famous Sum questions:-
    public static List<List<Integer>> threeSum(int [] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            int j = i+1 ;
            int k = nums.length-1 ;
            while (j < k){
                int sum = nums[i] + nums [j] + nums [k];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[j] , nums[k]));
                    j++;
                    k--;
                } else if (sum <0) {
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}

//--------------------------------------------------------------------------------------------------------------
