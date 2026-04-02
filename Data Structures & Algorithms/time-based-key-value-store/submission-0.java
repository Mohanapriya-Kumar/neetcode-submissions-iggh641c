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
        int l = 0, r = list.size() - 1;
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
}

class Pair{
    int time;
    String val;
    Pair(String val, int time){
        this.time = time;
        this.val = val;
    }
}
