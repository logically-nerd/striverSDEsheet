//https://leetcode.com/problems/rotate-list/description/

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // for rotation more than the size of the linkedlist
        k %= size(head);
        if (k == 0) {
            // no rotation needed
            return head;
        }

        // last->last node
        // toBeLast->last node after rotation
        ListNode last = head, toBeLast = head;
        while (k > 0) {
            last = last.next;
            k--;
        }
        while (last.next != null) {
            last = last.next;
            toBeLast = toBeLast.next;
        }
        ListNode ans = toBeLast.next;
        toBeLast.next = null;
        last.next = head;
        return ans;
    }

    int size(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
