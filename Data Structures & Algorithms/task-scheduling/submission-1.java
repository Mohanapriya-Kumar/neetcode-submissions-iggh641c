class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*example:
        tasks = [A, A, A, B, B, B], n = 2
        A B _ | A B _ | A B => first two is 
        number of blocks * size of each block
        (maxFreq - 1)*(n + 1)
        last block = (maxCount)
        here maxFreq is maximum freq and maxCount is number of elements with max freq*/
        int[] maxF = new int[26];
        for(char task : tasks){
            maxF[task - 'A']++;
        }
        
        int fMax = 0;
        for(int i = 0; i < 26; i++){
            if(maxF[i] > fMax) fMax = maxF[i];
        }

        int maxC = 0;
        for(int i = 0; i < 26; i++){
            if(maxF[i] == fMax) maxC++;
        }
        
        return Math.max(tasks.length,((fMax - 1)*(n + 1) + maxC));
        //very important if tasks are enough to fill the spaces and not need idle tasks.length is cprrect
    }
}
