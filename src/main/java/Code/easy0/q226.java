package Code.easy0;

public class q226 {
    //    226. 翻转二叉树
    public static void main(String[] args) {

    }
}


class Solution {
    //    简单递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}