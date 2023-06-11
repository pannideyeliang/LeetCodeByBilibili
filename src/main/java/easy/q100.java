package easy;

import java.awt.image.renderable.RenderableImage;

public class q100 {
    //100. 相同的树
    public static void main(String[] args) {

    }
}


class Solution100 {

    //    套用树的模板
    public boolean isSameTree(TreeNode p, TreeNode q) {
//        先判断当前节点是否一致，然后递归的交给下一个判断节点
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right);
        }

    }
}