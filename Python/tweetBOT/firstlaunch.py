import tweepy
import os
from keys import *

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_secret)
api = tweepy.API(auth)
FILE_NAME = 'last_seen_id.txt'
w_file = open(FILE_NAME, 'w')
first_id = api.mentions_timeline()

if os.stat(FILE_NAME).st_size == 0:
	w_file.write(str(first_id[0].id))

else:
	pass

w_file.close()
