package com.wind4869._01_sort._148_sort_list;

import com.wind4869.ListNode;

class Solution2 {
    public static void main(String[] args) {
        ListNode list = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        list = new Solution2().sortList(list);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int n = 0;
        for (ListNode current = head; current != null; current = current.next) n++;

        ListNode dummy = new ListNode(0, head);
        for (int size = 1; size < n; size *= 2) {
            ListNode tail = dummy, current = dummy.next;
            while (current != null) {
                ListNode left = current;
                ListNode right = splitList(left, size);
                current = splitList(right, size);

                ListNode[] mergeResult = mergeList(left, right);
                tail.next = mergeResult[0];
                tail = mergeResult[1];
            }
        }

        return dummy.next;
    }

    private ListNode splitList(ListNode head, int size) {
        while (head != null && --size > 0) head = head.next;
        if (head == null) return null;
        ListNode restHead = head.next;
        head.next = null;
        return restHead;
    }

    private ListNode[] mergeList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        while (tail.next != null) tail = tail.next;
        return new ListNode[]{dummy.next, tail};
    }
}
