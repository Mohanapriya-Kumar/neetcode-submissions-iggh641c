class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int y = -nums[i];
            int l = i + 1, r = n - 1;
            while(l < r){
                int sum = nums[l] + nums[r];
                if(l < r && sum < y) l++;
                else if(l < r && sum > y) r--;
                else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;

                }
            }
        }
        return res;
    }
}
