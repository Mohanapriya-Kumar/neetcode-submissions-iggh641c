class Twitter {

    private static int time;
    class Tweet{
        int id; //tweetId
        int time;
        Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, List<Tweet>> tweetMap; //userId -> Tweets
    Map<Integer, Set<Integer>> followMap; // follower id follows -> followee id and lst of followers for a person is unique ie cannot follow the same person twice

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->Integer.compare(b.time, a.time));
        List<Integer> res = new ArrayList<>();

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);//should follow himself

        for(int followee : followMap.get(userId)){
            if(tweetMap.containsKey(followee)){
                for(Tweet t : tweetMap.get(followee))
                pq.offer(t);
            }
        }

        int count = 0;
        while(!pq.isEmpty() && count < 10){
            res.add(pq.poll().id);
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId) && followerId != followeeId){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
