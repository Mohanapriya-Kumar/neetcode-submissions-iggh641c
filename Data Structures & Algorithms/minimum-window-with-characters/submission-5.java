class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> tc = new HashMap<>();
        Map<Character, Integer> wc = new HashMap<>();
        for(char c : t.toCharArray()){
            tc.put(c, tc.getOrDefault(c, 0)+1);
        }

        int l = 0, have = 0, need = tc.size();
        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE;
        for(int r = 0; r < s.length(); r++){
            char right = s.charAt(r);
            wc.put(right, wc.getOrDefault(right,0)+1);
            if(tc.containsKey(right) && tc.get(right) == wc.get(right)) have++;
            while(have == need){
                if(r - l + 1 < resLen){
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }
                char left = s.charAt(l);
                wc.put(left, wc.get(left)-1);
                if(tc.containsKey(left) && tc.get(left) > wc.get(left)) have--;
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
