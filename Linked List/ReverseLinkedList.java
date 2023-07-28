public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = null;
        ListNode curr = head;
        ListNode after = head.next;
        while (after != null) {
            curr.next = before;
            before = curr;
            curr = after;
            after = after.next;
        }
        curr.next = before;
        before = curr;
        return curr;
    }
}
