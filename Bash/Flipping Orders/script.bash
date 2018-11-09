#!/bin/bash
#10-31-2018
#Wei Han Chen
#----------------Checking see if B.TXT exist--------------
if [ -e B.TXT ]
then 
rm B.TXT
fi
#----------------------------------------------------------
#----------------Checking see if A.TXT exist--------------
if [ -e A.TXT ]
then

#read the text file, strip down the empty lines, then put each line into array
array=($(grep '[^[:blank:]]' < A.TXT))

l=${#array[@]}	#length of the array
i=0	#set i=0
j=1	#set j=1

#while loop the length of the array
while [ $i -le $l ];
do
printf "${array[$j]}\n${array[$i]}\n\n"	#print the traditional character first then simplified character
i=$(($i+2))	#add 2 everytime it finishes a loop, i = all the even numbers in the length of the array
j=$(($j+2))	#add 2 every time it finish a loop, j = all the odd numbers in the length of the array
done >> B.TXT	#output / create a text file

else
echo "A.TXT CANNOT FOUND"
fi
