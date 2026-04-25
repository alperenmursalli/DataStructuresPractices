//Given a sorted (increasing order) array with unique integer elements, write an 
//algorithm to create a binary search tree with minimal height.


class MinimalTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode createMinimalBST(int[] arr) {
        return build(arr, 0, arr.length - 1);
    }

    TreeNode build(int[] arr, int left, int right){
        if (left > right) return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = build(arr, left, mid - 1);
        root.right = build(arr, mid + 1, right);

        return root;
    }

    void printInOrder(TreeNode root){
        if (root == null) return;

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        MinimalTree obj = new MinimalTree();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        TreeNode root = obj.createMinimalBST(arr);

        System.out.println("Inorder traversal:");
        obj.printInOrder(root);
    }
}