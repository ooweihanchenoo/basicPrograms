#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Fri Jun  1 14:50:50 2018

@author: wei-hanchen
"""
print('-----welcome to my program launcher-----')
options = input('---pick your option--- \n choose 1 to generate multiple letters in a name \n choose 2 to generate multiple names in 5 letters ')
if options == 1:
    import mletters
    mletters.main()
elif options == 2:
    import mnames
    mnames.main()
else:
    print('that is not an option....... please try again')