class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReverseNodesInGrp {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = new ListNode(2);
        head.next = temp;
        head = reverseKGroup(head, 2);
        display(head);
    }

    static void display(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode before = null, curr = head, after = head.next;
        ListNode prev = null, present = head;
        int count = 0;
        while (curr != null) {
            // reversing a set of k
            curr.next = before;
            count++;
            before = curr;
            curr = after;
            if (after != null) {
                after = after.next;
            } else if (count != k) {
                curr = before;
                before = null;
                after = curr.next;
                k = count;
                count = 0;
                // connecting the previous segment/set to present
                prev.next = present;
            }
            // set of k is reversed
            if (count == k) {
                count = 0;
                if (prev == null) {
                    head = before;
                } else {
                    prev.next = before;
                }
                prev = present;
                present = curr;
                before = null;
            }
        }
        return head;
    }
}
