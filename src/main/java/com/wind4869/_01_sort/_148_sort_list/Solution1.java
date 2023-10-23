package com.wind4869._01_sort._148_sort_list;

import com.wind4869.ListNode;

class Solution1 {
    public static void main(String[] args) {
        ListNode list = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        list = new Solution1().sortList(list);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mergeList(sortList(head), sortList(mid));
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
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
        return dummy.next;
    }
}
