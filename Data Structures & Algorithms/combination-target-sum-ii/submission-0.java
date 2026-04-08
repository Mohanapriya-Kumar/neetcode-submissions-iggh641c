class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //Combination Sum I → reuse allowed
        //Combination Sum II → reuse NOT allowed + duplicates in input
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>(),res);
        return res;
    }

    private static void backtrack(int start, int[] candidates, int target, List<Integer> curr, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            curr.add(candidates[i]);
            backtrack(i + 1, candidates, target - candidates[i], curr, res);
            curr.remove(curr.size() - 1);
        }

    }
}
