//https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode head = null;
        ListNode prev = head;
        while (curr1 != null && curr2 != null) {
            ListNode temp = null;
            if (curr1.val > curr2.val) {
                temp = new ListNode(curr2.val);
                curr2 = curr2.next;
            } else {
                temp = new ListNode(curr1.val);
                curr1 = curr1.next;
            }
            if (head == null) {
                head = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
        }
        if (curr1 != null) {
            while (curr1 != null) {
                ListNode temp = null;
                temp = new ListNode(curr1.val);
                curr1 = curr1.next;
                if (head == null) {
                    head = temp;
                } else {
                    prev.next = temp;
                }
                prev = temp;
            }
        }
        if (curr2 != null) {
            while (curr2 != null) {
                ListNode temp = null;
                temp = new ListNode(curr2.val);
                curr2 = curr2.next;
                if (head == null) {
                    head = temp;
                } else {
                    prev.next = temp;
                }
                prev = temp;
            }
        }
        return head;
    }
}
