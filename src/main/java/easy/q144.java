package easy;

import java.util.ArrayList;
import java.util.List;

public class q144 {

    //    144. 二叉树的前序遍历
    public static void main(String[] args) {

    }
}


class Solution144 {

    List<Integer> res = new ArrayList<>();

    //    常规递归
    public List<Integer> preorderTraversal(TreeNode root) {
//        可以看到的是一个节点直接返回，所以要额外创建一个变量，而不可以在函数里面创建
        if (root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }


}