package LinkedListLeetCode;

import java.util.HashMap;
import java.util.Map;

public class MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode[] lstNode = new ListNode[100];
        int t=0;
        while(head.next!=null){
            lstNode[t++] = head;
            head = head.next;
        }
        return lstNode[t/2];
    }


    public ListNode middleNodeFastSlow(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(slowPointer!=null && fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

}
