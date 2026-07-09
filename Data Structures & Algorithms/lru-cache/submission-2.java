class LRUCache {
 //we map key -> (key, val) to get back key from node
    class Node{
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        Node prev, next;
    }

    Map<Integer, Node> map;
    int capacity;
    Node right, left;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        right = new Node(0,0);
        left = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    

    private void insert(Node node){
        Node p = right.prev;
        p.next = node;
        node.prev = p;
        node.next = right;
        right.prev = node;
    }

    private void remove(Node node){
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curr = map.get(key);
        remove(curr);
        insert(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) remove(map.get(key));
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
        if(map.size() > capacity){
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }

    }
}
