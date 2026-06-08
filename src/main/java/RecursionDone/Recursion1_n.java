package RecursionDone;

import java.util.ArrayList;
import java.util.List;

// Revised all the edge cases and logic:-

public class Recursion1_n {
    public static void main(String[] args) {
        // revised all questions weekly
//        int n = 10;
//        descendingNum(n);
//        System.out.println(fact(n));
//        ascendNum(n);
//        System.out.println(firstNatural(5));
//        System.out.println(fibo(n));
//        int arr [] = {1 , 2, 3 ,4  };
//        System.out.println(isSorted(arr,0));
//        int arr [] = {8,3,6,9,5,10,2 ,5 ,3 ,9};
//        System.out.println(firstOcc(arr,5,0));
//        System.out.println(lastOcc(arr,5,0));
//        System.out.println(powExp(2,10));
//        System.out.println(optPow(2,5));
//        System.out.println(tilingProb(3));
//        String str = "appnacollege";
//        removeDuplicates(str , 0 , new StringBuilder() , new boolean [26]);
//        System.out.println(friendsPair(3));
//            printBinaryString(3,0,new StringBuilder(""));
            subset("abc","",0);
    }

//-----------------------------------------------------------------------------------------------------------
    /**
     * LOGIC: SUM OF FIRST N NATURAL NUMBERS
     * Pattern: Accumulative Recursion
     * Tree for n=3:
     *   f(3)
     *    ↳ 3 + f(2)
     *           ↳ 2 + f(1)
     *                  ↳ 1 (Base Case)
     * Total: 3 + 2 + 1 = 6
     */
    public static int firstNatural(int n){
        if(n == 1){
            return 1 ;
        }
//        int fnm = firstNatural(n-1);
//        int fn = n + fnm ;
//        return fn  ;
        return n + firstNatural(n-1);
    }

//-----------------------------------------------------------------------------------------------------------
    /**
     * LOGIC: ASCENDING NUMBERS (1 to N)
     * Pattern: Head Recursion
     * Why it prints 1 to 10: The 'print' statement is waiting in the stack.
     * It only executes AFTER the recursive call returns (during Stack Unwinding).
     * Trace: Call(3) -> Call(2) -> Call(1) -> Print(1) -> Print(2) -> Print(3)
     */
    public static void ascendNum(int n){
        if( n==1 ){
            System.out.println(n);
            return ;
        }

        ascendNum(n-1);
        System.out.println(n);
    }

//-----------------------------------------------------------------------------------------------------------
    /**
     * LOGIC: DESCENDING NUMBERS (N to 1)
     * Pattern: Tail Recursion
     * Why it prints 10 to 1: The 'print' happens BEFORE the next recursive call.
     * Trace: Print(3) -> Call(2) -> Print(2) -> Call(1) -> Print(1)
     */
    public static int descendingNum(int n){
        if( n == 1){
            // important for printing 1
            System.out.println(n);
            return -1 ;
        }
        System.out.println(n+" ");
        return descendingNum(n-1);
    }

//-------------------------------------------------------------------------------------------------------------
    /**
     * LOGIC: FACTORIAL (n!)
     * Tree for n=4:
     *   fact(4) = 4 * fact(3)
     *                  ↳ 3 * fact(2)
     *                         ↳ 2 * fact(1)
     *                                ↳ 1 * fact(0)
     *                                       ↳ 1 (Base Case)
     */
    public static int fact (int n ){
        if(n == 0 ){
            return 1 ;
        }
//        int fnm1 = fact(n-1);
//        int fn = n * fact(n-1);
//        return n ;
        // i did direct method:-
        return n * fact(n-1);
    }

//--------------------------------------------------------------------------------------------------------------
    /**
     * LOGIC: FIBONACCI SERIES
     * Pattern: Tree Recursion (Binary Tree)
     *
     *
     * Tree for n=3:
     *            f(3)
     *           /    \
     *        f(2)    f(1) -> returns 1
     *       /    \
     *    f(1)    f(0)
     *     ↳ 1     ↳ 0
     * Result: (1+0) + 1 = 2
     */
    public static int fibo (int n){
        if( n == 0 ||  n == 1){
            return n;
        }
//        int fnm1  = fibo(n-1) ;
//        int fnm2 = fibo(n-2);
//        int fn = fnm1 + fnm2 ;
//        return fn ;
        return fibo(n-1) + fibo(n-2);
    }

//--------------------------------------------------------------------------------------------------------------
    // Check is array is sorted or not:-
    public static boolean isSorted(int[] arr , int i){
        if ( i == arr.length-1){
            return true ;
        }
        if(arr[i] > arr [i +1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

//--------------------------------------------------------------------------------------------------------------
    // return first occurance
    public static int firstOcc (int arr [] , int key ,int i ){

        if ( i == arr.length){
            return -1;// means we didn't get andy value as we reached at the last
        }
        if (arr[i] == key ){
            return i;
        }
        return firstOcc(arr,key,i+1); //if not then i++
    }

//-------------------------------------------------------------------------------------------------------------
    /** VVIMPP (BackTrack check)
     * FIND LAST OCCURRENCE (RECURSIVE)
     * --------------------------------
     * This method uses 'Head Recursion' logic to look forward before checking itself.
     *
     * Logic:
     * 1. Go to the end of the array first (Build the Stack).
     * 2. On the way back (Unwinding), the first time we find the key,
     *    that is officially the LAST occurrence in the original array.
     *
     * Time Complexity: O(n) - Every element is visited once.
     * Space Complexity: O(n) - Recursive stack depth equals array length.
     */
    public static int lastOcc(int arr [] , int key , int i){
        if( i == arr.length){
            return -1 ;
        }
        //check forward:-
        int isFound = lastOcc(arr, key, i + 1); // 1. Wait for signal from ahead

        if (isFound != -1) {        // 2. If signal is NOT -1, someone ahead ALREADY found it
            return isFound;         // 3. Just pass their answer back.
        }

        if (arr[i] == key) {        // 4. If signal IS -1, nobody ahead found it.
            return i;               // 5. Check yourself! If you match, YOU are the last occurrence.
        }
        return isFound ;
    }

//-----------------------------------------------------------------------------------------------------------

    public static int powExp (int x , int n ){
        if( n==1 ){
            return x ;
        }
        return x * powExp(x ,n-1);
    }

//-----------------------------------------------------------------------------------------------------------

    public static int optPow(int a , int n ){
        if (n == 0 ){
            return 1 ;
        }
        // but still this is O(n) cause we are calling function two times to make
        // O (log n ) store one call in one variable then make it sqaure
        int halfSq = optPow(a,n/2);
        int halfPow = halfSq * halfSq ;// now internally its calculating faster with variable
        // n is odd
        if(n%2 != 0){
            halfPow = a * halfPow ;
        }
        return halfPow ;
    }

//-------------------------------------------------------------------------------------------------------------
    public static int tilingProb (int n ){ // 2 X n
        if ( n ==0 || n ==1){
            return 1 ;
        }
        //kam
        //vertical
        int verTiles = tilingProb(n-1);

        //horizontal
        int horTiles = tilingProb(n-2);

        int total = verTiles + horTiles ;
        return total;
    }

//---------------------------------------------------------------------------------------------------------------

    public static void removeDuplicates (String str , int idx , StringBuilder sb , boolean map []){
        if(idx == str.length()){
            System.out.println(sb);
            return;
        }
        char ch = str.charAt(idx);
        if(map[ch - 'a'] == true){
            // duplicate hae
            removeDuplicates(str , idx+1 , sb , map );
        }else {
            // not duplicate add it to sb
            map[ch - 'a'] = true;
            removeDuplicates(str, idx+1, sb.append(ch), map);
        }
    }

//-------------------------------------------------------------------------------------------------------------

    public static int friendsPair(int n ){
        if (n == 1 || n == 2){
            return n ;
        }
        return friendsPair(n-1) + friendsPair(n-1) * friendsPair(n-2);
    }

//-------------------------------------------------------------------------------------------------------------

    public static void printBinaryString ( int n , int lastPlace , StringBuilder str){
//        if ( lastPlace == 0){
//            printBinaryString(n-1,0 , str.append("0"));
//            printBinaryString(n-1,1 , str.append("1"));
//        }else{
//            printBinaryString(n-1,0 , str.append("0"));
//        }
        if (n == 0 ){
            System.out.println(str); //Empty also
            return;
        }
        printBinaryString(n-1,0 , str.append("0"));
        if(lastPlace == 0){
            printBinaryString(n-1,1 , str.append("1"));
        }
    }

//--------------------------------------------------------------------------------------------------------------
//
//    Level 0:                             (abc, "", 0)
//                                         /          \
//    Level 1:                  (Include 'a')         (Exclude 'a')
//                              (abc, "a", 1)            (abc, "", 1)
//                                 /        \            /        \
//    Level 2:                (Inc 'b')     (Exc 'b')    (Inc 'b')   (Exc 'b')
//                          (abc, "ab", 2) (abc, "a", 2) (abc, "b", 2) (abc, "", 2)
//                             /      \       /      \      /      \      /      \
//    Level 3:            (Inc 'c')(Exc 'c')(Inc 'c')(Exc 'c')(Inc 'c')(Exc 'c')(Inc 'c')(Exc 'c')
//                           "abc"    "ab"     "ac"     "a"      "bc"     "b"      "c"      ""
//                             |        |        |        |        |        |        |        |
//                        [Print]  [Print]  [Print]  [Print]  [Print]  [Print]  [Print]  [Print]

    public static void subset ( String s  , String ans , int i){
        if ( i == s.length()){
            if(ans.length() == 0 ) {
                System.out.println("{ null }");
                return;
            }else {
                System.out.println(ans);
            }
            return;
        }
        char ch = s.charAt(i);
        // include for first
        subset(s, ans + ch,i+1);
        // dont include
        subset(s,ans,i+1);
    }

//----------------------------------------------------------------------------------------------------------------

    // in arraylist:-
    /**
     * SUBSETS (Power Set)
     * -------------------
     * This implementation uses Backtracking.
     *
     * Key Learning: Unlike Strings, Lists are mutable. We use:
     * 1. current.add(x) to include an element.
     * 2. result.add(new ArrayList<>(current)) to save the state.
     * 3. current.remove(size-1) to backtrack (Undo the choice).
     *
     * Complexity:
     * - Time: O(n * 2^n) - 2^n subsets, each taking O(n) to copy.
     * - Space: O(n) - Maximum depth of the recursion stack.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start recursion with an empty "current" list and index 0
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int i, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // BASE CASE: If we've considered all elements
        if (i == nums.length) {
            // CRITICAL: We must add a NEW copy of 'current'
            result.add(new ArrayList<>(current));
            return;
        }

        // CHOICE 1: Include nums[i]
        current.add(nums[i]);
        generateSubsets(i + 1, nums, current, result);

        // BACKTRACK: Remove the last element to "clean up" the list for the next branch
        current.remove(current.size() - 1);

        // CHOICE 2: Exclude nums[i]
        generateSubsets(i + 1, nums, current, result);
    }

//-------------------------------------------------------------------------------------------------------------
    // Duplicate subset :-
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        // 1. Sort to bring duplicates together
//        Arrays.sort(nums);c
//
//        generateSubsets(0, nums, new ArrayList<>(), result);
//        return result;
//    }
//
//    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
//        // Every state in the decision tree is a valid subset
//        result.add(new ArrayList<>(current));
//
//        for (int i = index; i < nums.length; i++) {
//            // 2. CRITICAL: Skip duplicates
//            // If i > index, it means we are exploring alternative choices
//            // at the SAME level of the tree.
//            if (i > index && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            // Move forward with the choice
//            current.add(nums[i]);
//            generateSubsets(i + 1, nums, current, result);
//
//            // Backtrack
//            current.remove(current.size() - 1);
//        }
//    }

//-------------------------------------------------------------------------------------------------------------
//  for negative values:-
//    Input: x = 2.00000, n = -2
//    Output: 0.25000
//    Explanation: 2-2 = 1/22 = 1/4 = 0.25
    public double myPow(double x, int n) {
    // 1. Handle the "Integer Overflow" Edge Case:
    // Integer.MIN_VALUE (-2147483648) doesn't have a positive counterpart in 'int'.
    // We cast 'n' to 'long' to safely convert negative exponents to positive.
        long N = n;

    // 2. Handle Negative Exponents:
    // Mathematically, x^(-n) is the same as (1/x)^n.
    // We invert the base and flip the sign of the exponent to simplify logic.
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
    return solve(x, N);
}

    private double solve(double x, long n) {
        // 3. Base Case:
        // Any number raised to the power of 0 is always 1.
        if (n == 0) {
            return 1.0;
        }

        // 4. Divide and Conquer (Binary Exponentiation):
        // Instead of multiplying x by itself n times (O(n)),
        // we calculate the power for n/2 and store it to avoid redundant work.
        double halfPow = solve(x, n / 2);

        // 5. Combine Results:
        // If n is even: x^n = (x^(n/2)) * (x^(n/2))
        // If n is odd:  x^n = (x^(n/2)) * (x^(n/2)) * x
        if (n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * halfPow * x;
        }
    }
   
//----------------------------------------------------------------------------------------------------------------

//    public static void revision(int n){
//        if (n == 0){
//
//        }
//
//    }
        
//---------------------------------------------------------------------------------------------------------------

        


}

