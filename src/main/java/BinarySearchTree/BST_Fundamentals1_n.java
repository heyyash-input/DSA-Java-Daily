package BinarySearchTree;

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
    public static void main(String[] args) {

        /// Insert:-
        int values [] = {5 , 1 ,3,4 ,2 ,7};
        Node root = null ;

        for (int i = 0; i < values.length; i++) {
            root = insert(root , values[i]);
        }
        inorder(root);
        System.out.println();

        /// Search:-
        if(search(root,1)){
            System.out.println("Found!");
        }else{
            System.out.println("Not Found!");
        }

        /// Delete:-
        root = delete(root ,1 );
        System.out.println();
        inorder(root);

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

}
