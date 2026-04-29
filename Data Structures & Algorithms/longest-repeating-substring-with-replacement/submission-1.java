class Solution {
    public int characterReplacement(String s, int k) {
        int maxL = 0;
        Set<Character> seen = new HashSet<>();
        for(char c : s.toCharArray()){
            seen.add(c);
        }
        for(char c : seen){
            int l = 0, count = 0;
            for(int r = 0; r < s.length(); r++){
                if(s.charAt(r) == c) count++;
                while(r-l+1 - count > k){ //while number of replacements exceeds
                    if(s.charAt(l) == c) count--;
                    l++;
                }
                //now I can
                maxL = Math.max(maxL, r-l+1);
            }
        }
        return maxL;
    }
}
