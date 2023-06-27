package Code.easy0;

import java.util.ArrayList;
import java.util.List;

public class q257 {
    //    257. 二叉树的所有路径
    public static void main(String[] args) {

    }
}


class Solution257 {
    //    显然是递归
    ArrayList<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        constructPaths(root, "");
        return res;
    }

    public void constructPaths(TreeNode root, String s) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(s);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                res.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString());
                constructPaths(root.right, pathSB.toString());
            }
        }
    }
}