package Code.easy;

import java.util.ArrayList;
import java.util.List;

public class q94 {
    //94. 二叉树的中序遍历
    public static void main(String[] args) {

    }
}

class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
//        直接套用题目的公式模板既可，中序遍历，左中右
//        这里需要注意的是，递归进行传值的时候，要确保使用的是
//        同一个变量，在递归过程中不断创建新的变量是没有效果的
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }


    public List<Integer> inorder(TreeNode root, List<Integer> res) {
        if (root == null) return null;
        if (root.left != null) {
            inorder(root.left,res);
        }
        res.add(root.val);
        if (root.right != null) {
            inorder(root.right,res);
        }
        return res;
    }
}

// * Definition for a binary tree node.
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
