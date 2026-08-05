package AVLTrees;

/**
 * AVL TREE IMPLEMENTATION (Self-Balancing BST)
 *
 * Key Concepts:
 * 1. Balance Factor (BF) = Height(Left Subtree) - Height(Right Subtree)
 * 2. Tree is balanced if BF is in range {-1, 0, 1}.
 * 3. Rotations maintain O(log N) operations:
 *    - Left-Left (LL)   -> Single Right Rotation
 *    - Right-Right (RR) -> Single Left Rotation
 *    - Left-Right (LR)  -> Left Rotate Left Child, then Right Rotate Root
 *    - Right-Left (RL)  -> Right Rotate Right Child, then Left Rotate Root
 */
public class AVLFund1_n {
//----------------------------------------------------------------------------------------------------------------------------
    // Core structural node unit
    public static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1; // Leaf nodes start with height 1
        }
    }
//----------------------------------------------------------------------------------------------------------------------------
    public static Node root;

    // Returns node height safely (handles null)
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }
//----------------------------------------------------------------------------------------------------------------------------
    // Calculates Balance Factor of a node
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }
//----------------------------------------------------------------------------------------------------------------------------
    // --- ROTATION OPERATIONS ---

    // Right Rotation (fixes LL imbalance around node y)
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights (child first, then parent)
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // New root of this subtree
    }
//----------------------------------------------------------------------------------------------------------------------------
    // Left Rotation (fixes RR imbalance around node x)
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights (child first, then parent)
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // New root of this subtree
    }
//----------------------------------------------------------------------------------------------------------------------------
    // --- INSERTION LOGIC ---

    public static Node insert(Node root, int key) {
        // 1. Standard BST insertion
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicates not allowed
        }

        // 2. Update height of ancestor node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // 3. Get balance factor to check if node became unbalanced
        int bf = getBalance(root);

        // Case 1: Left Left (LL)
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Case 2: Right Right (RR)
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Case 3: Left Right (LR)
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Case 4: Right Left (RL)
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // Return unchanged node pointer
    }
//----------------------------------------------------------------------------------------------------------------------------
    // Preorder Traversal (Root -> Left -> Right)
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
//----------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
         * Balanced Tree Structure Built:
         *             30
         *            /  \
         *          20    40
         *         /  \     \
         *       10   25    50
         */

        System.out.print("Preorder Traversal of AVL Tree: ");
        preorder(root);
        System.out.println();
    }
//----------------------------------------------------------------------------------------------------------------------------
}