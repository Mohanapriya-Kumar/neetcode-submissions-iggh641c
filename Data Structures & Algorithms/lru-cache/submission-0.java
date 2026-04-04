class LRUCache {

    class Node {
        int key; 
        int val;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        Node prev, next;
    }

    private Map<Integer, Node> map;
    private int cap;
    private Node left, right;

    public LRUCache(int capacity) {// constructor
        this.cap = capacity;
        map = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }

    private void insert(Node node) {
        Node p = right.prev;
        p.next = node;
        node.prev = p;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) remove(map.get(key));//remove the node
        Node node = new Node(key, value);
        map.put(key,node);
        insert(node);
        if(map.size() > cap){
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
