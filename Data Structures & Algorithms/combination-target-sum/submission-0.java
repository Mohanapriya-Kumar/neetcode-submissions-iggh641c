class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,target,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int i, int[] nums, int target, List<Integer> curr, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i == nums.length || target < 0) return;

        curr.add(nums[i]);
        backtrack(i, nums, target - nums[i], curr, res);
        curr.remove(curr.size() - 1);
        backtrack(i + 1, nums, target, curr, res);
    }
}
