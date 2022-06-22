package leetcode;

import algorithm.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
public class LeetCode234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(2);
        // head.next.next.next = new ListNode(1);
        // head.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next = new ListNode(3);
        // head.next.next.next.next.next.next = new ListNode(2);
        // head.next.next.next.next.next.next.next = new ListNode(2);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseSlow = reverseList(slow);
        while (head != null && reverseSlow != null) {
            if (head.val != reverseSlow.val) {
                return false;
            }
            head = head.next;
            reverseSlow = reverseSlow.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
