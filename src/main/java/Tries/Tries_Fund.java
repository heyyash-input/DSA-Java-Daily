package Tries;

public class Tries_Fund {
//------------------------------------------------------------------------------------------------------------------------------
    public static class Node{
        Node children [] = new Node [26];
        boolean eow = false;


        Node(){
            for (int i = 0; i < 26; i++) {
                children[i] = null ;
            }
        }
    }
//------------------------------------------------------------------------------------------------------------------------------
    public static Node root = new Node() ;
//------------------------------------------------------------------------------------------------------------------------------
    public static boolean wordBreaker(String key){

        if(key.length() == 0){
            return true ;
        }

        for (int i = 1; i < key.length(); i++) {
            //substring(beg idx , last idx);
          if(search(key.substring(0 , i)) && wordBreaker(key.substring(i ))){
              return true;
          }
        }
        return false;
    }
//------------------------------------------------------------------------------------------------------------------------------
    public static void insert(String word){
        Node curr = root ;
        for (int level = 0; level < word.length() ; level++) {
            int idx = word.charAt(level) - 'a' ;
            if(curr.children[idx] == null ){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        // for end of word true to make sure we successfully ended the word:
        curr.eow = true ;
    }
//----------------------------------------------------------------------------------------------------------------------------
    public static boolean search(  String key){
        Node curr = root ;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null ){
                    return false;
            }
            curr = curr.children[idx] ;
        }
        return curr.eow == true ;
    }
//--------------------------------------------------------------------------------------------------------------------------

    /// Start with problem: O (L) = length
    public static boolean startWith(String prefix ){
        Node curr = root ;
        for (int level = 0; level < prefix.length(); level++) {
            int idx = prefix.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

//------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        String word[] = {"the" , "a" , "there" , "their" , "any" , "thee"};
        String arr[] ={"i" , "like" , "sam" , "samsung" , "mobile" , "ice"};
        String word1[] = {"apple" , "app" , "mango" , "man" , "women"};
        String prefix1 = "app" ;
        String prefix2 = "moon" ;


//        /// insert:-
//        for (int i = 0; i < word.length; i++) {
//            insert(word[i]);
//        }
//
//        /// search:-
//        System.out.println( search("the"));
//        System.out.println(search("ther"));
//
//        ///Word breaker:
//        for (int i = 0; i < arr.length ; i++) {
//            insert(arr[i]);
//        }
//        String key = "ilikemobile";
//        System.out.println(wordBreaker(key));

        /// Start with problem:
        for (int i = 0; i < word1.length; i++) {
            insert(word1[i]);
        }
        System.out.println(startWith(prefix1)); //true
        System.out.println(startWith(prefix2)); //false
    }
//------------------------------------------------------------------------------------------------------------------------------
}
