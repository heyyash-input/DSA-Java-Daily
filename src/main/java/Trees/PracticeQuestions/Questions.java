package Trees.PracticeQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Questions {

    // Core structural node unit representing individual tree components
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        /*              1
                       /  \
                     2      3
                   /   \    /  \
                 4      5  7    6
         */

        Node root = new Node (1);
        root.left = new Node (2);
        root.right = new Node (3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        /// Subtree:-

/**
 *                            2
                            /   \
                            4   5
 */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
//        subRoot.right = new Node(7);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /// Height of a Tree by Nodes:-
        System.out.println(height(root));

        /// Count nodes: -
        System.out.println(countNodes(root));

        ///Sum of nodes:-
        System.out.println(sumNodes(root));

        /// Diameter of tree:-
        System.out.println(diameterTree(root).diam);

        /// Subtree:-
        System.out.println(isSubtree(root , subRoot));

        /// Top View:-
//        System.out.println(topView(root));
        topView(root);

        /// Kth level:-
        kthLevel(root , 1 , 3);

        /// LCA:-
        int n1 = 4, n2 = 6;
        Node lcaNode = lca(root, n1, n2);
        if (lcaNode != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + ": " + lcaNode.data);
        }

        /// (Optimal) LCA :-2
        System.out.println(lca2(root , 4 ,5).data);

        /// Minimum Distance in tree:-
        System.out.println(minDistance(root , 4 ,6));

        ///

    }
//---------------------------------------------------------------------------------------------------------------
    public static int height(Node root){
        if(root == null) return 0 ;

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left , right) + 1 ;

    }
//---------------------------------------------------------------------------------------------------------------
    public static int countNodes(Node root){
        if(root == null) return 0 ;

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1 ;
    }
//---------------------------------------------------------------------------------------------------------------
    public static int sumNodes(Node root){
        if(root == null) return 0 ;

        int left = sumNodes(root.left);
        int right = sumNodes(root.right);
        return left + right + root.data ;
    }
//---------------------------------------------------------------------------------------------------------------

    ///Diameter of Tree:-
    static class Info {
        int diam;
        int ht ;

        public Info (int diam , int ht ){
            this.diam = diam ;
            this.ht = ht ;
        }
    }

    public static Info diameterTree ( Node root){

        if( root == null){
            return  new Info (0 ,0 ) ;
        }

        Info leftInfo = diameterTree(root.left);
        Info rightInfo = diameterTree(root.right);

        int diam = Math.max(Math.max(leftInfo.diam ,  rightInfo.diam ) , leftInfo.ht + leftInfo.ht   + 1 );
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1  ;
        return new Info(diam , ht ) ;
    }
//------------------------------------------------------------------------------------------------------------

    ///Subtree (same structure and same Node):-

        public static boolean isIdentical(Node root , Node subRoot){
            if(root == null && subRoot == null){
                return true ;
        } else if (root == null || subRoot == null || root.data != subRoot.data ) {
                return false;
            }
            //left:-
            if(!isIdentical(root.left , subRoot.left)){
                return false;
            }
            //Right:-
            if(!isIdentical(root.right , subRoot.right)){
                return false;
            }

           return true;
        }

        public static boolean isSubtree(Node root , Node subRoot) {

            if (root == null) {
                return false;
            }
            //true->
            if (root.data == subRoot.data) {
                if(isIdentical(root, subRoot)){
                    return true;
                }

            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        }
//-------------------------------------------------------------------------------------------------------------

    /// Top View:-
    static class Info1{
        Node node ;
        int hd ;

        public Info1 (Node node , int hd){
            this.node = node ;
            this.hd = hd ;
        }
    }

    public static void topView(Node root) {
        if (root == null) return;

        Queue<Info1> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info1(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info1 curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node.data);
                }
                if (curr.node.left != null) {
                    q.add(new Info1(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info1(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        // top view print:-
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }
//-------------------------------------------------------------------------------------------------------------

    ///Kth Level of tree:-
    public static void kthLevel(Node root , int  level , int k ){
        if(root == null ){
            return;
        }

        if(level == k ){
            System.out.print(root.data +" ");
            return;
        }
        kthLevel(root.left , level + 1 , k );
        kthLevel(root.right , level + 1 , k );
    }
//-------------------------------------------------------------------------------------------------------------

    /// Lowest Common Ancestor:-
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1); // Backtrack step
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        // Create paths for storing route:
        ArrayList<Node> p1 = new ArrayList<>();
        ArrayList<Node> p2 = new ArrayList<>();

        getPath(root, n1, p1);
        getPath(root, n2, p2);


        int i = 0;

        for (; i < p1.size() && i < p2.size(); i++) {
            if (p1.get(i) != p2.get(i)) {
                break;
            }
        }
        // Last matching ancestor is at index (i - 1)
        Node lca = p1.get(i - 1);
        return lca;
    }
//-------------------------------------------------------------------------------------------------------------

    //LCA mehode:-2
    public static Node  lca2(Node root ,int n1 , int n2  ){
//            if (root == null ){
//                return null ;
//            }

        if( root == null  ||  root.data == n1 || root.data == n2){
            return root ;
        }

        lca2(root.left , n1, n2 );
        Node rightLca = lca2(root.right , n1 , n2 );
        Node leftLca = lca2(root.left , n1 , n2 );

        //leftLca
        if (rightLca == null){
            return leftLca;
        }
        //Right
        if(leftLca == null ){
            return rightLca;
        }

        return root ;
    }
//--------------------------------------------------------------------------------------------------------------

    /// Minimun Distance in tree:-
    public static int  lcaDist(Node root , int n){
        if(root == null ){
            return -1 ;
        }

        if(root.data == n){
            return 0 ;
        }

        int leftDist = lcaDist(root.left , n);
        int rightDist = lcaDist(root.right , n);

        if(leftDist == -1 && rightDist == -1 ){
            return -1 ;
        } else if (leftDist == -1) {
            return rightDist + 1;
        }else{
            return leftDist + 1 ;
        }
    }

    public static int minDistance(Node root , int n1 , int n2){

        Node lca = lca2(root , n1 , n2 );
        int  dist1 = lcaDist(root , n1 );
        int  dist2 = lcaDist(root , n2 );

        return dist1 + dist2 ;

    }
//-------------------------------------------------------------------------------------------------------------
}
