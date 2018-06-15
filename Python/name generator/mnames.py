#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Fri Jun  1 14:39:01 2018

@author: wei-hanchen
"""
def main():
    import random, string
    letters=string.ascii_lowercase
    vowels="aeiouy"
    consonants="bcdfghjklmnpqrstvwxz"
    
    print('-----this program will generate multiple names within 5 letters-----')
    
    nnames = input('how many names do you want to generate? ')
    iletter1 = input('1 for letters, 2 for vowels, 3 for consonants, 4 for any specific letter ')
    iletter2 = input('1 for letters, 2 for vowels, 3 for consonants, 4 for any specific letter ')
    iletter3 = input('1 for letters, 2 for vowels, 3 for consonants, 4 for any specific letter ')
    iletter4 = input('1 for letters, 2 for vowels, 3 for consonants, 4 for any specific letter ')
    iletter5 = input('1 for letters, 2 for vowels, 3 for consonants, 4 for any specific letter ')
    
    def mgenerator():      
        if iletter1 == 1:
            letter1 = random.choice(letters)
        elif iletter1 == 2:
            letter1 = random.choice(vowels)
        elif iletter1 == 3:
            letter1 = random.choice(consonants)
        elif iletter1 == 4:
            letter1 = raw_input('what is the specific letter you want? (for letter 1)')
       
        if iletter2 == 1:
            letter2 = random.choice(letters)
        elif iletter2 == 2:
            letter2 = random.choice(vowels)
        elif iletter2 == 3:
            letter2 = random.choice(consonants)
        elif iletter2 == 4:
            letter2 = raw_input('what is the specific letter you want? (for letter 2)')
       
        if iletter3 == 1:
            letter3 = random.choice(letters)
        elif iletter3 == 2:
            letter3 = random.choice(vowels)
        elif iletter3 == 3:
            letter3 = random.choice(consonants)
        elif iletter3 == 4:
            letter3 = raw_input('what is the specific letter you want? (for letter 3)')
    
        if iletter4 == 1:
            letter4 = random.choice(letters)
        elif iletter4 == 2:
            letter4 = random.choice(vowels)
        elif iletter4 == 3:
            letter4 = random.choice(consonants)
        elif iletter4 == 4:
            letter4 = raw_input('what is the specific letter you want? (for letter 4)')
    
        if iletter5 == 1:
            letter5 = random.choice(letters)
        elif iletter5 == 2:
            letter5 = random.choice(vowels)
        elif iletter5 == 3:
            letter5 = random.choice(consonants)
        elif iletter5 == 4:
            letter5 = raw_input('what is the specific letter you want? (for letter 5)')
        
        names = letter1 + letter2 + letter3 + letter4 + letter5
        return(names)
        
    j = 1
    for j in range(nnames):
        print(mgenerator())