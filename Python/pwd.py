#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Jun 13 13:40:45 2018

@author: wei-hanchen
"""
import random, string;
letters = string.ascii_letters;
lletters = string.ascii_lowercase;
numbers = "1234567890";
password = open("password.txt","w"); #open txt file in write mode

typeinput = raw_input("What type of password is this?");
usrinput = int(input("how many letters do you want to generate: "));
nloops = int(input("how many times do you want to generate? "));
#-----------------generating password in array---------------------------------
def pgenerate():
    i = 1;
    parray = [];
    while i < usrinput:
        rnumbers = random.choice(numbers);
        rletters = random.choice(letters);
        rchoices = random.choice(rnumbers + rletters);
        parray.append(rchoices);
        i+=1
    rcpassword = ("".join(parray));
    return rcpassword;
#------------------------------------------------------------------------------
#-----------write password into txt-----------
for j in range(nloops):
    password.write(typeinput);
    password.write(": ");
    password.write(pgenerate());
    password.write("\n");
password.close();
#---------------------------------------------
#------------------reading txt----------------
def rfile():
    readpassword = open("password.txt","r");
    read = readpassword.read();
    read = read;
    readpassword.close();
    return read;
#---------------------------------------------
print rfile();




