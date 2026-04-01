class Solution {
    public int lengthOfLongestSubstring(String s) {
        //sliding window
        int max = 0;
        int l = 0;
        //without repeat -> Set
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){ //while not if
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
