class Solution {
    public boolean isAnagram(String s, String t) {
        int[] key = new int[26];
        for(int i = 0; i < s.length(); i++){
            key[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            key[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(key[i] != 0) return false;
        }
        return true;
    }
}
