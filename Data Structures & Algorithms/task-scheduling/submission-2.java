class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxF = 0;
        int freq[] = new int[26];
        for(char c : tasks){
            freq[c - 'A']++;
        }
        for(int f : freq){
            if(f > maxF) maxF = f;
        }
        int maxC = 0;
        for(int f : freq){
            if(f == maxF) maxC++;
        }
        return Math.max(tasks.length, ((maxF - 1)*(n + 1) + maxC));
    }
}
