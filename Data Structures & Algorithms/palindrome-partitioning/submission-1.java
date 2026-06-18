class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0,s,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int start, String s, List<String> curr, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(pal(s,start,end)){
                curr.add(s.substring(start, end+1));
                backtrack(end+1,s,curr,res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean pal(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
