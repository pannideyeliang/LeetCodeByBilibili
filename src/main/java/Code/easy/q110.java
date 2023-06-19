package Code.easy;

public class q110 {
    //    110. 平衡二叉树
    public static void main(String[] args) {

    }
}


class Solution110 {

    //    实际上就是对每个节点的左右子树深度进行判断，递归判断
//    自己写的
//    狗屎一样，能过但是效率很低，这是一种自顶向下的算法
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else if (Math.abs(isBalancedDeep(root.left) -
                isBalancedDeep(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int isBalancedDeep(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + isBalancedDeep(root.left), 1 + isBalancedDeep(root.right));
    }

//    我们也可以参考大佬代码，自底向上进行剪枝
    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}