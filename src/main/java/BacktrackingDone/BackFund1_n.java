package BacktrackingDone;

import java.util.Arrays;

public class BackFund1_n {

    // fundamentals for back tracking:
    public static void main(String[] args) {
//        int arr [] = new int[5] ;
//        arrBack(arr, 0 , 1 );
//        printArr(arr);

//        findSubset("abc" , "" , 0);
//         findPerm("abc" , "");

//--------------------------------------------------------------------------------------------------------------
        // NQueens:
//        int n = 4;
//        char board [] [] = new char[n][n] ;
//
//        //intialize:
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n ; j++) {
//                board[i][j] = 'X';
//            }
//        }
//        nQueens(board , 0 );
//        System.out.println("total ways: " + count);
//--------------------------------------------------------------------------------------------------------------
        //Grid Path:
        int n= 3 , m = 3 ;
        System.out.println(gridPath(0  , 0 ,n  , m));

    }
//--------------------------------------------------------------------------------------------------------------------

    public static void printArr(int arr []){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

//------------------------------------------------------------------------------------------------------------------

    public static void arrBack(int arr [] , int i , int val ){
        //base case
        if( i == arr.length){
            printArr(arr);
            return;
        }

        //recursion
        arr[i] = val  ; // going up
        arrBack(arr , i+1 , val + 1 );
        arr[i] = arr[i] - 2 ; // when coming down then this will execute
    }

//------------------------------------------------------------------------------------------------------------------

    public static void findSubset ( String str , String ans, int i ){
        //base case:
        if( i == str.length()){

            if(ans.length() == 0){
                System.out.println("Null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        // recursion
        //Yes
        findSubset(str , ans + str.charAt(i) , i+1 );
        //No
        findSubset(str  , ans  , i+1 );
    }

//------------------------------------------------------------------------------------------------------------------

    public static void findPerm(String str , String ans) {

        //base case:
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        //recursion: O (n X n!) TC
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde" = "ab " + "de" =  "abde" ;
           String newStr = str.substring(0, i) + str.substring(i + 1  );

            findPerm(newStr, ans + curr);
        }
    }
//----------------------------------------------------------------------------------------------------------------

    public static void printBoard(char [] [] board ) {
        System.out.println("-------Chess Board---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
    static int count ;
    public static void nQueens ( char [] [] board , int row ){
        if ( row == board.length){
//            printBoard(board);
            count++; // for N-Queens count possible ways
            return ;
        }

        // Column loop:-
        for (int j = 0; j < board.length; j++) {
           if(isSafe(board , row , j )){
               board[row][j]  = 'Q';
               nQueens(board , row +  1 ); // function call
               board[row][j]  = 'X'; // backtracking
           }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
            // vertical up  
        for (int i = row-1 ; i >= 0; i--) {
            if(board[i][col] == 'Q' ){
                return false;
            }
        }
            // daigonal left up
        for (int i = row-1 , j = col -1 ;  i >= 0 && j >=0 ; i-- , j--) {
                if(board[i][j] == 'Q' ){
                    return false;
            }
        }
            //daigonal right up
        for (int i = row-1 , j = col +1 ;  i >= 0 && j < board.length ; i-- , j++) {
            if(board[i][j] == 'Q' ){
                return false;
            }
        }
        return true;
     }

//     time complexcity : -
//---------------------------------------------------------------------------------------------------------------

    //Grid path questions to find number of ways :

    public static int gridPath(int i , int j , int n , int m){

        // condition for last stage:
        if(i == n-1 && j == m-1){
            return 1 ;
        }
        //Boundary cnondition:
        else if (i == n || j == m) {
            return 0 ;
        }

        int w1 = gridPath(i+1 ,j , n  ,m );
        int w2 = gridPath(i,j + 1  , n  ,m );
        return w1 + w2 ;
        // TC:- O(2^m*n)
        // using permutation formula we can convert it to - O(m*n)
    }

}
