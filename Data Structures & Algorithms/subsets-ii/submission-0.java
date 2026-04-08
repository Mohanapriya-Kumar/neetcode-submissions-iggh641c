class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //duplicates allowed within subsets but dont duplicate the whole subset again
        //skip duplicate so sort
        //every level of recursion is allowed so no need to check i == len
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int start, int[] nums, List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i = start; i < nums.length; i++){
            //very important skip dups
            if(i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtrack(i + 1, nums, curr, res); //skip dups so i+1 we don't manually create duplicates of the same index the ip already has them
            curr.remove(curr.size() - 1);
        }
    }
}
