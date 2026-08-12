package Graphs;
import java.util.*;
public class Questions {
//------------------------------------------------------------------------------------------------------------------------------
    static class Edge{
        int src ;
        int des;

        public Edge(int src , int des){
            this.src = src;
            this.des = des;
        }
    }
//------------------------------------------------------------------------------------------------------------------------------
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
//        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

//        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }
//------------------------------------------------------------------------------------------------------------------------------
    public static boolean detectCycle(ArrayList<Edge>[] graph ){
        boolean vis [] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                // parent will start from -1 as we are starting our node entry from 0:
               if(detectCycleUtil(graph , vis , i , -1)){
                   return true; // cycle exist in one of the part
               }
            }
        }
        return false;
    }
//------------------------------------------------------------------------------------------------------------------------------
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[] , int curr , int par  ){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            //case 3 :-
            Edge e = graph[curr].get(i);
            if(!vis[e.des] ){
                if (detectCycleUtil(graph , vis , e.des , curr)){
                    return true;
                }
            }
            //case 1 :-
            else if (vis[e.des] && e.des != par) {
                return true;
            }
            //case 2 -> do nothing -> conitnue
        }
        return false;
    }

//------------------------------------------------------------------------------------------------------------------------------

    public static void main(String args[]) {
        /*
                0 ------- 3
               / |        |
              /  |        |
             1   |        4
              \  |
               \ |
                 2
        */
        /// Cycle detection:-
        int V = 5 ;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph)); //output true for cycle and false for no detected cycle;


    }
//------------------------------------------------------------------------------------------------------------------------------
}
