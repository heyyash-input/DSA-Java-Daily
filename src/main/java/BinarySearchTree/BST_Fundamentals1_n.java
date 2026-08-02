package BinarySearchTree;

import java.util.ArrayList;

public class BST_Fundamentals1_n {

//----------------------------------------------------------------------------------------------------------------
    static class Node {
         int data ;
         Node left ;
         Node right ;

         Node(int data ){
             this.data = data;
         }
    }

//----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

//        /// Insert:-
//        int values [] = {8 ,5 , 3 , 1 ,4 ,6 ,10 ,11 ,14};
//        Node root = null ;
//
//        for (int i = 0; i < values.length; i++) {
//            root = insert(root , values[i]);
//        }
//        inorder(root);
//        System.out.println();
//
//        /// Search:-
//        if(search(root,1)){
//            System.out.println("Found!");
//        }else{
//            System.out.println("Not Found!");
//        }
//
//        /// Delete:-
//        root = delete(root ,1 );
//        System.out.println();
//        inorder(root);

//        /// Print in range:-
//       printRange(root , 5 , 12); // output:- {5,6,8,10,11 }
//
//        ///Root to leaf path:-
//        printRoot2Leaf(root , new ArrayList<>());
//
//        /// Valid BST:-
//       if( isValidBST(root , null , null)){
//           System.out.println("Valid");
//        }else{
//           System.out.println("not Valid");
//       }

       ///Mirror BST:-
        /*
                    8
                   / \
                  5   10
                 / \    \
                3   6    11
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        // to get the value create new variable root
        // then call preorder funtion to traverse each and every ndoe then print:-
        System.out.println(mirrorBST(root).data);

        /*
         * MIRROR BST (Swapped Left & Right children at every level):
         *          8
         *        /   \
         *       10    5
         *      /     / \
         *     11    6   3
         */
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print("-> " + root.data);
        inorder(root.right);


    }
//----------------------------------------------------------------------------------------------------------------

    /// Insert in BST :-
    public static Node  insert (Node root , int val ) {
        // if root is null it means add it as a parent Node then
        // recursively check for comaprison value
        if (root == null ){
            root = new Node(val);
            return root ;
        }

        if(root.data > val){
            // left subtree
            root.left = insert(root.left , val );
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root ;
    }
//----------------------------------------------------------------------------------------------------------------

    /// Searching in BST :-
    public static boolean search (Node root , int key){

        if(root == null){
            return false ;
        }

        if(root.data == key){
            return true ;
        }

        if(root.data > key ){
            // left subtree
            return search(root.left , key );
        }else{
            // right subtree
            return search(root.right, key);
        }
    }
//----------------------------------------------------------------------------------------------------------------

    /// Delete Node:-
    public static Node delete (Node root , int  val ) {
        if(root.data < val){
            root.right = delete(root.right , val );
        } else if (root.data > val) {
            root.left = delete(root.left , val );
        } else {

            //Case 1:-
            if(root.left == null && root.right == null ){
                return null ; // Garbage collector comes and clears
            }

            //Case 2:-
            if(root.left == null ){
                return root.right ;
            } else if (root.right == null ) {
                return root.left;
            }

            //Case 3:-
            Node IS = findInorderSuccessor(root.right) ;
            root.data = IS.data;
            root.right = delete(root.right , IS.data);

        }
        return root ;
    }

    public static Node findInorderSuccessor(Node root ){
        while (root.left != null ){
            root = root.right;
        }
        return root;
    }

//---------------------------------------------------------------------------------------------------------------

    /// Print in Range:-
    public static void printRange(Node root , int k1 , int k2 ) {

        //base case:-
        if (root == null) {
            return;
        }

        //case 3 :- compare in range for every node
        if (root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printRange(root.right, k1, k2);
        }

        //case 1 :- if greater
        else if (root.data >= k2) {
            printRange(root.right, k1, k2);
        }

        //case 2 :- if less than
        else {
            printRange(root.left, k1, k2);
        }
    }

//---------------------------------------------------------------------------------------------------------------

    ///Root to leaf Paths:-
    public static void printPath (ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+ " -> " );
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root , ArrayList<Integer> path){

        if(root == null){
            return;
        }

        //Add every root data first:
        path.add(root.data);

        //Then check for base case:
        if(root.left == null && root.right == null){
            printPath(path);
        }

        //got for left data then right
        printRoot2Leaf(root.left,path);
        printRoot2Leaf(root.right,path);

        //backtrack from last
        path.remove(path.size()-1);
    }

//--------------------------------------------------------------------------------------------------------------

    /// Valid Bs
    public static boolean isValidBST(Node root , Node min , Node max){
        if(root == null ){
            return true ;
        }

        if(min!= null && root.data <= min.data){
            return false;
        }else if (max != null && root.data >= max.data){
            return true;
        }

        return isValidBST(root.left , min ,root)  && isValidBST(root.right , root , max);
    }

//----------------------------------------------------------------------------------------------------------------

    /// mirror BST:-
    public static Node mirrorBST(Node root  ){

        if(root == null){
            return null ;
        }

       Node leftSubtree = mirrorBST(root.left);
       Node rightSubtree =  mirrorBST(root.right);

       // copy all the data in left to right so vice versa:-
       root.left = rightSubtree;
       root.right = leftSubtree ;

       return root ;
    }
//--------------------------------------------------------------------------------------------------------------

    ///
}
