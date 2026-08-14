package Graphs;

import java.util.*;

public class IMP_Algo {
//---------------------------------------------------------------------------------------------------------------------------
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------

    // graph for Djkstra:
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
//---------------------------------------------------------------------------------------------------------------------------

    /// Graph for Bellman Ford Algo:-
    //Edge[]
    static void createGraphBell(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }
//--------------------------------------------------------------------------------------------------------------------------

     /// Graph for Prim's Algo:-
     static void createGraphPrim(ArrayList<Edge> graph[]) {
         for (int i = 0; i < graph.length; i++) {
             graph[i] = new ArrayList<>();
         }
         graph[0].add(new Edge(0, 1, 10));
         graph[0].add(new Edge(0, 2, 15));
         graph[0].add(new Edge(0, 3, 30));

         graph[1].add(new Edge(1, 0, 10));
         graph[1].add(new Edge(1, 3, 40));

         graph[2].add(new Edge(2, 0, 15));
         graph[2].add(new Edge(2, 3, 50));

         graph[3].add(new Edge(3, 1, 40));
         graph[3].add(new Edge(3, 2, 50));
     }

//---------------------------------------------------------------------------------------------------------------------------

    /// Bellman Ford Algo:-
    public static void BellmanFord(ArrayList<Edge>[] graph , int src){
        int dist[] = new int [graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        //O(V X E):-
        //algo :
        int V = graph.length;
        for (int i = 0; i < V - 1; i++) {
            // edges - O(E): bacause bellow loops takes edge time
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                        int u = e.src;
                        int v = e.dest;
                        int wt = e.wt;
                        // special condition for Bellman ford algotihm:
                        if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                            dist[v] = dist[u] + wt;
                        }
                }
            }
        }
        // print :
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
//---------------------------------------------------------------------------------------------------------------------------

    /// Prim's Algo:- MST (Minimum spanning Tree)
    public static void primAlgo(ArrayList<Edge> [] graph ){
        boolean vis [] = new boolean[graph.length];
        PriorityQueue<pair1> pq = new PriorityQueue<>();

        pq.add(new pair1(0,0));

        int finalCost = 0 ; //MST total min weight:

        while(!pq.isEmpty()){
            pair1 curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i <graph[curr.v].size() ; i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new pair1(e.dest , e.wt));
                }
            }
        }
        System.out.println(finalCost+" ");
    }

    static class pair1 implements Comparable<pair1> {
        int v;
        int cost;

        public pair1(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(pair1 p2) {
            return this.cost - p2.cost;   // Ascending order (Min-Heap)
        }
    }

//---------------------------------------------------------------------------------------------------------------------------

    /// Dijkstra Algo:- O((V + E) \log V)
    // Pair class implementing Comparable for PriorityQueue sorting
    static class pair implements Comparable<pair> {
        int n;
        int path;

        public pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(pair p2) {
            return this.path - p2.path; // Min-Heap based on path distance
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length]; // dist[i] -> src to i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src, 0));

        while (!pq.isEmpty()) {
            pair curr = pq.remove();

            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation step
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new pair(v, dist[v])); // Push updated path to PQ
                    }
                }
            }
        }
        // Print shortest distances from src
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

//---------------------------------------------------------------------------------------------------------------------------
    public static void main(String args[]) {

        /// Dijkstra Algo:-
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src);//0 2 3 8 6 9

        /// Bellman Ford:-
        int Vbell = 6;
        ArrayList<Edge> graphbell[] = new ArrayList[Vbell];
        createGraphBell(graphbell);
        BellmanFord(graphbell , 0);//0 2 -2 0 4

        /// Prims Algo:-
        int Vprim = 4 ;
        ArrayList<Edge> graphprim[] = new ArrayList[Vprim];
        createGraphPrim(graphprim);
        primAlgo(graphprim); //55
    }
//---------------------------------------------------------------------------------------------------------------------------
}