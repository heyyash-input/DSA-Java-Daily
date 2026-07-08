package ArraysDone;

public class SubArrays_Fund {

    public static void main(String[] args) {
//        int arr [] = {1,-2,6,-1 , 3};
//        subPrefix(arr);
        int arr [] = { -2 ,-3 , 4 , -1 , -2 , 1 , 5 , -3};
        KadanesAlgo(arr); //our max sum is: 7
    }

    public static void subPrefix(int arr []){
        int n = arr.length;
        int currSum = 0 ;
        int maxSum = Integer.MIN_VALUE;
        int prefix [] = new int[arr.length];

        //calclate pre:
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + prefix[i];
        }

        // calculate prefix here:
        for (int i = 0; i <n ; i++) {
            int start = i ;
            for (int j = 0; j < n; j++) {
                int end = j;

                //get prefix:
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];

                if(maxSum < currSum ){
                    maxSum= currSum ;
                }
            }
//            System.out.println();
        }
    }

    public static void KadanesAlgo (int arr []){
        int maxVal = Integer.MIN_VALUE;
        int curr = 0 ;
        for (int i = 0; i < arr.length ;i++) {

            //Sum:
            curr += arr[i];

            //If curr <0 then make it 0:
            if(curr < 0){
                curr =0 ;
            }

            maxVal = Math.max(maxVal,curr);
        }
        System.out.println("our max sum is: " + maxVal);
    }
}
