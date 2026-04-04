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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode tail = head;
        for(int i = 0; i < k; i++){
            if(tail == null) return head; //very important step
            tail = tail.next; //we move out
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail,k);//head is actually the last node after reversal so join the remaining with it
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null, curr = head;
        while(curr != tail) { 
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } 
        return prev;
    }



}
