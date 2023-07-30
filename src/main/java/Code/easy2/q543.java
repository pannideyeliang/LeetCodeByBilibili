package Code.easy2;

public class q543 {
    //    543. 二叉树的直径
    public static void main(String[] args) {

    }
}

class Solution543 {
    //    寻找最长链路嘛

    // 实际上就是求二叉树左右两个节点的深度之和
//    但是这样实际上是错误的，会缺少不经过根节点的情况
    public int diameterOfBinaryTree(TreeNode root) {
        return deep(root.left) + deep(root.right);
    }

    public int deep(TreeNode root) {
        if (root == null) return 0;
        return Math.max(deep(root.left) + 1, deep(root.right) + 1);
    }

    //    查看大佬代码，实际上是每一个节点都有可能是经过的根节点
    int res = 0;

    public int diameterOfBinaryTree1(TreeNode root) {
        depth(root);
        return res;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        res = Math.max(res, L + R);
        //返回节点深度
        return Math.max(L, R) + 1;
    }


}

