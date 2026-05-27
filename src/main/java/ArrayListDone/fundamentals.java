package ArrayListDone;

import java.util.ArrayList;

public class fundamentals {

    public static void main(String[] args) {
        //Declaration:-
        // Java Collection framework part:-
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list1 =new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();
        //operations:-

        // ADD O (1)
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);
        System.out.println(list);

        //GET O (1)
//        list.get(1); // pass the index value

        //Remove O (n) :-we will search then remove
//        list.remove(3);

        //Set O (n) - find and then change
//        list.set(1,10);

        //Contains element  O(n)
//        list.contains(3);

        //List size
//        list.size();

//---------------------------------------------------------------------------------------------------------------
        //Print reverse of arrayList
        for (int i = list.size()-1; i >= 0 ; i--) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

//---------------------------------------------------------------------------------------------------------------

        //Find maximum:-
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
           if (  max < list.get(i) ){
               max = list.get(i);
           }
        }
        System.out.println("max element " + max);

// --------------------------------------------------------------------------------------------------------------

        //Swap 2 numbers:-

    }
}
