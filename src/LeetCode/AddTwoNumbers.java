package LeetCode;

public class AddTwoNumbers {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int counter = 0;
        while(l1!=null || l2!=null || counter!=0){
            int sum = counter;
            sum+= l1!=null ? l1.val:0;
            sum+= l2!=null ? l2.val:0;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            counter = sum/10;
            l1 = l1!=null? l1.next:null;
            l2 = l2!=null?l2.next:null;
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode h3 = addTwoNumbers(h1,h2);
        System.out.println(h3);
    }
}
