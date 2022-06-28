package leetcode;

import algorithm.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 
 */
public class LeetCode19 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        removeNthFromEnd(listNode, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode tempHead = head;
        ListNode toDel = null;
        int index = 0;
        while (tempHead != null) {
            if (toDel != null) {
                toDel = toDel.next;
            } else {
                if (index == n) {
                    toDel = head;
                }
            }
            index++;
            tempHead = tempHead.next;
        }
        if (toDel == null) {
            return head.next;
        } else {
            toDel.next = toDel.next.next;
            return head;
        }
    }

}
