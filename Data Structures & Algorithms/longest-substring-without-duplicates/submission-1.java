class Solution {
    public int lengthOfLongestSubstring(String s) { //window
        int maxL = 0, l = 0;
        Set<Character> seen = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            while(seen.contains(s.charAt(r))){ //right la irundha left la thooku
                seen.remove(s.charAt(l));// remove uses the actual character no idx
                l++;  
            }
            seen.add(s.charAt(r));
            maxL = Math.max(maxL, r-l+1);
        }
        return maxL;
    }
}
