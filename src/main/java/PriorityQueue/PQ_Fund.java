package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ_Fund {

    static class Student implements Comparable<Student>{ // overriding

        String name ;
        int rank ;

        public Student (String name ,int rank){
            this.name = name ;
            this.rank = rank ;
        }

        @Override
        public int compareTo (Student s2){
            return this.rank - s2.rank;
        }

    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3); // O (log n ):
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
    }

    public static void priorityQueue(){


        return ;
    }
}
