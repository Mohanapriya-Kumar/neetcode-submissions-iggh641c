/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //to handle deletion of head also use dummy node before head
        ListNode dummy = new ListNode(-1, head);//(val, next)
        ListNode b = dummy, a = dummy;
        for(int i = 0; i <= n; i++){
            b = b.next;
        }
        while(b != null){
            b = b.next;
            a = a.next;
        }
        a.next = a.next.next;
        return dummy.next;
    }
}
