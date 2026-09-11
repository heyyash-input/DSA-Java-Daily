package Last_Moment_Rev.IMP_patterns.Stacks;

import java.util.Stack;

public class Patterns {
    public static void main(String[] args) {
        //Stack operations:

        /// Next Greater Element:-
        int arr [] = { 6 ,8 , 1  , 0 , 3 };
        System.out.println(nextGreaterEle(arr));

    }
//----------------------------------------------------------------------------------------------------------------------------
    public static int[] nextGreaterEle(int arr []){
        Stack <Integer> stack = new Stack<>();
            int ngl [] = new int[arr.length];
        for (int i = arr.length-1 ; i >=0  ; i--) {
            int curr = arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] <= curr ){
                stack.pop();
            }

            if(stack.isEmpty()){
                ngl [i] = -1 ;
            }else{
                 ngl[i] = arr[stack.peek()] ;
            }
            stack.push(i);
        }
        return ngl  ;
    }
//----------------------------------------------------------------------------------------------------------------------------

}
