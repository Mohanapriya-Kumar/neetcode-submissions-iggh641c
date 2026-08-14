class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //use array key based approach
        // always think about base case
        if(s1.length() > s2.length()) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        } //first window

        if(matches(c1,c2)) return true;

        for(int i = s1.length(); i < s2.length(); i++){
            c2[s2.charAt(i) - 'a']++; //add right of the win
            c2[s2.charAt(i - s1.length()) - 'a']--; // remove from left
            //only move window of s2
            if(matches(c1,c2)) return true;
        }
        return false;
    }
    private boolean matches(int[] c1, int[] c2){
        for(int i = 0; i < 26; i++){
            if(c1[i] != c2[i]) return false;
        }
        return true;
    } 
}
