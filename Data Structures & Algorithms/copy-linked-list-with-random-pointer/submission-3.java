/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;

        //1. Interleave
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        //2. Random ptr
        curr = head;
        while(curr != null){
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        //3. Separate
        curr = head;
        Node newHead = head.next, newCurr = newHead;
        while(curr != null){
            curr.next = (curr.next != null) ? curr.next.next : null;
            newCurr.next = (newCurr.next != null) ? newCurr.next.next : null;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}
