package Code.easy;

public class q104 {
    //    104. 二叉树的最大深度
    public static void main(String[] args) {

    }
}

class Solution104 {
    //    简单，找到最深的就好了
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
