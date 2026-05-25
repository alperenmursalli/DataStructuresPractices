//Implement a function to check if a binary tree is a binary search tree.

import java.util.*;


class ValidateBST {

    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data=data;
        }
    }
    boolean checkBST (TreeNode root){
        return validate(root,null, null);


    }

    boolean validate(TreeNode root, Integer min, Integer max){
        if (root==null) return true;
        if (min!=null && root.data<=min ) return false; 
        if (max!=null && root.data>=max) return false;

        return validate(root.left, min, root.data) && 
        validate(root.right, root.data, max);
    }

    public static void main(String[] args) {
        ValidateBST obj = new ValidateBST();

        TreeNode validRoot = obj.new TreeNode(8);
        validRoot.left = obj.new TreeNode(3);
        validRoot.right = obj.new TreeNode(10);
        validRoot.left.left = obj.new TreeNode(1);
        validRoot.left.right = obj.new TreeNode(6);
        validRoot.left.right.left = obj.new TreeNode(4);
        validRoot.left.right.right = obj.new TreeNode(7);
        validRoot.right.right = obj.new TreeNode(14);
        validRoot.right.right.left = obj.new TreeNode(13);

        TreeNode invalidRoot = obj.new TreeNode(10);
        invalidRoot.left = obj.new TreeNode(5);
        invalidRoot.right = obj.new TreeNode(15);
        invalidRoot.right.left = obj.new TreeNode(6);
        invalidRoot.right.right = obj.new TreeNode(20);

        System.out.println("Valid BST:");
        System.out.println("        8");
        System.out.println("      /   \\");
        System.out.println("     3     10");
        System.out.println("    / \\      \\");
        System.out.println("   1   6      14");
        System.out.println("      / \\    /");
        System.out.println("     4   7  13");
        System.out.println("Result: " + obj.checkBST(validRoot));

        System.out.println();

        System.out.println("Invalid BST:");
        System.out.println("        10");
        System.out.println("       /  \\");
        System.out.println("      5    15");
        System.out.println("          /  \\");
        System.out.println("         6    20");
        System.out.println("Result: " + obj.checkBST(invalidRoot));

        System.out.println();
        System.out.println("Complexity:");
        System.out.println("Time: O(n)");
        System.out.println("Space: O(h)");
    }
    
}
