package Last_Moment_Rev.IMP_patterns;

public class Patterns_Strings {

    public static void main(String[] args) {
        /// reverse string:
        String s = "Yash";
        System.out.println(reverse(s));

        ///Palindrome: using two pointers
        String sPal = "mada";
        System.out.println(isPalindrome(sPal));

    }
//----------------------------------------------------------------------------------------------------------------------------
    //Reverse:(methode 1)
    public static String reverse(String s){
    StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            char curr = s.charAt(i);
                sb.append(curr);
        }
    return sb.toString();
    }

    // Reverse:(methode 2)
    public static String reverse1(String s){
        String ans = "";
        for (int i = s.length()-1; i >= 0 ; i--) {
            char curr = s.charAt(i);
            ans = ans + curr;
        }
        return ans ;
    }

    // Reverse:(methode 3)
    public static String reverse2(String s){
        // convert to arr:
        char arr[] = s.toCharArray();
        int i = 0 ;
        int j = s.length()-1;

        while(i <= j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
        }
        // we did
        return new String(arr);
    }
//----------------------------------------------------------------------------------------------------------------------------
    ///Palindrome:(Methode 1)
    public static boolean isPalindrome(String s) {

        int i = 0 ;
        int j = s.length()-1;

        while( i <= j){

            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
//----------------------------------------------------------------------------------------------------------------------------
    /// Character Frequency:
}
