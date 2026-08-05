package HashingDone;

import java.util.HashMap;

public class HashingFund1_n {
    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<>();
        map.put("India" , 100 );
        map.put("New york" , 150);
        map.put("Switzerland" , 200 );
        map.put("Japan" , 250 );

        System.out.println(map);

        //Get - O(1):
        int pop = map.get("India");
        System.out.println(pop);

        //ContainsKey - O(1):
        if(map.containsKey("PAK")){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }

        //Remove O(1):

    }


}
