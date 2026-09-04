package DivideAnsConquerDone.Revision;

public class MergeSort {
    public static void main(String[] args) {

        /// merge sort:-
        int num [] = {6 ,3 ,9 , 5 ,2 ,8 };
        mergeSort(num , 0 , num.length-1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }
        System.out.println();
    }

    public static void  mergeSort(int num [] , int s , int e){
        // do nothing we have reached single sorted condition:
        if(  s >= e ){
            return ;
        }
        // find mid
        int mid = s + ( e - s)  / 2 ;
        // if not found in mid then s  :-
        mergeSort(num , s , mid  ); /// left part
        // if not found in mid then e  :-
        mergeSort(num , mid + 1 , e ); /// right part
        // after dividing start merging the temp stored element:
        merge(num , s, mid , e );
    }

    public static void merge (int num [] , int s , int mid , int e){
        int n = num.length;
        // add all elements in temp first:-
        int temp [] = new int[ e -s + 1 ];

        int i = s ; // iterator for left part ;
        int j = mid+1 ; // iterattor for right part

        int k = 0 ; // iterator for temp elements:-

        while(i <= mid && j <= e ){
            if(num[i] < num[j]){
                temp[k] = num[i];
                i++ ;
            }else{
                temp[k] = num[j];
                j++;
            }
            // we need this for both side:
            k++;
        }

        // now that we have copied every element:
        // for left part:-
        while(i <= mid){
            temp[k] = num[i];
            i++;
            k++;
        }
        // for right part:-
        while(j <= e ){
            temp[k] = num[j];
            j++;
            k++;
        }
        
        // copy temp to num:
        for ( k = 0 , i = s ; k < temp.length ; k++ , i++) {
            num[i] = temp[k];
        }

    }


}
