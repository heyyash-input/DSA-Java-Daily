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

//-----------------------------------------------------------------------------------------------------------

    public static void interleaveHalves(Queue<Integer> q ){
        Queue<Integer> firstHalve= new LinkedList<>();

        int size = q.size(); // for calculating the size
        for (int i = 0; i < size /2 ; i++) {
            firstHalve.add(q.remove()); //basically here remove the elements from q and add it to the first half
        }
        while(!firstHalve.isEmpty()){ // check till empty
            q.add(firstHalve.remove()); // remove first half and add it to q
            q.add(q.remove()); //then remove form front and add it to rear
        }
    }

//---------------------------------------------------------------------------------------------------------

    public static void queueReverse(Queue<Integer> q2){
//        My silly approach this create infinit Loop:-
//        while(!q2.isEmpty()){
//            q2.add(q2.remove());
//        }
//        we need stack which already gives reverse INT
        Stack<Integer> s = new Stack<>();

        // Step 1: Queue -> Stack (Order is reversed)
        while(!s.isEmpty()){
            s.push(q2.remove());
        }
        // Step 2: Stack -> Queue (Now in reverse order)
        while (!s.isEmpty()){
            q2.add(s.pop());
        }
    }

// --------------------------------------------------------------------------------------------------------------

//    Creating Stack using deque :-
    public static class Stack01{
       static Deque <Integer> deque = new LinkedList<>();
        public static void push ( int data){
             deque.addLast(data);
        }
        public static int peek ( ){
             return deque.getLast();
        }
        public static int pop (){
            return deque.removeLast();
        }

    public static void main(String[] args) {
       Stack01  s = new Stack01() ;
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek: " + s.peek());
        System.out.println(s.pop()); // this pops 3

        }
    }

//    -----------------------------------------------------------------------------------------------------------------

//    Implementing Queue using Deque :-
    public static class Queue01{
       static Deque<Integer> deque = new LinkedList<>();

        public static void add(int data){
            deque.addLast(data);
        }

        public static int remove(){
            return deque.removeFirst();
        }

        public static int peek(){
            return deque.getFirst();
        }

        public static void main(String[] args) {
            Queue01 q = new Queue01();
            q.add(1);
            q.add(2);
            q.add(3);
            System.out.println("peek: "+q.peek());
            System.out.println(q.remove());
            System.out.println(q.remove());
            System.out.println(q.remove());
        }
    }

//  --------------------------------------------------------------------------------------------------------------

}
