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
        if(head == null) return null;
        //Interleave
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        //random
        curr = head;
        while(curr != null){
            if(curr.random != null){ //very important to check if it is not null
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //separate
        Node newHead = head.next, ncurr = newHead;
        curr = head;
        while(curr != null){
            curr.next = (curr.next != null) ? curr.next.next : null;
            ncurr.next = (ncurr.next != null) ? ncurr.next.next : null;
            curr = curr.next;
            ncurr = ncurr.next;
        }
        return newHead;
    }
}
