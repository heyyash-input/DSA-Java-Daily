package HashingDone;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

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

        //Iterate:-
        //map.entrySet():-
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for (String k : keys){

            System.out.println("key=" + k + ", value" + map.get(k));
        }


        /// Linked HashMap:-
        LinkedHashMap<String , Integer> Hmp = new LinkedHashMap<>();
        Hmp.put("India" , 100);
        Hmp.put("US" , 240);
        Hmp.put("Japan" , 780);
        Hmp.put("China" , 670);
        System.out.println(Hmp);

    }


}
