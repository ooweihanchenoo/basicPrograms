import tweepy
import time
from keys import *

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_secret)
api = tweepy.API(auth)
FILE_NAME = 'last_seen_id.txt'

def retrieve_last_seen_id(file_name):
	f_read = open(FILE_NAME, 'r')
	last_seen_id = int(f_read.read().strip())
	f_read.close()
	return last_seen_id

def store_last_seen_id(last_seen_id, filename):
	f_write = open(FILE_NAME, 'w')
	f_write.write(str(last_seen_id))
	f_write.close()
	return

def reply_to_tweets():
	print('-------------------------------------------------------')
	print('----------------SCANNING FOR NEW TWEETS----------------')
	print('-------------------------------------------------------')

	last_seen_id = retrieve_last_seen_id(FILE_NAME)
	mentions = api.mentions_timeline(
	                        last_seen_id,
	                        tweet_mode='extended')

	for mention in reversed(mentions):
		print ('|||-NEW-TWEETS-FOUND-|||' + str(mention.id) + ' - ' + mention.full_text)
		last_seen_id = mention.id
		store_last_seen_id(mention.id, FILE_NAME)
		if '#helloworld' in mention.full_text.lower():
	            if '#helloworld back to you!' not in mention.full_text.lower():
	            	print('-----REPLYING-----') 
	            	api.update_status('@' + mention.user.screen_name + ' #HelloWorld back to you!', mention.id)
	            	print('-----FINISHED-----')
	            else:
	            	pass

while True:
	reply_to_tweets()
	time.sleep(5)
