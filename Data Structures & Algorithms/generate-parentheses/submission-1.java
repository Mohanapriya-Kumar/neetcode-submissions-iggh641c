class Solution {
    public List<String> generateParenthesis(int n) {
        //concatenation doesn't need Stringbuild
        List<String> res = new ArrayList<>();
        backtrack("",res,0,0,n);
        return res;
    }
    private void backtrack(String curr, List<String> res, int open, int close, int max){
        if(curr.length() == max * 2){
            res.add(curr);
            return;
        }
        if(open < max) backtrack(curr+'(', res, open+1, close, max);
        if(close < open) backtrack(curr+')', res, open, close+1, max);
    }
}
