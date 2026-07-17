package Trees.GettingStarted;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  TREE RECURSION & DFS TRAVERSAL TEMPLATES
 * This module demonstrates how structural recursion navigates a binary tree.
 * By shifting the point at which the 'Root' node is processed relative to its children,
 * we achieve three classic Depth-First Search (DFS) orderings using the system call stack.
 */

public class TreesFund1_n {
//-------------------------------------------------------------------------------------------------------------
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
//-------------------------------------------------------------------------------------------------------------
    static class BinaryTree {
        // Global tracking pointer used to sequentially step through the serialized array
        static int idx = -1;

        /**
         * BUILD TREE PATTERN (Pre-order Construction)
         * Reconstructs a binary tree from a serialized array representation.
         * A value of -1 indicates a null (empty) leaf slot.
         */
        public static Node buildTree(int[] nodes) {
            idx++;
            // Boundary check: halt if we exceed array limits or encounter an empty marker (-1)
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);  // Construct the entire left subtree recursively
            newNode.right = buildTree(nodes); // Construct the entire right subtree recursively
            return newNode;
        }
//-------------------------------------------------------------------------------------------------------------
        /**
         *  PATTERN 1: PRE-ORDER TRAVERSAL (Root ➔ Left ➔ Right)
         * Git Note: Useful for copying or cloning trees, as the root is processed first.
         */
        public static void preorder(Node root) {
            // Base Case: Safely handle leaf boundaries to prevent NullPointerException
            if (root == null) {
                return;
            }

            System.out.print(root.data + " "); // 1. Process/Print the Current Node (Root)
            preorder(root.left);               // 2. Cascade down into the Left Subtree
            preorder(root.right);              // 3. Cascade down into the Right Subtree
        }
//-------------------------------------------------------------------------------------------------------------
        /**
         * PATTERN 2: IN-ORDER TRAVERSAL (Left ➔ Root ➔ Right)
         * Git Note: Critical pattern for Binary Search Trees (BSTs) as it prints keys in sorted order.
         */
        public static void inorder(Node root) {
            // Base Case: Return when hitting an empty pointer boundary
            if (root == null) {
                return;
            }

            inorder(root.left);                // 1. Traverse all the way to the Leftmost child
            System.out.print(root.data + " "); // 2. Process/Print the Current Node (Root) on the way back up
            inorder(root.right);               // 3. Traverse down into the Right Subtree
        }
//-------------------------------------------------------------------------------------------------------------
        /**
         * PATTERN 3: POST-ORDER TRAVERSAL (Left ➔ Right ➔ Root)
         * Git Note: Used for bottom-up calculations (e.g., computing tree height or safe deletion).
         */
        public static void postorder(Node root) {
            // Base Case: Unwind the stack frame when hitting the bottom boundary
            if (root == null) {
                return;
            }

            postorder(root.left);              // 1. Traverse down into the Left Subtree
            postorder(root.right);             // 2. Traverse down into the Right Subtree
            System.out.print(root.data + " "); // 3. Process/Print the Current Node (Root) last
        }
//-------------------------------------------------------------------------------------------------------------

        public static void levelOrder(Node root){

            if (root  == null){
                return;
            }
            Queue<Node> q = new LinkedList<>() ;
            q.add(root) ;
            q.add(null);

            while (!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();

                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else {
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

//-------------------------------------------------------------------------------------------------------------

//        public static void treeHeight(Node root){
//
//        }
//-------------------------------------------------------------------------------------------------------------
    }
//-------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Serialized representation of a binary tree (Depth-First order layout)
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Reset tracking pointer before starting compilation build sequence
        BinaryTree.idx = -1;
        Node root = BinaryTree.buildTree(nodes);

//        System.out.println("--- Tree Traversal Test Execution ---");
//        System.out.println("Root Node: " + root.data + "\n");
//
//        System.out.print("Pre-order  (Root->L->R): ");
//        BinaryTree.preorder(root);
//        System.out.println();
//
//        System.out.print("In-order   (L->Root->R): ");
//        BinaryTree.inorder(root);
//        System.out.println();
//
//        System.out.print("Post-order (L->R->Root): ");
//        BinaryTree.postorder(root);
//        System.out.println();

        BinaryTree.levelOrder(root);
    }
//-------------------------------------------------------------------------------------------------------------
}