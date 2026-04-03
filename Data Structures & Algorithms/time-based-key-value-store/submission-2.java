class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1; //what if size if null handle that case as well..
        String res = "";
        while(l <= r){
            int mid = l + (r - l)/2;
            if(list.get(mid).time <= timestamp){
                res = list.get(mid).val;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
    class Pair{
        String val;
        int time;
        Pair(String val, int time){
            this.val = val;
            this.time = time;
        }
    }
}
