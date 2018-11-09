reviews = open ("movieReviews.txt","r")
scores = { }
counts = { }
averages = { }
suminput = [ ]
nowords = [ ]
for l in reviews.readlines():
    l = l.strip().lower().split()
    rating = int(l[0])
    word = l[1:]
#------------ sum of each word (to test seperately) --------------------------    
    #for word in l:
        #if word not in words:
            #words[word] = rating
        #else:
            #words[word] += rating
#-----------------------------------------------------------------
#----------- counting the duplicates of each words ((to test seperately) ------------    
    #for c in l: 
        #if c not in count:
            #count[c] = 1
        #else:
            #count[c] += 1     
#print(count)
#------------------------------------------------------------------ 
#--------- combine count duplicates and sum of each words----------
    for c in l:                            # for loop the lin of the list
        if c not in counts:                # key = c 
            counts[c] = 1                  # counting each words (create new key and store new value)
        else:                              #
            counts[c] += 1                 # counting each words (adding onto previous value in counts dictionary)
        if c not in scores:                #
            scores[c] = rating             # rating of each words (create new key and store new value)
        else:                              #
            scores[c] += rating            # rating of each words (adding onto previous value in scores dictionary)
        averages[c] = scores[c]/counts[c]  # average of each words
        
usrinput = raw_input("Please Enter A sentence for review scores: ")# user input sentences 
li = usrinput.strip().lower().split()                              # break it down into list
length = len(li)                                                   # get the amount of the words in the list
for s in li:                                                       # for loop to scan the list 
    if s in averages:                                              # see if any words that is in the averages dictionary
        suminput.append(averages[s])                               # add the values of words in averages dictionary into the list 
        sumin = 0                                                  # initialize sumin list 
        for su in suminput:                                        # using for loop into the list
            sumin += su                                            # getting the sum of every values
averageinput = sumin/length                                        # find the average input 
print "\nThe score is: ", averageinput  

# if else statements to compare where average input belongs to which category

if 1 > averageinput > 0:
    print("This review is negative.")
elif 2 > averageinput > 1:
    print("This review is somewhat negative.")
elif 3 > averageinput > 2: 
    print("This review is neutral.")
elif 4 > averageinput > 3:
    print("This review is somewhat positive.")
elif averageinput > 4:
    print("This review is positive.")
    

#print(sumin)        
#print(length)
#print(suminput)
#print(sumin/length)       
       
#------------ average of each word (to test seperately) --------------------------------
            #average[c] = scores[c]/count[c]         
#------------------------------------------------------------------
#------------ output files to check (to test seperately)--------------------------------
#str1 = str(averages)
#text_file = open("averages.txt", "w")
#text_file.write(str1)
#text_file.close()
#------------------------------------------------------------------
