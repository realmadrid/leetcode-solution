package heap;

import java.util.*;

public class Solution_355 {

}

class Twitter {
    class Tweet implements Comparable<Tweet> {
        int userId;
        int tweetId;
        int time;

        public Tweet(int userId, int tweetId, int time) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = time;
        }

        @Override
        public int compareTo(Tweet other) {
            return other.time - this.time;
        }
    }

    private PriorityQueue<Tweet> tweets;

    private Map<Integer, Set<Integer>> follows;

    private int time;

    /** Initialize your data structure here. */
    public Twitter() {
        tweets = new PriorityQueue<>();
        follows = new HashMap<>();
        time = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.offer(new Tweet(userId, tweetId, time));
        time++;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> recent = new ArrayList<>();
        Set<Integer> users = follows.getOrDefault(userId, new HashSet<>());
        users.add(userId);
        PriorityQueue<Tweet> temp = new PriorityQueue<>(tweets);
        while (recent.size() < 10 && !temp.isEmpty()) {
            Tweet t = temp.poll();
            if (users.contains(t.userId)) {
                recent.add(t.tweetId);
            }
        }
        return recent;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, HashSet::new).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> follow = follows.get(followerId);
        if (follow != null) {
            follow.remove(followeeId);
        }
    }
}
