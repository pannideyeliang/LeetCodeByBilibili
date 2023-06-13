package easy;

public class q108 {
    //    108. 将有序数组转换为二叉搜索树
    public static void main(String[] args) {

    }
}


class Solution108 {
    //    我们可以采用递归的方式进行创建，每次都选中间的节点
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }


    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
