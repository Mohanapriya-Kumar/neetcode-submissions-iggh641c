class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] arr = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            arr[e.getValue()].add(e.getKey());
        }

        int idx = 0;
        int[] res = new int[k];
        for(int i = arr.length - 1; i >= 0 && idx < k; i--){
            for(int n : arr[i]){
                res[idx++] = n;
                if(idx > k) return res;
            }

        }
        return res;
    }
}
