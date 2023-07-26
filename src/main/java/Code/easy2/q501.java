package Code.easy2;

import java.util.ArrayList;

public class q501 {
    //    501. 二叉搜索树中的众数
    public static void main(String[] args) {

    }
}


class Solution501 {

    //    注意到二叉树的中序遍历是非递减的，且相等的数一定是连续的
//    但是注意需要处理的是如下：如果 count = max,则加入到res里面，
//    如果更新了max，则前面的结果集都要清空掉
    int count = 0, maxCount = 0, base = 0;
    ArrayList<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        midTraverse(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    //    中序遍历
    public void midTraverse(TreeNode root) {
        if (root == null) return;
        midTraverse(root.left);
//       中间数据进行统计处理
        if (root.val == base) {
            count++;
        } else {
            count = 1;
            base = root.val;
        }
        if (count == maxCount) {
            res.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(base);
        }
        midTraverse(root.right);
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
