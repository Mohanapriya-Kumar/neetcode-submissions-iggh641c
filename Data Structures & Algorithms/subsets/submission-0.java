class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //backTracking
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0,nums,new ArrayList<>(),res);
        return res;
    }
    private void backTrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backTrack(i + 1, nums, subset, res);
        subset.remove(subset.size() - 1);
        backTrack(i + 1, nums, subset, res);
    }
}