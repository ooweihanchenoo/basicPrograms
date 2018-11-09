#!/bin/bash

pig="ay"

echo -n "Pig Latin, Please Enter A Sentence: "
read -a array

for ((i=0;i<${#array[@]};i++));
do 
echo -n  "${array[$i]:1}${array[$i]:0:1}$pig"
done
echo " "
