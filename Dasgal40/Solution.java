package IsThisABinarySearchTree;

public class Solution {

    public static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Helper function to recursively verify BST properties
    private static boolean isBST(Node node, int min, int max) {
        if (node == null) return true;

        // The current node must be within (min, max)
        if (node.data <= min || node.data >= max) return false;

        // Recursively validate left and right subtrees
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }
}