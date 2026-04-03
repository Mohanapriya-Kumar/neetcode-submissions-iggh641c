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
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode sc = slow.next;
        slow.next = null;

        ListNode prev = null;
        while(sc != null){
            ListNode sn = sc.next;
            sc.next = prev;
            prev = sc;
            sc = sn;
        }

        ListNode a = head, b = prev;
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
