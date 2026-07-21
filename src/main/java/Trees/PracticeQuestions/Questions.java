package Trees.PracticeQuestions;

import Trees.GettingStarted.TreesFund1_n;

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
                     2     3
                   /   \     \
                 4      5     6
         */

        Node root = new Node (1);
        root.left = new Node (2);
        root.right = new Node (3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.right = new Node (6);

        /// Subtree:-

/**
 *                            2
                            /   \
                            4   5
 */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
//        subRoot.right = new Node(7);
//////////////////////////////////////////////////////////////////

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
}
