class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //important difference between combinations and permutations:
        // permuations need boolean used so i not required we exactly use an element once
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,new boolean[nums.length],new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length){ //return when curr has all nums ie one permutation over
            res.add(new ArrayList<>(curr));

        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            curr.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, curr, res);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
