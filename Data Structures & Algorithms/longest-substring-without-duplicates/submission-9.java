class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){ //while is very very important keep doing it till 
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
