package StackDone;

import java.util.Stack;

public class PracticeQuestions {

    public static void main(String[] args) {
//        String str = "/apnacollege/";
        String str = "/home//foo/../bar/" ;
        System.out.println( simplifyPath(str));

    }
    public static String simplifyPath(String str) {
        Stack<String> s = new Stack<>() ;
       String [] parts = str.split("/");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals( "") || parts[i].equals(".") ){
                continue;
            }
            if(parts[i].equals( "..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else{
                s.push(parts[i]);
            }
        }
        if (s.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder() ;
        for(String dir : s){
            sb.append("/").append(dir);
        }
    return sb.toString();
    }
}
