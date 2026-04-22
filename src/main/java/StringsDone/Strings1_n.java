package StringsDone;

import java.util.HashMap;

public class Strings1_n {
//    However, in Java, Strings are immutable (you can't change them once they are created).
//    This means if we want to "move" or "swap" characters,
//    we usually have to convert the String into a char[] array first.
    public static void main(String[] args) {
//        String s = "Yash" ;
//        String s1 = "H3llo, World!" ;
//        String s2 = "The blue is the sky";
//        String s3 = "Hello World";
//        String s4 = "yash patil";
//            String s5 = "ana";
//            String s6 = "ana";
//            String s = "paper" ;
//            String t = "title" ;
//            String s =  "abcde";
//            String goal = "edabc" ;
//            String s = "(1+(2*3)+((8)/4))+1" ;
        String s  = "ecebcab";
        int k =  6;
//        System.out.println(ReverseString(s));
//        System.out.println(CheckPalindrom(s));
//        System.out.println(CheckClear(s1));
//        System.out.println(WordFlipper(s2));
//        System.out.println(CountVowels(s3));
//        System.out.println(TheInitializer(s4));
//         System.out.println(Anagrams(s5,s6));
//            System.out.println(Isomorphic(s,t));
//        System.out.println(RotateString(s,goal));
//        System.out.println(ValidParenthesis(s));
        System.out.println(Kdistinct(s,k));
    }
//    VVVimp asked
    public static String ReverseString(String s ){

        char [] letters = s.toCharArray();
        int start = 0;
        int end  = letters.length - 1 ;
        while (start < end ){
            char temp = letters[start];
            letters[start]= letters[end];
            letters[end] = temp;
            start++ ;
            end-- ;
        }
        return new String(letters);
    }

//    When you code Strings, keep these three tools in your "pocket":
//
// s.charAt(i): Used to look at a letter (you can't use s[i]).
//
// s.toCharArray(): Used when you need to swap or move letters.
//
// StringBuilder: A special "Work-in-Progress" string tool that is much faster if you are
// adding lots of letters together in a loop.

// --------------------------------------------------------------------------------------------------------------
//      VVIMP below CheckPalindrome was asked for my interview
//     I personally recommend you to Practice these Pattern
    public static boolean CheckPalindrom(String s ){
        int start = 0 ;
        int end =  s.length()-1 ;
        while(start < end ){
            //s.charAt is used to look at specific number rather than s[i]
            if(s.charAt(start)!=s.charAt(end)){
                return false ;
            }
            start++;
            end--;
        }
        return true;
    }
//    public static String reverseVowels(String s){
//        char arr [] =s.toCharArray() ;
//        int start = 0 ;
//        int end = s.length()-1 ;
//        while(start < end ){
////            if (start < end && vowels.indexOf(arr[start])==-1);
//        }
//    }

    public static String CheckClear(String s1){
//       (Mark 1) What if the interviewer says: "Don't change the original string"?
//        Sometimes, an interviewer might ask you to keep the uppercase letters
//        until the very last second. In that case, you would do it inside the if block:
        StringBuilder sb = new StringBuilder() ;
        s1 = s1.toLowerCase();
        for (int i = 0; i < s1.length(); i++) {
            char current = s1.charAt(i);
                if (  Character.isLetterOrDigit(current)){
//                    sb.append(Character.toLowerCase(current)) ; .........(Mark 1)
                    sb.append(current);
                }
        }
        return sb.toString();
    }

    public static String WordFlipper(String s2) {
        // 1. Setup the building site
        StringBuilder sb = new StringBuilder();
        // 2. Slice the sentence into an array of words
        String[] words = s2.split(" ");
        // 3. The Reverse Scout: Start at the end, stop AFTER index 0
        for (int i = words.length - 1; i >= 0; i--) {
            // Target the specific word
            sb.append(words[i]);
            // Add glue (space) only if there is another word coming
            if (i > 0) {
                sb.append(" ");
            }
        }
        // 4. Package it up
        return sb.toString();
    }

    public static int CountVowels(String s3){
        int count = 0 ;
        s3 = s3.toLowerCase();
        StringBuilder sb = new StringBuilder();
//        char [] words = s3.toCharArray() ;
        for (int i = 0; i < s3.length(); i++) {
                if (s3.indexOf(s3.charAt(i)) != -1){
//            if(s3.charAt(i) == 'a'|| s3.charAt(i) == 'e'|| s3.charAt(i) == 'i'||s3.charAt(i) == 'o'||s3.charAt(i) == 'u'){
                count ++ ;
            }
        }
        return count ;
    }
    public static String TheInitializer(String s4){
        StringBuilder sb = new StringBuilder();
        String  words [] = s4.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            char upper = Character.toUpperCase(current.charAt(0));
            sb.append(upper).append(".") ;
        }
        return sb.toString();
    }

    public static boolean Anagrams(String s5 , String s6){
        if (s5.length()!=s6.length()) return false ;
        int buckets [] = new int[26];
        for (int i = 0; i < s5.length(); i++) {
            buckets[s5.charAt(i) - 'a']++;
            buckets[s6.charAt(i) - 'a']--;
        }
        for(int count: buckets){
            if(count!=0){
                return false ;
            }
        }
        return true ;
    }

    public static boolean Isomorphic(String s , String t){
//        we wanted to cover every element in the ASCII values ie we choose 256
           int [] mapS = new int [256];
            int [] mapT = new int[256] ;
            for (int i=0 ; i<s.length() ; i++){
                char currS = s.charAt(i);
                char currT = t.charAt(i);
                if(mapS[currS] != mapT[currT]){
                        return false;
                }
                mapS[currS] = i+1 ;
                mapT[currT] = i+1;
            }
            return true ;
    }

    public static boolean RotateString(String s , String goal){
        if (s.length() != goal.length()) return false ;
            String combined = s + s;
            if (combined.contains(goal)) {
                return true;
            }
        return false ;
    }

    public static int ValidParenthesis(String s ){
//        create the max element
        int maxdepth =0 ;
//        depth to calculate the in depth
        int depth = 0;
//        traversels for every char
        for (int i = 0; i < s.length(); i++) {
//            targetinh specific char
            char c = s.charAt(i);
//            if c catches the parenthesis then go deeper
            if (c == '('){
                    depth++ ;
//                    then update the value
                    if  (depth>maxdepth){
                        maxdepth = depth;
                    }
            } else if (c==')') {
                depth --;
            }
        }
        return maxdepth ;
    }

    // Distinct Characters
        public static String subarrayDistinct(String s , int k ){
            HashMap<Character,Integer> map = new HashMap<>() ;
            int i =0;
            int maxlength = 0;

            for (int j = 0; j < s.length(); j++) {

                char c = s.charAt(j) ;
                map.put(c, map.getOrDefault(c,0)+1);

                while (map.size() > k){
                    char shrink = s.charAt(i);
                   map.put(shrink,map.get(shrink)-1);

                   if (map.get(shrink) == 0){
                       map.remove(shrink);
                   }
                   i++;
                }
                maxlength = Math.max(maxlength,j-i+1);
            }
            return String.valueOf(maxlength);
        }

        // shrinking O(N) X O(N) = O(N)
        public static int Kdistinct(String s , int k){
        int maxlength = -1 ;
        int i =0 ;
        int distinct = 0 ;
        int count [] = new int[128] ;

            for (int j = 0; j < s.length(); j++) {
                char curr = s.charAt(j);
                count[curr]++ ;

                if (count[curr]  == 1){
                    distinct++ ;
                }

                while (distinct >= k){
                    char shrink = s.charAt(i);
                    count[shrink]--;

                    if (count[shrink] == 0){
                        distinct--;
                    }
                    i++;
                }
                maxlength = Math.max(maxlength,j-i+1);
            }
        return maxlength ;
        }

        public static int WithoutRepeating(String s , int k ){
            int i =0 ;
            int count[] = new int[128];
            int maxlength = -1  ;
            for (int j = 0; j < s.length(); j++) {
                char curr = s.charAt(j);
                count[curr]++;
//        If the current character's count is > 1, we have a repeat!
//        Move the tail (i) until the repeat is gone.
//        while (count[curr] > 1) {
                while ( count[curr] > 1){
                    char shrink = s.charAt(i);
                    count[shrink]-- ;
                    i++;
                }
                maxlength = Math.max(maxlength,j-i+1);
            }
            return maxlength ;
        }



}
