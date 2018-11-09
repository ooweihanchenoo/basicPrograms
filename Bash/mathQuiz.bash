#!/bin/bash
num1=$((RANDOM%1000))
num2=$((RANDOM%1000))

printf "%4d\n" $num1
printf "%4s\n" "+$num2"

read -p "The answer is:" ans

sum=$((num1+num2))
if [ $sum -eq $ans ];
then
   echo "You are right!"
else
   echo "You are wrong!"
   echo "The answer is $sum"
fi
