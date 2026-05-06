package StringsDone;

import java.util.Scanner;

public class Fundamentals {

    public static void main(String[] args) {
        // 1. Character Array Initialization
        // Useful for password handling as arrays can be wiped from memory (Strings are immutable).
////        char ch[] = {'a', 'b', 'c'};

        // 2. String Literal Creation
        // This object is stored in the "String Constant Pool" (SCP).
        // If "abcd" already exists, Java reuses the reference to save memory.
////        String str1 = "abcd";

        // 3. String Object Creation via 'new' Keyword
        // This forces the creation of a new object in the "Heap" memory.
        // It is less memory-efficient than a literal because it bypasses immediate pool reuse.
////       String str2 = new String("xyz");
        //Strings are Immutable

        // Taking input and output
////       Scanner sc =  new Scanner(System.in);
//        String name , college ;
//        college= sc.next(); // takes only words
//        name = sc.nextLine(); // takes whole word
//        System.out.println(name);

        // Counting length + spaces calculates
//        String fullName = "Tony Stark";
//        System.out.println(fullName.length());

        //Concatenation
//        String firstName = "Yash";
//        String lastName = "Patil";
//        String fullName = firstName + " " + lastName;
//        System.out.println(fullName);

        //CharAt methode:-
//      printLetters("Yash Patil");

      //Palindorme:-
//        System.out.println(isPalindrome("noon"));
        System.out.println(shortestDist("NS"));

////      VVVVIMP asked in interview
//        String compare:- Diff between .eqauls and ==

        String str1 = "Tony";
        String str2 = "Tony";
        String str3 = new String("Tony");

        if(str1 == str2){
            System.out.println("Are equal");
        }else{
            System.out.println("Not equal");
        }

        if(str1 == str3){
            System.out.println("Are equals");
        }else{
            System.out.println("Not equals");
        }
        //by using .equals
        if (str1.equals(str3)){
            System.out.println("Are equal");
        }else {
            System.out.println(" Not equals");
        }

        String fruits []  = {"apple" , "mango" , "banana"};
        String largest = fruits[0];
        for (int i = 0; i < fruits.length; i++) {
            if(largest.compareTo(fruits[i]) < 0 ){
                largest = fruits[i];
            }
        }
        System.out.println(largest);

//        Upper Case question:-
        String str03 = "hi, i am yash";
        System.out.println(upperCase(str03));

        //String commprssion question:-
        String str04 = "aaabbcccdd";
        System.out.println(compression(str04));

        //Occurance of lower case:-
        String lc = "Yash";
        System.out.println(occuranceLowerCase(lc));
    }

//--------------------------------------------------------------------------------------------------------------

    public static void printLetters(String s){
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i)+" ");
        }
        System.out.println();
    }

//---------------------------------------------------------------------------------------------------------------
    // asked in interview for String concepts of two pointer:-
    public static String isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                System.out.println("not palindrome");
                return "false";
            }else{
                i++;
                j--;
            }
        }
        System.out.println("it is palindrome");
        return "true";
    }

//--------------------------------------------------------------------------------------------------------------

    public static float shortestDist(String s3){
        int x =0 , y = 0 ;
        for (int i = 0; i < s3.length(); i++) {
            char dir = s3.charAt(i);
            //North
            if(dir == 'N'){
                y++;
            }
            //East
            else if (dir == 'E') {
                x++;
            }
            //South
            else if (dir == 'S') {
                y--;
            }
            //West
            else {
                x++;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2 + Y2);
    }

//---------------------------------------------------------------------------------------------------------------

    /// Asked in interview VVVIMPPP:-
    public static String upperCase(String str03 ){
        StringBuilder sb  = new StringBuilder();
        char ch = Character.toUpperCase(str03.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str03.length(); i++) {
            if(str03.charAt(i) == ' ' && i < str03.length()-1){
                sb.append(str03.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str03.charAt(i)));
            }else{
                sb.append(str03.charAt(i));
            }
        }
        return sb.toString();
    }

//----------------------------------------------------------------------------------------------------------------

    /**
     * AMAZON INTERVIEW PATTERN: String Compression (Run-Length Encoding)
     * Time Complexity: O(n) - We traverse the string once.
     * Space Complexity: O(n) - To store the compressed result.
     */
    public static String compression(String str04) {
        // 1. Use StringBuilder for O(n) performance.
        // Regular String concatenation (+=) inside a loop creates many temporary objects.
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str04.length(); i++) {
            Integer count = 1;

            // 2. The "Look-Ahead" Logic:
            // Compare current char with the next one.
            // We stop at length-1 to avoid IndexOutOfBoundsException.
            while (i < str04.length() - 1 && str04.charAt(i) == str04.charAt(i + 1)) {
                count++;
                i++; // Increment 'i' to skip the characters we've already counted
            }
            // 3. Append the character being compressed
            sb.append(str04.charAt(i));
            // 4. Optimization: Only add the count if it's greater than 1.
            // Example: "abcd" stays "abcd", not "a1b1c1d1".
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    //another version without using string builder
//    //Interview special - AMAZAON IMPP Pattern
//    public static String compression(String str04){
//        String strNew = "";
//
//        for (int i = 0; i < str04.length() ; i++) {
//            Integer count = 1 ;
//            while( i < str04.length()-1 && str04.charAt(i) == str04.charAt(i+1)){
//                count++;
//                i++;
//            }
//            strNew += str04.charAt(i);
//            if(count > 1 ){
//                strNew += count.toString();
//            }
//        }
//        return strNew ;
//    }

//---------------------------------------------------------------------------------------------------------------

    //Count how many times lowercase vowels occurred in a String entered by the user:-
    public static int occuranceLowerCase(String lc){
        int count = 0 ;
        for (int i = 0; i < lc.length() ; i++) {
            char ch = lc.charAt(i);
            if ( i < lc.length()-1 && ch == 'a' || ch == 'e' || ch == 'o' || ch =='i' || ch =='u'){
                count++;
            }
        }
        return count;
    }

//---------------------------------------------------------------------------------------------------------------


}
