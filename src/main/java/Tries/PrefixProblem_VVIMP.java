package Tries;

public class PrefixProblem_VVIMP {

    /**
     * Node structure representing each character in the Trie.
     */
    public static class Node {
        // Array to store references to child nodes (26 for lowercase English letters 'a' through 'z')
        Node children[] = new Node[26];

        // Flag to mark if a word ends at this node
        boolean eow = false;

        // Tracks how many words pass through this specific character node
        int freq;

        Node() {
            // Initialize all child node pointers to null
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            // Frequency starts at 1 when a character node is newly created
            freq = 1;
        }
    }

    // Root node of the Trie (serves as the entry point)
    public static Node root = new Node();

    /**
     * Inserts a word into the Trie while tracking prefix frequencies.
     *
     * @param word The string to be inserted into the Trie
     */
    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            // Map character 'a'-'z' to an array index 0-25
            int idx = word.charAt(level) - 'a';

            // Case 1: If child node doesn't exist, create it (freq automatically set to 1)
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            // Case 2: If node already exists, increment freq (indicates another word shares this prefix)
            else {
                curr.children[idx].freq++;
            }

            // Move the current pointer to the child node
            curr = curr.children[idx];
        }

        // Mark the end of the word after processing all characters
        curr.eow = true;
    }

    /**
     * Recursively traverses the Trie using DFS to find and print
     * the shortest unique prefix for every word.
     *
     * @param curr The current Node being visited
     * @param ans  The accumulated prefix string constructed so far
     */
    public static void findPrefix(Node curr, String ans) {
        // Base Case 1: Safety check for null nodes
        if (curr == null) {
            return;
        }

        // Base Case 2: Unique prefix found!
        // If freq == 1, only 1 word in the entire dataset passes through this path,
        // making 'ans' the shortest unique prefix for that word.
        if (curr.freq == 1) {
            System.out.println(ans);
            return; // Stop exploring further down this branch
        }

        // Traverse through all 26 possible child nodes (Depth-First Search)
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                // Recurse down to child node while appending the corresponding character to 'ans'
                findPrefix(curr.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};

        // Step 1: Build the Trie by inserting all words
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        // Step 2: Assign -1 to root frequency so it doesn't trigger the (freq == 1) condition
        root.freq = -1;

        // Step 3: Run DFS to discover and print shortest unique prefixes
        findPrefix(root, "");
    }
}