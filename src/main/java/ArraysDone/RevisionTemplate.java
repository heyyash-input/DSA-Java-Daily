package ArraysDone;

public class RevisionTemplate {

    public static void maxSubarray(int arr){

    }

//------------------------------------------------------------------------------------------------------------

    public static void printSubarray(int arr[]){
        int ts =0 ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("[");
                for (int k = i; k <= j; k++) {
//                    System.out.print(",");
                    System.out.print(arr[k]);
                    System.out.print(",");
                }
                ts++;
                System.out.println("]");
            }
        }
        System.out.println("total number of Subset are:" +ts);
    }

//------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int arr [] = {2 , 4 ,6 , 8 , 10};
        printSubarray(arr);
    }
}
