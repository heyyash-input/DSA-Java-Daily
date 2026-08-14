# Graph Algorithms & Pattern Recognition Cheat Sheet

A comprehensive reference guide for identifying, structuring, and implementing graph algorithms in Java for Data Structures & Algorithms (DSA) interviews and competitive programming.

---

## 1. Quick Pattern Recognition Framework

| Problem Keywords / Phrases | Problem Intent | Algorithm / Tool to Use | Classic LeetCode Problems |
| :--- | :--- | :--- | :--- |
| *"Number of connected groups"*, *"Number of islands"*, *"Count provinces"*, *"Is reachable"* | Counting isolated clusters / Traversing entire component | **DFS** / **BFS** / **Disjoint Set Union (DSU)** | • 200. Number of Islands<br>• 547. Number of Provinces |
| *"Shortest path in unweighted graph"*, *"Minimum steps/moves"*, *"Level by level"*, *"Spreading over time"* | Finding shortest path with uniform edge costs ($wt = 1$) | **BFS (Queue-based)** | • 994. Rotting Oranges<br>• 127. Word Ladder |
| *"Prerequisites"*, *"Ordering / Sequence of tasks"*, *"Compilation order"*, *"Dependency resolution"* | Finding a valid linear topological ordering in a DAG | **Topological Sort** (Kahn's BFS / DFS + Stack) | • 207. Course Schedule<br>• 210. Course Schedule II |
| *"Detect deadlock"*, *"Circular dependency"*, *"Loop in directed/undirected graph"* | Checking for cycle presence | **DFS + Recursion Stack** (Directed)<br>**DFS + Parent Tracking** (Undirected) | • 207. Course Schedule<br>• 684. Redundant Connection |
| *"Shortest path with positive weights"*, *"Cheapest route"*, *"Minimum network delay time"* | Single-source shortest path with non-negative weights | **Dijkstra’s Algorithm** (Min-PriorityQueue) | • 743. Network Delay Time<br>• 787. Cheapest Flights Within K Stops |
| *"Negative weight edges"*, *"Detect negative weight cycle"* | Shortest path with negative edge weights | **Bellman-Ford Algorithm** | • Currency Arbitrage Problems |
| *"Connect all points with minimum total cost"*, *"Spanning tree without cycles"* | Connecting all $V$ nodes using $(V-1)$ edges at minimum cost | **Prim’s Algorithm** / **Kruskal’s Algorithm (DSU)** | • 1584. Min Cost to Connect All Points |
| *"Divide into 2 teams"*, *"Color with 2 colors without neighbor collision"* | Checking 2-colorability (no odd-length cycles) | **Bipartite Graph Check** (BFS / DFS with 0/1 coloring) | • 785. Is Graph Bipartite? |

---

## 2. Universal Adjacency List Boilerplate (Java)

```java
import java.util.*;

public class GraphTemplates {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
            this.wt = 1;
        }

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Convert Edge Array (e.g., int[][] edges) to Adjacency List
    public static ArrayList<Edge>[] buildGraph(int V, int[][] edges, boolean isDirected) {
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = (edge.length > 2) ? edge[2] : 1;

            graph[u].add(new Edge(u, v, wt));
            if (!isDirected) {
                graph[v].add(new Edge(v, u, wt));
            }
        }
        return graph;
    }
}

## Cycle Detection in Directed Graph (DFS)  
Time Complexity: O(V + E)
Space Complexity: O(V)

public static boolean hasDirectedCycle(ArrayList<Edge>[] graph) {
    int V = graph.length;
    boolean[] vis = new boolean[V];
    boolean[] recStack = new boolean[V];

    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            if (directedCycleUtil(graph, i, vis, recStack)) {
                return true;
            }
        }
    }
    return false;
}

private static boolean directedCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] recStack) {
    vis[curr] = true;
    recStack[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);

        if (recStack[e.dest]) {
            return true; // Cycle detected
        } else if (!vis[e.dest] && directedCycleUtil(graph, e.dest, vis, recStack)) {
            return true;
        }
    }

    recStack[curr] = false; // Backtrack
    return false;
}

#Topological Sort (Kahn's Algorithm - BFS)
Time Complexity: O(V + E)
Space Complexity: O(V)

public static List<Integer> topoSortBFS(ArrayList<Edge>[] graph) {
    int V = graph.length;
    int[] inDegree = new int[V];

    // 1. Calculate in-degrees
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            inDegree[e.dest]++;
        }
    }

    // 2. Add 0 in-degree nodes to queue
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < V; i++) {
        if (inDegree[i] == 0) {
            q.add(i);
        }
    }

    List<Integer> order = new ArrayList<>();

    // 3. Process BFS
    while (!q.isEmpty()) {
        int curr = q.poll();
        order.add(curr);

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            inDegree[e.dest]--;
            if (inDegree[e.dest] == 0) {
                q.add(e.dest);
            }
        }
    }

    // If order size != V, graph contains a cycle
    return order;
}

#Dijkstra's Shortest Path Algorithm
Time Complexity: O((V + E) \log V) 
Space Complexity: O(V)

static class Pair implements Comparable<Pair> {
    int node;
    int dist;

    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair other) {
        return this.dist - other.dist; // Min-Heap
    }
}

public static int[] dijkstra(ArrayList<Edge>[] graph, int src) {
    int V = graph.length;
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    boolean[] vis = new boolean[V];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(src, 0));

    while (!pq.isEmpty()) {
        Pair curr = pq.poll();

        if (!vis[curr.node]) {
            vis[curr.node] = true;

            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
    }
    return dist;
}

#Bellman-Ford Algorithm (Handles Negative Weights)
Time Complexity:O(V \times E)
Space Complexity: O(V)

public static int[] bellmanFord(ArrayList<Edge>[] graph, int src) {
    int V = graph.length;
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    // Relax all edges V - 1 times
    for (int count = 0; count < V - 1; count++) {
        for (int u = 0; u < V; u++) {
            for (int j = 0; j < graph[u].size(); j++) {
                Edge e = graph[u].get(j);
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
    }
    return dist;
}

#Prim's Algorithm (Minimum Spanning Tree - MST)
Time Complexity:O(E \log V) 
Space Complexity: O(V)

static class MSTPair implements Comparable<MSTPair> {
    int v;
    int cost;

    public MSTPair(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(MSTPair other) {
        return this.cost - other.cost;
    }
}

public static int primsMST(ArrayList<Edge>[] graph) {
    int V = graph.length;
    boolean[] vis = new boolean[V];
    PriorityQueue<MSTPair> pq = new PriorityQueue<>();
    pq.add(new MSTPair(0, 0));

    int totalMstCost = 0;

    while (!pq.isEmpty()) {
        MSTPair curr = pq.poll();

        if (!vis[curr.v]) {
            vis[curr.v] = true;
            totalMstCost += curr.cost;

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                if (!vis[e.dest]) {
                    pq.add(new MSTPair(e.dest, e.wt));
                }
            }
        }
    }
    return totalMstCost;
}

Disjoint Set Union (DSU / Union-Find)
Time Complexity: approx O(1) per operation with path compression and rank optimization
Space Complexity: O(V)

class DisjointSet {
    int[] parent;
    int[] rank;
    int components;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); // Path compression
    }

    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return false; // Already in same component (cycle detected)
        }

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }

        components--;
        return true;
    }
}