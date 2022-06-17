package leetcode;

import algorithm.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * https://leetcode.cn/problems/symmetric-tree/
 */
public class LeetCode101 {

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode h1, TreeNode h2) {
        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }
        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
    }

}
