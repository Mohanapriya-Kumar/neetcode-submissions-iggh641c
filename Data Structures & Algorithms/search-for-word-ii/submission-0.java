class Solution {

    class TrieNode{
        TrieNode children[] = new TrieNode[26];
        String word;
    }

    char[][] board;
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        TrieNode root = buildTrie(words);
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                dfs(r,c,root);
            }
        }
        return res;
    }

    private void dfs(int r, int c, TrieNode node){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#') return;
        char ch = board[r][c];
        if(node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];
        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';
        dfs(r+1, c, node);
        dfs(r-1, c, node);
        dfs(r, c+1, node);
        dfs(r, c-1, node);
        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode curr = root;   
            for(char ch : w.toCharArray()){
                if(curr.children[ch - 'a'] == null) curr.children[ch - 'a'] = new TrieNode();
                curr = curr.children[ch - 'a'];
            }
            curr.word = w;
        }
        return root;
    }
}
