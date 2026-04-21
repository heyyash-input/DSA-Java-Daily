package BinarySearchDone;

public class BinarySearch1_n {
    public static void main(String[] args) {
        int [] arr ={0, 1, 2, 7, 8, 9};;
        int target = 2;
    }
    public static int BinarySearch(int [] arr , int target) {
        int start = 0 ;
        int end  = arr.length -1 ;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                return mid ;
            }
            if (arr[mid] < target ){
                start = mid + 1;
            }else {
                end = mid - 1 ;
            }
        }
        return -1;
    }

    public static int OrderAgnostic(int [] arr , int target){

            int start = 0 ;
            int end = arr.length-1;
            while (start <= end){
                int mid = start + (start-end)/2;
                if (arr[mid] == target){
                    return mid ;
                }else if(arr[mid] < target){
                    start = mid+1;
                }else{
                    end = mid - 1;
                }
            }
        return -1 ;
    }

    public static int countOccurances(int [] nums , int target){
        int first = occ(nums,target,true);
        if(first == -1) return 0 ;
        int last = occ(nums,target,false);
                return (last - first + 1) ;
    }
    public static int occ (int [] nums , int target,boolean found){
        int n = nums.length;
        int s = 0 ;
        int e =n- 1 ;
        int result = -1 ;
        while(s <= e ) {
            int m = s + (e - s) / 2;
                if(nums[m] == target){
            result = m;
            if (found) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }else if (nums[m] < target){
                s = m + 1 ;
            }else{
                e = m -1 ;
            }
        }
        return result ;
    }

//    public static boolean RotateArrays(int nums , int target){
//        int start = 0 ;
////        int end = nums.length;
//
////        return -1;
//    }
}
