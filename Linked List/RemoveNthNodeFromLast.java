public class RemoveNthNodeFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode last = head;
        for (int i = 1; i < n; i++) {
            last = last.next;
        }
        ListNode curr = null;
        while (last.next != null) {
            if (curr == null) {
                curr = head;
            } else {
                curr = curr.next;
            }
            last = last.next;
        }
        if (curr == null) {
            head = head.next;
        } else if (curr.next == null) {
            curr.next = null;
        } else {
            curr.next = curr.next.next;
        }
        return head;
    }
}
