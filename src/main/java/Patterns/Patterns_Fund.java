package Patterns;

public class Patterns_Fund {
    public static void main(String[] args) {
//        squarePat(4);
//        triDownPat(5);
//        trianglePat(5);
//        invertedPat(5);
//        triUpsidePat(5);
//        halfPyramid(5);
    }

//------------------------------------------------------------------------------------------------------------------

    public static void squarePat(int n){
        for (int i = 0; i <= n ; i++) {
            System.out.println("*****");
        }
    }
//    Output:-
//                    *****
//                    *****
//                    *****
//                    *****

//------------------------------------------------------------------------------------------------------------------

    public static void triDownPat(int n){
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
//    Output:-
//            00000
//            1111
//            222
//            33
//            4

//------------------------------------------------------------------------------------------------------------------

    public static void triUpsidePat(int n){
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0; j < n - i ; j++) {
                System.out.print(n);
            }
            System.out.println();
        }
    }
//    Output:-
//             5555
//             555
//             55
//             5

//------------------------------------------------------------------------------------------------------------------

    public static void invertedPat(int n){
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0; j < n - i + 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
//     Output:-
//            *****
//            ****
//            ***
//            **
//            *

//------------------------------------------------------------------------------------------------------------------

    public static void halfPyramid(int n){
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= i  ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
//    Output:-
//            1
//            12
//            123
//            1234
//            12345

//------------------------------------------------------------------------------------------------------------------

}
