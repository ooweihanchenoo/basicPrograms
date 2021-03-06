from tweepy import API
from tweepy import Cursor
from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream
from keys import *
from textblob import TextBlob
#---------------------------------------------
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import re
import csv
#---------------------------------------------

#######---TWITTER CLIENT---#####
class TwitterClient():
	def __init__(self, twitter_user=None):
		self.auth = TwitterAuthenticator().authenticate_twitter_app()
		self.twitter_client = API(self.auth)
		self.twitter_user = twitter_user

	def get_twitter_client_api(self):
		return self.twitter_client

	def get_user_timeline_tweets(self, num_tweets):
		tweets = []
		for tweet in Cursor(self.twitter_client.user_timeline, id=self.twitter_user).items(num_tweets):
			tweets.append(tweet)
		return tweets

	def get_friend_list(self, num_friends):
		friend_list = []
		for friend in Cursor(self.twitter_client.friends, id=self.twitter_user).items(num_friends):
			friend_list.append(friend)
		return friend_list

	def get_home_timeline_tweets(self, num_tweets):
		home_timeline_tweets = []
		for tweet in Cursor(self.twitter_client.home_timeline, id=self.twitter_user).item(num_tweets):
			home_timeline_tweets.append(tweet)
		return home_timeline_tweets

#######---TWITTER AUTHENTICATER---#####
class TwitterAuthenticator():

	def authenticate_twitter_app(self):
		auth = OAuthHandler(consumer_key, consumer_secret)
		auth.set_access_token(access_token, access_secret)
		return auth

#######---TWITTER STREAMER---#####
class TwitterStreamer():
	#Class for straming and processing live tweets
	def __init__(self):
		pass

	def stream_tweets(self, fetched_tweets_filename, hash_tag_list):
		#Handles twitter authentication and the connection to the twitter streaming api
		listener = OutListener(fetched_tweets_filename)
		auth = OAuthHandler(consumer_key, consumer_secret)
		auth.set_access_token(access_token, access_secret)
		stream = Stream(auth, listener)
		#Filter twitter streams to capture data by the keywords:
		stream.filter(track=hash_tag_list)

#####---TWITTER LISTENER---#####
class OutListener(StreamListener):
	#Basic listener class that just prints received tweets to OutListener
	def __init__(self, fetched_tweets_filename):
		self.fetched_tweets_filename = fetched_tweets_filename

	def on_data(self, data):
		try:
			print(data)
			with open(self.fetched_tweets_filename, 'a') as tf:
				tf.write(data)
			return True
		except BaseException as e:
			print("Error on_data: %s" % str(e))
		return True

	def on_error(self, status):
		if status == 420:
			#Returning Flase on_data method in case rate limit occurs
			return False
		print(status)

#####---TWITTER ANALYZER---#####
class TweetAnalyzer():
	'''
	Functionality for analyzing and categorizing content from tweets
	'''
	def analyze_sentiment(self, tweet):
		analysis = TextBlob(self.clean_tweet(tweet))

		if analysis.sentiment.polarity > 0:
			return "This tweet is POSITIVE"
		elif analysis.sentiment.polarity == 0:
			return "This tweet is NEUTRAL"
		else:
			return "This tweet is NEGATIVE"

	def clean_tweet(self, tweet):
		return ' '.join(re.sub("(@[A-Za-z0-9]+)|([^0-9A-Za-z \t])|(\w+:\/\/\S+)", " ", tweet).split())

	def tweets_to_data_frame(self, tweets):
		df = pd.DataFrame(data=[tweet.text for tweet in tweets], columns=['Tweets'])
		df['id'] = np.array([tweet.id for tweet in tweets])
		df['len'] = np.array([len(tweet.text) for tweet in tweets])
		df['date'] = np.array([tweet.created_at for tweet in tweets])
		df['source'] = np.array([tweet.source for tweet in tweets])
		df['likes'] = np.array([tweet.favorite_count for tweet in tweets])
		df['retweets'] = np.array([tweet.retweet_count for tweet in tweets])

		return df


if __name__ == "__main__":
	twitter_client = TwitterClient()
	api = twitter_client.get_twitter_client_api()
	tweet_analyzer = TweetAnalyzer()

#	If you're using python3 make sure it is input, instead of input.
	screenName = raw_input("Please Enter their twitter account (DO NOT INCLUDE @): \n")

	tweets = api.user_timeline(screen_name=screenName, count=200)
	
	df = tweet_analyzer.tweets_to_data_frame(tweets)

	df['sentiment'] = np.array([tweet_analyzer.analyze_sentiment(tweet) for tweet in df['Tweets']])
	df.to_csv('./twitter1.csv', encoding='utf-8')
	print('==========FINISHED, Check the twitter1.cvs file==========')





''' 
==========SESSION FOR PLOTTING==========
#	Get average length over all tweets
#	print(np.mean(df['len']))

#	Get the number of likes for the most liked tweet
#	print(np.max(df['likes']))

#	Get the number of retweets for the most retweeted tweet
#	print(np.max(df['retweets']))

#	Time Likes
#	time_likes = pd.Series(data=df['likes'].values, index=df['date'])
#	time_likes.plot(figsize=(16, 4), color='r')
#	plt.show()
#	Time Retweets
#	time_likes = pd.Series(data=df['retweets'].values, index=df['date'])
#	time_likes.plot(figsize=(16, 4), color='r')
#	plt.show()

#	Time Likes&Retweets	
	time_likes = pd.Series(data=df['likes'].values, index=df['date'])
	time_likes.plot(figsize=(16, 4), label='likes', legend=True)
	time_likes = pd.Series(data=df['retweets'].values, index=df['date'])
	time_likes.plot(figsize=(16, 4), label='retweets', legend=True)
	plt.show()



#	print(dir(tweets[0]))
#	print(tweets[0].retweet_count)
#	print(df.head(10))

=========================================

	#Authenticate
	hash_tag_list = ['donald trump', 'hillary clinton', 'barack obama', 'bernie sanders']
	fetched_tweets_filename = "tweets.text"

	twitter_client = TwitterClient('pycon')
	print(twitter_client.get_user_timeline_tweets(1))

#	twitter_streamer = TwitterStreamer()
#	twitter_streamer.stream_tweets(fetched_tweets_filename, hash_tag_list)
'''