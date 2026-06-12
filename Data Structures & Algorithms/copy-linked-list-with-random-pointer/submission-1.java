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
        //interleave

        //create a copy right to og of each node 1 1 2 2 3 3...
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        //random 
        //the random ptr of my next node(newcopy) is the next node of my og random (bcuz next to random is the deep copy of random)
        curr = head;
        while(curr != null){
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        //sepate og and copy

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
