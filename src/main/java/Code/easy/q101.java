package Code.easy;

public class q101 {
    //    101. 对称二叉树
    public static void main(String[] args) {

    }
}


class Solution101 {

    //    实际上和判断两个二叉树是否相等有异曲同工之妙
    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.right == null && root.left == null) return true;
        if (root.left == null || root.right == null) return false;
        return isSymmetric(root.left, root.right);
    }

    //    递归的调用左右两个子树是否对称，左节点对称右节点
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) {
            return false;
        } else {
            return isSymmetric(left.right, right.left)
                    && isSymmetric(left.left, right.right);
        }
    }
}