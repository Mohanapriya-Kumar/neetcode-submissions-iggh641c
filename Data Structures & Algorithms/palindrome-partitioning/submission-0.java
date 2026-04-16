class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(0, s, path, res);
        return res;
    }
    private void solve(int start, String str, List<String> path, List<List<String>> res){
        if(start == str.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < str.length(); end++){
            if(pal(str,start,end)){
                path.add(str.substring(start, end+1));
                solve(end+1,str,path,res);
                path.remove(path.size() - 1);
            }
        }  
    }

    private boolean pal(String str, int l, int r){
        while(l < r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
