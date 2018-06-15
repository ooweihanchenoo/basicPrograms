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
    
    print('-----this program will generate multiple letters within a name-----')
    
    def generator ():
        i = 1
        iletter = []
        nletters = input('how many letters do you want in your name? ')
        while i <= nletters:
            input_letter = input('1 for letters, 2 for vowels, 3 for consonants, 4 for any specific letter ')
            if input_letter == 1:
                iletter.append(random.choice(letters))
            elif input_letter == 2:
                iletter.append(random.choice(vowels))
            elif input_letter == 3:
                iletter.append(random.choice(consonants))
            elif input_letter == 4:
                iletter.append(raw_input('what is the specific letter you want? '))
            i+=1
        name = ("".join(iletter))
        return (name)
        
    print(generator())
