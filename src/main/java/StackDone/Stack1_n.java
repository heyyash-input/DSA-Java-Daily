package StackDone;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Stack1_n {

//    Implement Stack using ArrayList:-
  static class stack {
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0 ;
        }
//      push
        public static void push (int data ){
            list.add(data);
        }
//      push
        public static int pop(){
            if(isEmpty()){
                return -1 ;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top ;
        }
//      peek
        public static int  peek(){
            if(isEmpty()){
                return -1 ;
            }
            return list.get(list.size()-1);
        }
    }
//     Implement Stack Using LL:-
    static class Node{
      int data ;
      Node next ;
      Node (int data){
          this.data = data ;
          this.next = null ;
      }
}
    static class stackB{
    static Node head =  null ;
    public static boolean isEmpty(){
        return head == null ;
    }

    public static void push(int data){
        Node newNode = new Node(data) ;
        if (isEmpty()){
            head = newNode;
            return;
        }
        newNode.next = head ;
        head = newNode ;
    }

    public static int pop(){
        if (isEmpty()){
            return-1 ;
        }
        int top = head.data;
        head = head.next;
        return top ;
    }

    public static int peek(){
        if (isEmpty()){
            return-1 ;
        }
        return head.data;
    }
    }

    public static void pushAtBottom(Stack<Integer> s ,   int data){
      if(s.isEmpty()){
          s.push(data);
          return;
      }
      int top = s.pop() ;
      pushAtBottom(s,data);
      s.push(top);
    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0 ;
        while(idx < str.length()){
            s.push(str.charAt(idx)) ;
            idx++;
        }
        StringBuilder sb = new StringBuilder("") ;
        while(!s.isEmpty()){
            char curr = s.pop() ;
            sb.append(curr);
        }
        return sb.toString();
    }

    public static void reversStack(Stack<Integer> s ){
      if(s.isEmpty()){
          return;
      }
//      Stack<Integer> s = new Stack<>();
        int top = s.pop();
        reversStack(s);
        pushAtBottom(s,top);
    }

    public static  void printStack(Stack<Integer> s ){
      while (!s.isEmpty()){
          System.out.println(s.pop());
      }
    }

    public static void main(String[] args) {
//      Stack s = new Stack<>() ;
//        Stack<Integer> s = new Stack<>();
//      s.push(1);
//      s.push(2);
//      s.push(3);

//      reversStack(s);

//      while(!s.isEmpty()){
//          System.out.println(s.peek());
//          s.pop();
//          pushAtBottom(s,4);
//      }

//      pushAtBottom(s,4);
//      while (!s.isEmpty()){
//          System.out.println(s.pop());
//      }
//      String str = "abc";
//      String sb = reverseString(str);
//        System.out.println(sb);

//        Stock problem :-
//        int stock[] = {100,80,60,70,60,85,100};
//        int span [] = new int [stock.length];
//        stockSpan(stock,span);
//
//        for (int i = 0; i < span.length; i++) {
//            System.out.println(span[i]+" ");
//        }

//        Valid Parenthesis:-
//        String str = "({})[][]"; //true
//        System.out.println(isValid(str));

////        Count Duplicate in Parenthesis:-
//        String str1= "((a+b)+(a+b))"; // true
//        String str2 = "((a+b))"; // false
//        System.out.println(isDuplicate(str2));

//        Max Area of Histogram:-
        int arr[] = {2,1,5,6,2,3};
        maxHistogram(arr);

//        Next Greater Element:-
////        int arr[] = {6,8,0,1,3};
//        Stack<Integer> stack =  new Stack<>() ;
//        int nextGreater [] = new int[arr.length] ;
//
//        for (int i = arr.length - 1 ; i >= 0 ; i--) {
//            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
//                stack.pop();
//            }
//            if (stack.isEmpty()) {
//                nextGreater[i] = -1 ;
//            }else{
//                nextGreater[i] = arr[stack.peek()];
//            }
//            stack.push(i);
//        }
//        for (int i = 0; i < nextGreater.length; i++) {
//            System.out.print(nextGreater[i] +" ");
//        }
//        System.out.println();
    }

//    ------------------------------------------------------------------------------------------------------
//     VVIMP asked in interview for Bajaj Finserv

    private static void maxHistogram(int[] arr) {
      int maxArea = 0 ;
      int nsr[] = new int[arr.length] ;
      int nsl[] = new int[arr.length] ;

      // Next smaller right
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length -1 ;i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                //-1
                nsr[i] = arr.length; // not -1 use "n"
            }else{
                //top
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // Next smaller left
        s = new Stack<>();
        for (int i = 0 ;i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                //-1
                nsl[i] = -1 ;
            }else{
                //top
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //Current Area: Width:- i - j -1 = nsr[i] - nsl[j] - 1 ;
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int widght =  nsr[i] - nsl[i] - 1  ;
            int currArea = height * widght ;
            maxArea = Math.max(currArea,maxArea);
        }
        System.out.println("Maximum Area of Histogram is = " + maxArea);
        return ;
    }

//----------------------------------------------------------------------------------------------------------------

    public static boolean isDuplicate(String str2){
      Stack<Character> s = new Stack<>() ;

        for (int i = 0; i < str2.length(); i++) {
            char ch =str2.charAt(i);
            int count = 0 ; // Reset for every check (Mistake)
//            Closing:-
            if (ch == ')'){
                while(!s.isEmpty() && s.peek() !='('){
                    s.pop();
                    count++;
                }
                if(count < 1){
                    return true ; //duplictae
                }else{
                    s.pop(); // opening pair
                }
            }else{
                s.push(ch); //Opening condition
            }
        }
        return false;
    }

//    -----------------------------------------------------------------------------------------------------------

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // opening condition:-
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') ||
                        (s.peek() == '[' && ch == ']') ||
                        (s.peek() == '{' && ch == '}')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
//-------------------------------------------------------------------------------------------------------------

// optimised for valid:- Using Deque
    public boolean isValidOtpimised(String s) {
        // Optimization 1: ArrayDeque is faster than Stack class
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            // Optimization 2: Push the "Expected" closer
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            }
            // If it's a closer, it MUST match the popped element exactly
            else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

//----------------------------------------------------------------------------------------------------------------

    private static void stockSpan(int[] stock, int[] span) {
      Stack<Integer> s = new Stack<>() ;
       span [0] = 1 ;
       s.push(0);
        for (int i = 1; i < stock.length ; i++) {
            int currPrice = stock[i];
            while(!s.isEmpty() && currPrice > stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i + 1;
            }else{
                int prevhigh = s.peek();
                span[i] = i - prevhigh ;
            }
            s.push(i);
        }
    }
}
