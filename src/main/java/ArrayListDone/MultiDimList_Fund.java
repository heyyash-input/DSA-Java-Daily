package ArrayListDone;

import java.util.ArrayList;

public class MultiDimList_Fund {

    public static void main(String[] args) {
        //Q: store double list 2D:
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        mainList.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        mainList.add(list2);

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.println(currList);
            }
        }

        ArrayList<ArrayList<Integer>> result = arrayList3();
        System.out.println(result);

    }
//----------------------------------------------------------------------------------------------------------------
    //Q) store :- [[1, 2, 3, 4], [2, 4, 6, 8], [3, 6, 9, 12]]
    public static  ArrayList<ArrayList<Integer>> arrayList3 ( ) {

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            list1.add(i*1); // 1 2 3 4 5
            list2.add(i*2); // 2 4 6 8
            list3.add(i*3); // 3 6 9 12 15
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        return mainList;
    }
//----------------------------------------------------------------------------------------------------------------

}
