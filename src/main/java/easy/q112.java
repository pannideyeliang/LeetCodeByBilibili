package easy;

public class q112 {
    //    112. 路径总和
    public static void main(String[] args) {

    }
}


class Solution112 {
    //    简单的思想，我们只需要递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}