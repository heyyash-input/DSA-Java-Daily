package DP_basics.Fundamentals.Questions_Patterns;

import java.util.Arrays;
import java.util.HashSet;

public class Questions {

//------------------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        /// longest Subsequence
        String str1 = "abcde";
        String str2 = "abc";
        System.out.println(lowestCommonSubseq(str1 , str2 , str1.length() , str2.length()));

        /// Longmest subsequence
        int n = str1.length();
        int m = str1.length();
        int dp [][] = new int[n+1][m+1];

        //Initialization:
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = -1 ;
            }
        }
        System.out.println(lowestCommonSubseqMemo(str1 , str2 , str1.length() , str2.length() , dp));

        ///Lonest subsequence with Tabulation:
        System.out.println(lcsTab(str1,str2));

        /// Longest Increasing Subsequence:
        int num [] = {10 , 9 ,2 ,5 , 3, 7 ,101 , 18};
        System.out.println(lcsInc(num)); // output :-4

    }

//------------------------------------------------------------------------------------------------------------------------------

    /// normal Recursion:
    public static int lowestCommonSubseq(String str1 , String str2 , int n , int m){
        // base condition:
        if(n == 0 || m == 0){
            return 0 ;
        }

        if (str1.charAt(n-1) == str2.charAt(m-1)) {
          return lowestCommonSubseq(str1 , str2 , n-1 , m-1) + 1 ;
        }
        // different:
        else{
            int ans1 = lowestCommonSubseq(str1 , str2 , n-1 , m );
            int ans2 = lowestCommonSubseq(str1 , str2 , n , m-1 );
            return Math.max(ans1 , ans2);
        }
    }

//------------------------------------------------------------------------------------------------------------------------------

    /// By memoization:-
    public static int lowestCommonSubseqMemo(String str1 , String str2 , int n , int m , int dp [] []){
        // base condition:
        if(n == 0 || m == 0){
            return 0 ;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = lowestCommonSubseqMemo(str1 , str2 , n-1 , m-1 , dp) + 1 ;
        }
        // different:
        else{
            int ans1 = lowestCommonSubseqMemo(str1 , str2 , n-1 , m ,dp);
            int ans2 = lowestCommonSubseqMemo(str1 , str2 , n , m-1 ,dp);
            return dp[n][m] = Math.max(ans1 , ans2);
        }
    }

//------------------------------------------------------------------------------------------------------------------------------

    ///Lowest Common Subseq By tabulation:
    public static int lcsTab(String str1 , String str2 ){

        int n = str1.length();
        int m = str2.length();
        int dp [][] = new int[n+1][m+1];

        //Initialization:
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] =  0 ;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp [n][m] ;
    }

//----------------------------------------------------------------------------------------------------------------------

    ///Lowest Common Subseq By tabulation:
    public static int lcSubstring(String str1 , String str2 ){

        int n = str1.length();
        int m = str2.length();
        int dp [][] = new int[n+1][m+1];

        int max =0 ;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    // bcoz substring can be anywhere :
                    max = Math.max(max , dp[i][j]);
                }else{
                    // just reset it :
                    dp[i][j] = 0 ;
                }
            }
        }
        return max ;
    }

//----------------------------------------------------------------------------------------------------------------------

    /// Longest Common Increasing Subsequence:
    public static int lcsInc(int [] arr ){

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < arr.length ; i ++ ){
            set.add(arr[i]);
        }

        int [] arr2 = new int [set.size()]; // sorted element store
        int i = 0 ;
        for( int num : arr){
            arr2 [i] = num ;
            i++;
        }

        Arrays.sort(arr2);

       return lcs(arr , arr2);
    }

    public static int lcs(int arr [] , int arr2 []){

        int n = arr.length ;
        int m = arr2.length;

        int dp [][] = new int [n+1][m+1] ;

        for(int i = 0 ; i < n+ 1 ; i++){
            for (int j = 0; j < m+1; j++) {
                if( i == 0 || j == 0){
                    dp[i][j] = 0 ;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }
                else{
                    dp[i][j] =Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    

}
