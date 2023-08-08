public class CloneLinkedListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = null;
        Node cur = head;
        while (cur != null) {
            Node temp = new Node(cur.val);
            // insert the new nodes next to the original nodes
            temp.next = cur.next;
            cur.next = temp;
            // if head has not been assigned
            if (newHead == null) {
                newHead = temp;
            }
            cur = cur.next.next; // cur.next leads to temp
        }

        // assgining the random pointer value
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;// cur.next is the copied node
        }

        // separating the old and new linkedlist
        cur = head;
        Node newCur = newHead;
        while (cur != null) {
            cur.next = cur.next.next;
            newCur.next = newCur.next == null ? null : newCur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}
