public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode head = temp;

        while (l1.next != null && l2.next != null) {
            temp.val += (l1.val + l2.val);
            if (temp.val > 9) {
                temp.next = new ListNode(temp.val / 10);
                temp.val %= 10;
                l1 = l1.next;
                l2 = l2.next;
                temp = temp.next;
                continue;
            }
            l1 = l1.next;
            l2 = l2.next;
            temp.next = new ListNode();
            temp = temp.next;
        }

        temp.val += (l1.val + l2.val);
        l1 = l1.next;
        l2 = l2.next;

        if (l1 != null || l2 != null) {
            ListNode big = l1 != null ? l1 : l2 != null ? l2 : null;
            while (big != null) {
                if (temp.val > 9) {
                    temp.next = new ListNode(temp.val / 10);
                    temp.val %= 10;
                } else {
                    temp.next = new ListNode();
                }
                temp = temp.next;
                temp.val += big.val;
                big = big.next;
            }
        }

        if (temp.val > 9) {
            temp.next = new ListNode(temp.val / 10);
            temp.val %= 10;
        }

        return head;
    }
}
