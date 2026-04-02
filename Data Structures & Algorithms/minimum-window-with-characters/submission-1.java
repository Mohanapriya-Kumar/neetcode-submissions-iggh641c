class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tc = new HashMap<>();
        Map<Character, Integer> wc = new HashMap<>();
        for(char c : t.toCharArray()){
            tc.put(c, tc.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int reslen = Integer.MAX_VALUE;
        int[] res = {-1,-1};
        int have = 0, need = tc.size();//not t.len bcuz we need unique chars first
        for(int r = 0; r < s.length(); r++){
            //every sliding win: put r while remove from l
            char c = s.charAt(r);
            wc.put(c, wc.getOrDefault(c, 0) + 1);
            if(tc.containsKey(c) && tc.get(c) == wc.get(c)) have++;
            while(have == need){
                if((r - l + 1) < reslen){
                    reslen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char left = s.charAt(l);
                wc.put(left, wc.get(left) - 1); //first remove leftchar from win
                if(tc.containsKey(left) && wc.get(left) < tc.get(left)) have--; //rem from have if og has leftchar
                l++;
            }
        } 
        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
