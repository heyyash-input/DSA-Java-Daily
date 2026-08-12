package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs_Fund {
//-----------------------------------------------------------------------------------------------------------------------------
    static class Edge{
        int src ;
        int des ;
        int wt;

        public Edge(int src , int des , int wt){
            this.src = src ;
            this.des = des ;
            this.wt = wt ;
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------
    static void createGraph(ArrayList<Edge> graph[]){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // Vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // Vertex 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // Vertex 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // Vertex 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // Vertex 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // Vertex 6
        graph[6].add(new Edge(6, 5, 1));
    }
//-----------------------------------------------------------------------------------------------------------------------------

    /// BFS :-
    public static void bfs(ArrayList<Edge>[] graph  ){
        //O(n)
        // O(V + E ) but for matrix O(V^2)
        Queue<Integer> q =new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // source = 0
        //till queue is not empty:-
        while(!q.isEmpty()){
            // curr is removed one:-
            int curr = q.remove();
            if(!vis[curr]){//visit curr
                //print
                System.out.println(curr+" ");
                // if not then true
                vis[curr] = true;
                //then print whole
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------

    /// DFS:-
    public static void dfs(ArrayList<Edge> [] graph , int curr , boolean vis []){
        //visit
        System.out.println(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e =graph[curr].get(i);
            if(!vis[e.des]){
                dfs(graph , e.des, vis);
            }
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------

    /// HasPath:- O(V + E)
    public static boolean hasPath(ArrayList<Edge> [] graph , int src , int dest , boolean vis []){

        //case 1:-
        if(src == dest ) return true;

        //in starting only mark them as visited:-
        vis[src] = true;

        //case 2:-
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e  = graph[src].get(i);
            // e.dist = neighbour
            if (!vis[e.des] && hasPath(graph , e.des  ,  dest , vis)){
                return true;
            }
        }

        //case 3:-
        return false ;
    }
//-----------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
//        /*
//                        (5)
//                    0 ------ 1
//                           /  \
//                     (1)  /    \  (3)
//                         /      \
//                        2 ------ 3
//                        |   (1)
//                    (2) |
//                        |
//                        4
//       */
//
//        int V = 5 ;
//        //same as:- int arr [] = new arr[V];
//        ArrayList<Edge> [] graph = new ArrayList[V]; // null-> empty arraylist
//
//        for (int i = 0; i < V; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        //0 - vertex
//        graph[0].add(new Edge(0,1,5));
//
//        //1 - vertex
//        graph[1].add(new Edge(1,0,5));
//        graph[1].add(new Edge(1,2,1));
//        graph[1].add(new Edge(1,3,3));
//
//        //2 - vertex
//        graph[2].add(new Edge(2,1,1));
//        graph[2].add(new Edge(2,3,1));
//        graph[2].add(new Edge(2,4,2));
//
//        //3 - vertex
//        graph[3].add(new Edge(3,1,3));
//        graph[3].add(new Edge(3,2,1));
//
//        //4 - vertex
//        graph[4].add(new Edge(4,2,2));
//
//        /// Graph creation:-
//        //2's neighbors:-
//        for (int i = 0; i < graph[2].size(); i++) {
//            Edge e = graph[2].get(i);
//            System.out.println(e.des);
//        }

        /// BFS:-
//        /*
//                    1 --- 3
//                   /      | \
//                  0       |  5 -- 6
//                   \      | /
//                    2 --- 4
//        */
//        int Vbfs = 7 ;
//        ArrayList<Edge> graphBFS[] = new ArrayList[Vbfs];
//        createGraph(graphBFS);
//        bfs(graphBFS); // output :-[ 0 1 3 4 5 6 ]

        /// DFS:-
        /*
                    1 --- 3
                   /      | \
                  0       |  5 -- 6
                   \      | /
                    2 --- 4
        */
        int Vdfs = 7 ;
        ArrayList<Edge> graphDFS[] = new ArrayList[Vdfs];
        createGraph(graphDFS);
        dfs(graphDFS , 0 , new boolean[Vdfs]); // output [0 1 3 4 2 5 6]

        /// Has Path:-
        int Vpath = 7 ;
        ArrayList<Edge> graphPath[] = new ArrayList[Vpath];
        createGraph(graphPath);
        System.out.println(hasPath(graphPath , 0 , 8  , new boolean[Vpath]));
    }
//-----------------------------------------------------------------------------------------------------------------------------
}
