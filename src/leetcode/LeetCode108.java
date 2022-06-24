package leetcode;

import algorithm.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 */
public class LeetCode108 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return buildNode(nums, 0, nums.length - 1);
    }

    public static TreeNode buildNode(int[] nums, int L, int R) {
        if (L == R) {
            return null;
        }
        int mid = L + (R - L) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildNode(nums, L, mid - 1);
        node.right = buildNode(nums, mid + 1, R);
        return node;
    }

}
