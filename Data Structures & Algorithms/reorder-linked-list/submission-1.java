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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        } 
        ListNode sc = slow.next;
        slow.next = null;

        ListNode sp = null;
        while(sc != null){
            ListNode st = sc.next;
            sc.next = sp;
            sp = sc;
            sc = st;
        }
        ListNode a = head, b = sp;
        while(b != null){
            ListNode t1 = a.next;
            ListNode t2 = b.next;
            a.next = b;
            b.next = t1;
            a = t1;
            b = t2;
        }
    }
}
