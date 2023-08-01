import java.util.Scanner;

public class FlattenLinkedList {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node flatten(Node head) {
        // Your code here
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node secList = head.next;
        Node l1 = head.bottom;
        int count = 1;
        // boolean flag=false;
        while (secList != null) {
            // second linked list not null
            Node l2 = secList;
            // merge sort
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    temp.bottom = l2;
                    temp = l2;
                    l2 = l2.bottom;
                } else if (l2 == null || l1.data < l2.data) {
                    temp.bottom = l1;
                    temp = l1;
                    l1 = l1.bottom;
                } else {
                    temp.bottom = l2;
                    temp = l2;
                    l2 = l2.bottom;
                }
            }
            // pointer to first list back to the ans list
            temp = head;
            l1 = head.bottom;
            // moving the pointer of second list to next list
            secList = secList.next;
        }
        return head;
    }
}
