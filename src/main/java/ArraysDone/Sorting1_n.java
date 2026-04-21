package ArraysDone;

public class Sorting1_n {
    public static void main(String[] args) {
        int []arr ={9,7,5,3,4,2,1,0};
//        System.out.println(BubbleSort(arr));
    }

    public static void swap(int [] arr , int start , int end){
        int temp = arr[start] ;
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void SelectionSort(int [] arr){
        
    }
// O(n2) :-
    public static void BubbleSort(int [] arr){
        int n = arr.length ;
        for (int i = 0; i < n; i++) {
            boolean swapped = false ;
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }
            if(!swapped) break ;
        }
    }
}
