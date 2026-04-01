class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){ //1st num should be followed by two more nums so - 2
            if(i > 0 && nums[i] == nums[i-1]) continue; //before choosing nums[i] check if already chosen
            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];
            while(l < r){
                int sum = nums[l] + nums[r];
                if(sum == target && l < r){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(sum < target) l++;
                else r--;
            }
        }
        return res;
    }
}
