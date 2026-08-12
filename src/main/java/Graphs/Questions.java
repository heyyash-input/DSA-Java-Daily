package Graphs;
import java.lang.reflect.Array;
import java.security.interfaces.EdECKey;
import java.util.*;
public class Questions {
//------------------------------------------------------------------------------------------------------------------------------
    static class Edge{
        int src ;
        int des;

        public Edge(int src , int dest){
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

//-----------------------------------------------------------------------------------------------------------------------------

     /// Graph for Biparitite:-
    static void createGraphbi(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }
//----------------------------------------------------------------------------------------------------------------------------

    ///Topological Sorting Graph creation:-
    static void createGraphTopo(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

//-----------------------------------------------------------------------------------------------------------------------------
    /// Directed Cycle :-
    static void createGraphDiCycle(ArrayList<Edge> graph[]) { //FALSE - no cycle
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

//------------------------------------------------------------------------------------------------------------------------------

    /// Cycle detection:- O(V + E):
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

    /// Biparitite graph:- using D FS: O(V+E)
    public static boolean isBipartite(ArrayList<Edge>[] graph){

        //initialise every colour with -1 at the beginnig:
        int col[] = new int [graph.length];

        for (int i = 0; i < graph.length; i++) {
            col[i] = -1 ;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if(col[i] == -1){
                // BFS when colour is not assign
                q.add(i);
                col[i] = 0 ; //yellow
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for (int j = 0; j < graph.length; j++) {
                        Edge e = graph[curr].get(j); // neighbour - e.des:

                        if(col[e.des] == -1){
                            //if next col is 0 then make it 1 :
                            int nextCol  = col[curr] == 0 ? 1 : 0 ;
                            //then change colour , there should be only opposite colour:
                            col[e.des] = nextCol;
                            //and then add next node to queue:
                            q.add(e.des);
                        }
                        //case 2: we got same colour as a neighbours:
                        else if (col[e.des] == col[curr]) {
                            return false;
                        }
                        // case 3: do nothing just continue
                    }
                }
            }
        }
        return true ;
    }
//------------------------------------------------------------------------------------------------------------------------------

    /// Directed Cycle using DFS:-
    public static boolean dirCycle(ArrayList<Edge> [] graph ){
        boolean vis [] = new boolean[graph.length];
        boolean stack [] = new boolean [graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i] ){
                if(dirCycleUtil(graph , i , vis , stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dirCycleUtil(ArrayList<Edge> [] graph , int curr , boolean vis[] , boolean stack []){
        // marke every one true once visited:
        vis[curr] = true ;
        stack[curr] = true ;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(stack[e.des]){ // cycle
                return true;
            }
            // if unvisited
            else if (!vis[e.des] && dirCycleUtil(graph , curr , vis , stack)) {
                return true;
            }
        }
        // false because when we are going backward it should return false which was true:
        stack[curr] = false ;
        return false;
    }
//-----------------------------------------------------------------------------------------------------------------------------

    /// Topological Sorting:-
    public static void topoSort(ArrayList<Edge> [] graph ){
        boolean vis [] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topoSortUtil(graph , i , vis , s );
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    public static void topoSortUtil (ArrayList<Edge> graph[] , int curr , boolean vis [] , Stack<Integer> s){
        vis[curr] = true;

         for (int i =0 ; i < graph[curr].size() ; i ++){
             Edge e = graph[curr].get(i);
             if(!vis[e.des]){
                topoSortUtil(graph , e.des , vis , s );
             }
         }
        s.push(curr);
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

        /// Biparitite Graph:-
        /// If graph don't have nay cycle it is bipartite graph:
         /*
                0 ------- 2
               /         /
              /         /
             1         4
              \       /
               \     /
                  3
                FALSE
        */
        int Vbi = 5;
        ArrayList<Edge> graphbi[] = new ArrayList[Vbi];
        createGraphbi(graphbi);
        System.out.println(isBipartite(graphbi)); //

        ///Directed Cycle DFS:-
        int Vdi = 4;
        ArrayList<Edge> graphdi[] = new ArrayList[Vdi];
        createGraphDiCycle(graphdi);
        System.out.println(dirCycle(graphdi)); // true

        /// Topological Sorting:-
        int Vtop = 6;
        ArrayList<Edge> graphtop[] = new ArrayList[Vtop];
        createGraphTopo(graphtop);
        topoSort(graphtop);

    }
//------------------------------------------------------------------------------------------------------------------------------
}
