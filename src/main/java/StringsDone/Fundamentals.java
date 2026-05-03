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
//        Scanner sc =  new Scanner(System.in);
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


}
