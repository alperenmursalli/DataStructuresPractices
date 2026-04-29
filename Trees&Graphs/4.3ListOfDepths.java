import java.util.*;

class ListOfDepths {
    class TreeNode {
        public int data;    
        public TreeNode left;  
        public TreeNode right; 

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> levels = new ArrayList<LinkedList<TreeNode>>();

        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();

        if (root != null) {
            currentLevel.add(root);
        }

        while (!currentLevel.isEmpty()){
            levels.add(currentLevel);

            LinkedList<TreeNode> parents = currentLevel;
            currentLevel = new LinkedList<>();

            for (TreeNode node : parents){
                if (node.left!=null){
                    currentLevel.add(node.left);
                }
                if (node.right != null){
                    currentLevel.add(node.right);
                }
            }
        }
        return levels;
    }

    public static void main(String[] args) {
        ListOfDepths obj = new ListOfDepths();

        TreeNode root = obj.new TreeNode(1);
        root.left = obj.new TreeNode(2);
        root.right = obj.new TreeNode(3);
        root.left.left = obj.new TreeNode(4);
        root.left.right = obj.new TreeNode(5);
        root.right.right = obj.new TreeNode(6);

        ArrayList<LinkedList<TreeNode>> levels = obj.createLevelLinkedList(root);

        for (int i = 0; i < levels.size(); i++) {
            System.out.print("Level " + i + ": ");

            for (TreeNode node : levels.get(i)) {
                System.out.print(node.data + " ");
            }

            System.out.println();
        }
    }
}
