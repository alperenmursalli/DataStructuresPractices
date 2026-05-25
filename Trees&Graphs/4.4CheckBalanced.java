//Implement a function to check if a binary tree is
//  balanced. For the purposes of this question, 
// a balanced tree is defined to be a tree such that
//  the heights of the two subtrees of any 
// node never differ by more than one.

import java.util.*;

class CheckBalanced {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data=data;
        }
    }

    int height(TreeNode node){
        if (node == null) return -1;

        return Math.max(height(node.left), height(node.right))+1;

    }

    boolean isBalanced(TreeNode root){

        if (root==null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight-rightHeight)>1){
            return false;
        }        

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        CheckBalanced obj = new CheckBalanced();

        TreeNode balancedRoot = obj.new TreeNode(1);
        balancedRoot.left = obj.new TreeNode(2);
        balancedRoot.right = obj.new TreeNode(3);
        balancedRoot.left.left = obj.new TreeNode(4);
        balancedRoot.left.right = obj.new TreeNode(5);
        balancedRoot.right.right = obj.new TreeNode(6);

        TreeNode unbalancedRoot = obj.new TreeNode(1);
        unbalancedRoot.left = obj.new TreeNode(2);
        unbalancedRoot.left.left = obj.new TreeNode(3);
        unbalancedRoot.left.left.left = obj.new TreeNode(4);

        System.out.println("Balanced tree:");
        System.out.println("        1");
        System.out.println("      /   \\");
        System.out.println("     2     3");
        System.out.println("    / \\     \\");
        System.out.println("   4   5     6");
        System.out.println("Result: " + obj.isBalanced(balancedRoot));

        System.out.println();

        System.out.println("Unbalanced tree:");
        System.out.println("     1");
        System.out.println("    /");
        System.out.println("   2");
        System.out.println("  /");
        System.out.println(" 3");
        System.out.println("/");
        System.out.println("4");
        System.out.println("Result: " + obj.isBalanced(unbalancedRoot));

    }
}
