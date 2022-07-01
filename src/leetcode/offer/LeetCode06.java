package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

import algorithm.ListNode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class LeetCode06 {

    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        int n = list.size() - 1;
        for (int i = 0; i <= n; i++) {
            arr[i] = list.get(n - i);
        }
        return arr;
    }

    public static int[] reversePrint2(ListNode head) {
        ListNode headTemp = head;
        int count = 0;
        while (headTemp != null) {
            count++;
            headTemp = headTemp.next;
        }
        int[] arr = new int[count];
        int n = count - 1;
        headTemp = head;
        while (headTemp != null) {
            arr[n--] = headTemp.val;
            headTemp = headTemp.next;
        }
        return arr;
    }

}
