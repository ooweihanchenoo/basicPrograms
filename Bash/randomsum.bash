#!/bin/bash

var1=$(($RANDOM %1000))
var2=$(($RANDOM %1000))
sum=$((var1+var2))

echo variable 1 is $var1
echo variable 2 is $var2

echo "What is the sum of those two numbers?" $varinput
read varinput

if [ $varinput == $sum ]
then
echo "Congradulation you are correct!"
else
echo "the correct number is" $sum
fi;
