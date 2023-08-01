
public class EntryPointOfLoop {

    // logic
    // 'l1' linear dist
    // 'l2' meeting dist in the loop
    // fast pointer traverse twice the slow pointer
    // 2(l1+l2)=l1+l2+nc
    // nc-> complete loop traversal
    // l1=nc-l2
    // that is the left over portion of the loop after deleting l2
    // if we start traversing the loop after point 'l2' end
    // at the same time start the traversal from starting
    // the point where these two meet is the starting of this point
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == slow) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}