package Code.easy2;

public class q530 {
    //    530. 二叉搜索树的最小绝对差
    public static void main(String[] args) {

    }
}

class Solution530 {
    //注意二叉搜索树的中序遍历是有序的，所以可以采用中序遍历
    int min = Integer.MAX_VALUE;
    int tmp = -1;

    public int getMinimumDifference(TreeNode root) {
        Dfs(root);
        return min;
    }

    public void Dfs(TreeNode root) {
        if (root == null) return;
        Dfs(root.left);
        if (tmp == -1) {
            tmp = root.val;
        } else {
            min = Math.min(min, root.val - tmp);
            tmp = root.val;
        }
        Dfs(root.right);
    }
}
