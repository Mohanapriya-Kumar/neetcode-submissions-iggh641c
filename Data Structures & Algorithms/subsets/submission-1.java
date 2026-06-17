class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(i + 1, nums, subset, res);
        subset.remove(subset.size() - 1);
        backtrack(i + 1, nums, subset, res);
    }
}
