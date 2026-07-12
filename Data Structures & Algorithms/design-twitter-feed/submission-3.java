class Twitter {

    private static int time;
    class Tweet{
        int id;
        int time;
        Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.time, a.time)
        );
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        for(int followee : followMap.get(userId)){
            if(tweetMap.containsKey(followee)){
                for(Tweet t : tweetMap.get(followee)){
                    pq.offer(t);
                }
            }
        }


        List<Integer> res = new ArrayList<>();
        int c = 0;
        while(!pq.isEmpty() && c < 10){
            res.add(pq.poll().id);
            c++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId) && followerId != followeeId) followMap.get(followerId).remove(followeeId);
    }
}
