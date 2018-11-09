#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 13 16:56:48 2018

@author: wei-hanchen
"""
import csv;
from collections import defaultdict;
columns = defaultdict(list);
lid1 = "local id type 1";
lid2 = "local id type 2";
lid3 = "local id type 3";

with open('SpiceworkChallenge.csv') as csvfile:
    csvreader = csv.DictReader(csvfile);
    for row in csvreader:
        for (k,v) in row.items():
            columns[k].append(v);

idtype_input = input('enter local type id: ');
id_input = raw_input('enter id: ');

if idtype_input == 1:
    keys = columns[lid1];
    user1 = keys[0:2];
    user2 = keys[2:7];
    user3 = keys[7:11];
    if id_input in user1:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user1||');
    elif id_input in user2:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user2||');
    elif id_input in user3:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user3||');    
    elif id_input == ' ':
        print ('no match data found');
    else:
        print ('please check the value again');
elif idtype_input == 2:
    keys = columns[lid2];
    user1 = keys[0:2];
    user2 = keys[2:7];
    user3 = keys[7:11];
    if id_input in user1:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user1||');
    elif id_input in user2:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user2||');
    elif id_input in user3:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user3||');    
    elif id_input == ' ':
        print ('no match data found');
    else:
        print ('please check the value again');
elif idtype_input == 3:
    keys = columns[lid3];
    user1 = keys[0:2];
    user2 = keys[2:7];
    user3 = keys[7:11];
    if id_input in user1:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user1||');
    elif id_input in user2:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user2||');
    elif id_input in user3:
        print ('||id_type: ', idtype_input, ' || ', 'id: ', id_input, '|| => user3||');    
    elif id_input == ' ':
        print ('no match data found');
    else:
        print ('please check the value again');
else:
    print("please re-enter the local id type again");



