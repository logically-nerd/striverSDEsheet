public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA,curB=headB;
        int countA=0,countB=0;
        while(curA!=null || curB!=null){
            if(curA!=null){
                countA++;
                curA=curA.next;
            }
            if(curB!=null){
                countB++;
                curB=curB.next;
            }
        }
        curA=headA;
        curB=headB;
        while(countA>countB){
            curA=curA.next;
            countA--;
        }
        while(countA<countB){
            curB=curB.next;
            countB--;
        }
        while(curA!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}
