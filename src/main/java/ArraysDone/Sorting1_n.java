package ArraysDone;

public class Sorting1_n {
    public static void main(String[] args) {
        int []arr ={9,7,5, 6 ,3,4,2,1,0};
//        System.out.println(BubbleSort(arr));
//        BubbleSort(arr);
        selectionSort(arr);
        printArr(arr);
    }
//--------------------------------------------------------------------------------------------------------------

    public static void printArr(int [] arr ){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

//--------------------------------------------------------------------------------------------------------------

    public static void swap(int [] arr , int start , int end){
        int temp = arr[start] ;
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void SelectionSort(int [] arr){
        
    }
//---------------------------------------------------------------------------------------------------------------

// O(n2) :-
    public static void BubbleSort(int [] arr){
        int n = arr.length ;
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = 0; j < n- 1 - i ; j++) {
                    if ( arr[j] > arr[j+1]){
                        int temp = arr[j] ;
                        arr[j] = arr[j+1];
                        arr[j+1] = temp ;
                    }
            }
        }
    }

//---------------------------------------------------------------------------------------------------------------

    public static void selectionSort(int [] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minPos = i ;
            for (int j = i+1; j < n; j++) {
                if(arr[minPos] > arr[j]){
                    minPos = j ;
                }
            }
            // swap
            int temp =arr[minPos] ;
            arr[minPos] = arr [i] ;
            arr [i] = temp ;
        }
    }

//---------------------------------------------------------------------------------------------------------------

}
