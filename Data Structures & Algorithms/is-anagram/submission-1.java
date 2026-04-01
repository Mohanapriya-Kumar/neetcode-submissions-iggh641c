class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            freq[c - 'a']--;
        }
        // for(int i = 0; i < s.length(); i++){
        //     freq[s.charAt(i) - 'a']++;
        // }
        // for(int i = 0; i < t.length(); i++){
        //     freq[t.charAt(i) - 'a']--;
        // }
        for(int n : freq){
            if(n != 0) return false;
        }
        return true;
    }
}
