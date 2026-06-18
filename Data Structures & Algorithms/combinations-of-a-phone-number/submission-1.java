class Solution {
    private final String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res; // very important to check validty
        backtrack(0, digits, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int i, String digits, StringBuilder curr, List<String> res){
        if(i == digits.length()){
            res.add(curr.toString());
            return; 
        }

        String letters = map[digits.charAt(i) - '0'];
        for(char c : letters.toCharArray()){
            curr.append(c);
            backtrack(i+1, digits, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
