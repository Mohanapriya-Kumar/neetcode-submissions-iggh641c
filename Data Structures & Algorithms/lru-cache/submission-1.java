class LRUCache {

    class Node{
        int val;
        int key;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        Node next, prev;
    }

    private Map<Integer,Node> map;
    private int cap;
    private Node left, right;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }

    private void insert(Node node){ //in structure
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
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) remove(map.get(key));
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
        if(map.size() > cap){
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
