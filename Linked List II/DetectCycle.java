//https://leetcode.com/problems/linked-list-cycle/

public class DetectCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null){
          return false;
        }
        ListNode curr=head;
        ListNode doub=head.next;
        while(curr!=doub && doub!=null){
          curr=curr.next;
          if(doub.next==null){
            return false;
          }
          doub=doub.next.next;
        }
        if(doub==null){
          return false;
        }
        return true;
    }
}
