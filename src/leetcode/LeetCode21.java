package leetcode;

import algorithm.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode last = null;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            ListNode node = null;
            if (val1 <= val2) {
                node = new ListNode(val1);
                list1 = list1.next;
            } else {
                node = new ListNode(val2);
                list2 = list2.next;
            }

            if (last == null) {
                last = node;
                head = last;
            } else {
                last.next = node;
                last = last.next;
            }
        }
        last.next = list1 == null ? list2 : list1;
        return head;
    }

}
