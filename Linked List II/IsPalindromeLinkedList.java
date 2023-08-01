public class IsPalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        boolean countOdd = false;
        if (count % 2 != 0) {
            countOdd = true;
        }
        count /= 2;
        cur = head;
        ListNode prev = null;
        ListNode nxt = head.next;
        while (count > 0) {
            cur.next = prev;
            count--;
            prev = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        ListNode cmpr = countOdd ? cur.next : cur;
        cur = prev;
        while (cmpr != null) {
            if (cmpr.val != cur.val) {
                return false;
            }
            cmpr = cmpr.next;
            cur = cur.next;
        }
        return true;
    }
}