package QueueDone;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class QuestionPractice {

    public static void  firstNonRepeating(String str){
        Queue <Character> q = new LinkedList<>();
        int freq [] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch =  str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1 ){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.println("-1");
            }else{
                System.out.println(q.peek() + " ");
            }
        }
        System.out.print(" ");;

    }
    public static void main(String[] args) {
//        Queue <Character> q = new LinkedList<>();
//        String str = "aabccxb";
//        firstNonRepeating(str);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(4);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleaveHalves(q);

        while (!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }

    public static void interleaveHalves(Queue<Integer> q ){
        Queue<Integer> firstHalve= new LinkedList<>();

        int size = q.size();
        for (int i = 0; i < size /2 ; i++) {
            firstHalve.add(q.remove());
        }
        while(!firstHalve.isEmpty()){
            q.add(firstHalve.remove());
            q.add(q.remove());
        }
    }
}
