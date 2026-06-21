class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return count;
    }
    private void expand(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)){
            l--;
            r++;
            count++;
        }
    }
}
