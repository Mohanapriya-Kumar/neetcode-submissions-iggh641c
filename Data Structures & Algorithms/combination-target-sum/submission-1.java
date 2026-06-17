class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int i, int[] nums, int target, List<Integer> sub, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(i == nums.length || target < 0) return;

        sub.add(nums[i]);
        backtrack(i, nums, target - nums[i], sub, res);
        sub.remove(sub.size() - 1);
        backtrack(i + 1, nums, target, sub, res);
    }
}
