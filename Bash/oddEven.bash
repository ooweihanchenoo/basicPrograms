#!/bin/bash
odd=0
even=0
for ((i=0;i<100;i=$i+1))
    do
	if [ $((RANDOM%2)) -eq 0 ];
	then
	    even=$(($even+1))
	else
	    odd=$(($odd+1))
	fi
    done
echo "There are $odd odd numbers"
echo "There are $even" even numbers
