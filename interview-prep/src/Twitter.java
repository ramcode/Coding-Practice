import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Twitter {

	public class Tweet implements Comparable<Tweet> {
		@Override
		public int compareTo(Tweet other) {
			return other.timeStamp.compareTo(this.timeStamp);
		}

		public Integer tweetId;
		public Long timeStamp;

		public Tweet(Integer tweetId, Long timeStamp) {
			this.tweetId = tweetId;
			this.timeStamp = timeStamp;
			/*Date date = new Date();
			System.out.println("Date: "+date);
			System.out.println("Time: "+date.getTime());
			System.out.println("TimeStamp: "+timeStamp);*/
			System.out.println("TimeStamp: "+timeStamp);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((tweetId == null) ? 0 : tweetId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tweet other = (Tweet) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (tweetId == null) {
				if (other.tweetId != null)
					return false;
			} else if (!tweetId.equals(other.tweetId))
				return false;
			return true;
		}

		private Twitter getOuterType() {
			return Twitter.this;
		}
		
		
	}

	public Map<Integer, List<Integer>> fMap = null;
	public Map<Integer, List<Tweet>> tMap = null;

	/** Initialize your data structure here. */
	public Twitter() {
		fMap = new HashMap<Integer, List<Integer>>();
		tMap = new HashMap<Integer, List<Tweet>>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {

		if (tMap.containsKey(userId)) {
			tMap.get(userId).add(new Tweet(tweetId, System.nanoTime()));
		} else {
			List<Tweet> tweets = new ArrayList<Tweet>();
			tweets.add(new Tweet(tweetId, System.nanoTime()));
			tMap.put(userId, tweets);
		}

	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {

		List<Tweet> tweets = new ArrayList<Tweet>();
		if (tMap.containsKey(userId)) {
			tweets.addAll(tMap.get(userId));
		}
		if (fMap.containsKey(userId)) {
			for (int follower : fMap.get(userId)) {
				if (tMap.containsKey(follower)) {
					tweets.addAll(tMap.get(follower));
				}

			}
		}
		Collections.sort(tweets);
		return tweets.stream().limit(10).map(x -> x.tweetId).collect(Collectors.toList());

	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {

		if (fMap.containsKey(followerId)) {
			if (fMap.get(followerId).contains(followeeId)) {
				return;
			} else {
				fMap.get(followerId).add(followeeId);
			}
		} else {
			List<Integer> followers = new ArrayList<Integer>();
			followers.add(followeeId);
			fMap.put(followerId, followers);
		}

	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {

		if (fMap.containsKey(followerId)) {
			if (!fMap.get(followerId).contains(followeeId)) {
				return;
			} else {
				fMap.get(followerId).remove(new Integer(followeeId));
			}
		}
	}

	public static void main(String[] args) {

		/* Your Twitter object will be instantiated and called as such: */
		Twitter obj = new Twitter();
		
		
		obj.postTweet(1, 5);
		obj.postTweet(1, 3);
		List<Integer> param_2 = obj.getNewsFeed(1);
		System.out.println(param_2);
	}
}
