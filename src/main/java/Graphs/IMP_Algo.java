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

    /// Cheapest Flight within k:
    // Create Graph for Flights
    public static void createGraphFlight(int flights[][], ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int sc = flights[i][0];
            int des = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(sc, des, wt);
            graph[sc].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graphflight[] = new ArrayList[n];
        createGraphFlight(flights, graphflight);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // Use continue (NOT break), so other valid paths in queue are processed
            if (curr.stops > k) {
                continue;
            }

            for (int i = 0; i < graphflight[curr.v].size(); i++) {
                Edge e = graphflight[curr.v].get(i);
                int v = e.dest;
                int wt = e.wt;

                // Compare with curr.cost instead of dist[u]
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }

    }
//---------------------------------------------------------------------------------------------------------------------------
    public static void main(String args[]) {

        /// Dijkstra Algo:-
//        int V = 6;
//        ArrayList<Edge> graph[] = new ArrayList[V];
//        createGraph(graph);
//        int src = 0;
//        dijkstra(graph, src);//0 2 3 8 6 9
//
//        /// Bellman Ford:-
//        int Vbell = 6;
//        ArrayList<Edge> graphbell[] = new ArrayList[Vbell];
//        createGraphBell(graphbell);
//        BellmanFord(graphbell , 0);//0 2 -2 0 4
//
//        /// Prims Algo:-
//        int Vprim = 4 ;
//        ArrayList<Edge> graphprim[] = new ArrayList[Vprim];
//        createGraphPrim(graphprim);
//        primAlgo(graphprim); //55

        /// Cheapest Flight within K:
        int n = 4;
        int flights[][] = {{0, 1, 100}, {1, 2, 200}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;
        int ans = cheapestFlight(n, flights, src, dst, k);
        System.out.println("Cheapest Flight Cost: " + ans);
    }
//---------------------------------------------------------------------------------------------------------------------------
}