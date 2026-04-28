class Solution {
    public boolean isAnagram(String s, String t) {
        int[] val = new int[26];
        for(char c : s.toCharArray()){
            val[c-'a']++;
        }
        for(char c : t.toCharArray()){
            val[c-'a']--;
        }
        for(int num : val){
            if(num != 0) return false;
        }
        return true;
    }
}
