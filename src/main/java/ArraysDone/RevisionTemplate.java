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
//        int arr [] = {2 , 4 ,6 , 8 , 10};
//        printSubarray(arr);

        // Trapping Rainwater:-
        int height [] = {4 , 2 , 0 , 6 , 3 , 2 , 5} ;
        System.out.println(trappedRainwater(height));
    }

    public static int trappedRainwater(int height[]) {
        int n = height.length;
        if (n <= 2) return 0; // Edge case: No water can be trapped with less than 3 bars

        // 1. Calculate left max boundary array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            // BUGFIX: Changed leftMax[i] to height[i].
            // Must compare current bar height with previous maximum, not the uninitialized 0.
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // 2. Calculate right max boundary array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            // BUGFIX: Changed rightMax[i] to height[i].
            // Must compare current bar height with next maximum from the right.
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        // 3. Calculate total trapped water using the precalculated boundaries
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trapped += waterLevel - height[i];
        }

        return trapped;
    }
}
