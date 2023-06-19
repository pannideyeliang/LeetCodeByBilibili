package Code.easy;

import java.util.ArrayList;
import java.util.List;

public class q145 {
    //    145. 二叉树的后序遍历
    public static void main(String[] args) {

    }
}


class Solution145 {
    List<Integer> res = new ArrayList<>();

    //  递归
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}