package Last_Moment_Rev.IMP_patterns.Strings;

import java.util.Arrays;
import java.util.HashMap;

public class Patterns_Strings {

    public static void main(String[] args) {
        /// reverse string:
        String s = "Yash";
        System.out.println(reverse(s));

        ///Palindrome: using two pointers
        String sPal = "mada";
        System.out.println(isPalindrome(sPal));

        ///Frequency Count:
        String sCount = "banana";
        System.out.println(Arrays.toString(freqCount(sCount)));
        System.out.println(freCountINT(sCount ,'a'));

        /// Anagrams:
        String sAna = "leetcode";
        String tAna = "edocteel";
        System.out.println(isAnagram(sAna , tAna));

    }
//----------------------------------------------------------------------------------------------------------------------------
    //Reverse:(methode 1)
    public static String reverse(String s){
    StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            char curr = s.charAt(i);
                sb.append(curr);
        }
    return sb.toString();
    }

    // Reverse:(methode 2)
    public static String reverse1(String s){
        String ans = "";
        for (int i = s.length()-1; i >= 0 ; i--) {
            char curr = s.charAt(i);
            ans = ans + curr;
        }
        return ans ;
    }

    // Reverse:(methode 3)
    public static String reverse2(String s){
        // convert to arr:
        char arr[] = s.toCharArray();
        int i = 0 ;
        int j = s.length()-1;

        while(i <= j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
        }
        // we did
        return new String(arr);
    }
//----------------------------------------------------------------------------------------------------------------------------
    ///Palindrome:(Methode 1)
    public static boolean isPalindrome(String s) {

        int i = 0 ;
        int j = s.length()-1;

        while( i <= j){

            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
//----------------------------------------------------------------------------------------------------------------------------
    /// Character Frequency:
    public static int [] freqCount(String s){
        s.toLowerCase();
        int arr [] = new int[26];
        for (int i = 0; i < s.length() ; i++) {
            char curr = s.charAt(i);
            arr[curr - 'a']++ ;
        }
      return arr ;
    }

    /// if return type is int
    public static int freCountINT (String s  , char target){
        int count = 0 ;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == target) {
                count++;
            }
        }
        return count ;
    }

//----------------------------------------------------------------------------------------------------------------------------

    /// Anagrams:-
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int freq [] = new int[26];
        // just check for length:
        for (int i = 0 ; i < s.length() ; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        //check:
        for (int i = 0; i < 26; i++) {
            if( freq[i] != 0 ){
                return false;
            }
        }
        return true;
    }

//----------------------------------------------------------------------------------------------------------------------------

    public static int firstUnique(String s ){
        int freq [] = new int[26];

        //count
        for (int i = 0; i < s.length() ; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(freq[i] == 1){
                return i ;
            }
        }
        return 0 ;
    }

//---------------------------------------------------------------------------------------------------------------------------
    ///reverse words:
    public static String reversWords(String s) {
        StringBuilder sb = new StringBuilder();

        String s1 [] = s.trim().split("\\s+");

        for (int i = s1.length-1; i >=0  ; i--) {
            sb.append(s1[i]);
            if( i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
//---------------------------------------------------------------------------------------------------------------------------

    /// Longest Substring Without repeating character:
    public static int subtringChar(String s ){
        HashMap<Character , Integer > map = new HashMap<>() ;

        if(s == null ){
            return 0 ;
        }

        int maxLength = 0 ;
        int left = 0 ;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(map.containsKey(curr)){
                left = Math.max(left , map.get(curr) + 1 );
            }
            map.put(curr , i);
            maxLength = Math.max(maxLength , i - left + 1 );
        }
        return maxLength ;
    }

}
