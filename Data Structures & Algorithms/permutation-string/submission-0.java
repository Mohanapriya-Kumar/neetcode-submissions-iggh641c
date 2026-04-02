class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(int i = 0; i < s1.length(); i++){ //size of window considered is n1
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        if(matches(c1, c2)) return true;
        for(int i = s1.length(); i < s2.length(); i++){
            //move the window add the next ele and remove the pvs
            //c1 is already fixed
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i - s1.length()) - 'a']--;
            if(matches(c1, c2)) return true;
        }
        return false;
    }
    private static boolean matches(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
