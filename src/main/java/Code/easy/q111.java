package Code.easy;

public class q111 {
    //    111. 二叉树的最小深度
    public static void main(String[] args) {

    }
}


class Solution111 {

    //    这一题显然可以递归自顶向下
//    显然也是自己写的狗屎代码
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 0;
    }

    //    大佬代码，剪枝
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;

    }
}