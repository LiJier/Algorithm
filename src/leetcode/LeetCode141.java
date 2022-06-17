package leetcode;

import algorithm.ListNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class LeetCode141 {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
        }
        return false;
    }

}
