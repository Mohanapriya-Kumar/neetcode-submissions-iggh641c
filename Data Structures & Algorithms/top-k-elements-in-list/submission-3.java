class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] arr = new List[n+1];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList<>();
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            arr[e.getValue()].add(e.getKey());
        }

        int idx = 0;
        int[] res = new int[k];
        for(int i = arr.length - 1; i >= 0 && idx < k; i--){
            for(int x : arr[i]){
                res[idx++] = x;
                if(idx > k){
                    return res;
                }
            }
        }
        return res;
    }
}
