package Code.easy1;

public class q404 {
    //    404. 左叶子之和
    public static void main(String[] args) {

    }
}


class Solution404 {
    //    很显然嘛，使用递归
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return res;
        }
        if (root.left != null&&root.left.left == null&&root.left.right == null) {
            res += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return res;
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