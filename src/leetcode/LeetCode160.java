package leetcode;

import java.util.HashSet;
import java.util.Set;

import algorithm.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class LeetCode160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            if (set.contains(headA)) {
                return headA;
            }
            if (set.contains(headB)) {
                return headB;
            }
            set.add(headA);
            set.add(headB);
            headA = headA.next;
            headB = headB.next;
        }
        while (headA != null) {
            if (set.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0, lenB = 0;
        ListNode lA = headA, lB = headB;
        while (lA != null) {
            lenA++;
            lA = lA.next;
        }
        while (lB != null) {
            lenB++;
            lB = lB.next;
        }
        if (lenB > lenA) {
            int lenTemp = lenA;
            lenA = lenB;
            lenB = lenTemp;
            ListNode nodeTemp = headA;
            headA = headB;
            headB = nodeTemp;
        }
        while (headA != null && headB != null) {
            if (lenA == lenB) {
                if (headA == headB) {
                    return headA;
                }
                headB = headB.next;
            } else {
                lenA--;
            }
            headA = headA.next;
        }
        return null;
    }

}
