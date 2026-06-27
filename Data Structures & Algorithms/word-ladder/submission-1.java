class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.offer(beginWord);
        vis.add(beginWord);

        int lev = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String currWord = q.poll();
                if(currWord.equals(endWord)) return lev;

                char[] chars = currWord.toCharArray();
                for(int j = 0; j < currWord.length(); j++){
                    char og = chars[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == og) continue;
                        chars[j] = c;
                        String newWord = new String(chars);
                        if(set.contains(newWord) && !vis.contains(newWord)){
                            vis.add(newWord);
                            q.offer(newWord);
                        }
                    }
                    chars[j] =  og;
                }
            }
            lev++;
        }
        return 0;
    }
}
