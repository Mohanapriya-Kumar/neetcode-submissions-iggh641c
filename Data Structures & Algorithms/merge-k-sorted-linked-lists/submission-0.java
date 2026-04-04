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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        Queue<ListNode> q = new LinkedList<>();
        for(ListNode list : lists){
            q.add(list);
        }
        while(q.size() > 1) { 
            ListNode l1 = q.poll();
            ListNode l2  = q.poll();
            q.add(merge(l1, l2));
        }
        return q.poll();
    }
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(a != null && b != null) {
            if(a.val < b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if(a != null) temp.next = a;
        if(b != null) temp.next = b;
        return dummy.next;
    }
}
