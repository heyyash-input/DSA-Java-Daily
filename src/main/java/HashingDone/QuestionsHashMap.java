package HashingDone;

import java.util.*;

public class QuestionsHashMap {
    public static void main(String[] args) {

        /// Majority Elements:-
        int arr [] = {1,3 , 2 ,5 ,1 ,3 ,1 ,5 ,1 } ;
        majority(arr);

        /// Valid Anagrams:-
        String s = "race";
        String t = "care";
        System.out.println(isAnagram(s , t ));

        /// Count Distinct:-
        int dist [] = { 4,3,2,5,6,7,3,4,2,1};

    }

//------------------------------------------------------------------------------------------------------------------------------

    /// Majority of Elements:-
    public static void majority(int arr []){
        HashMap<Integer ,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
//            if(map.containsKey(arr[i])){
//                map.put(arr[i] , map.get(arr[i]) + 1 );
//            }else{
//                map.put(arr[i], 1 );
//            }
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1 );
        }

          Set<Integer> keySet = map.keySet();
        for (Integer key : keySet){
            if(map.get(key) > arr.length / 3){
                System.out.println(key);
            }
        }
    }

//------------------------------------------------------------------------------------------------------------------------------

    /// Valid Anagrams:-
    public static boolean isAnagram(String s , String t){
        HashMap<Character , Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch ,0 ) + 1);
        }

        for(int i= 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1 ){
                    map.remove(ch);
                }else{
                    map.put( ch ,map.get(ch) - 1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
//------------------------------------------------------------------------------------------------------------------------------

    /// Count Distinct:-


}
