class WordDictionary {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true; 
    }

    public boolean search(String word) {
        return dfs(0,word,root);
    }

    private boolean dfs(int i, String word, TrieNode node){
        if(node == null) return false;
        if(i == word.length()) return node.isEnd;
        char c = word.charAt(i);
        if(c == '.'){
            for(TrieNode child : node.children){
                if(child != null && dfs(i + 1, word, child)) return true;
            }
            return false;
        }
        return dfs(i + 1, word, node.children[c - 'a']);
    }
}
