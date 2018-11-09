#!/bin/bash

usrs=$( cut -d : -f 1 -n /etc/passwd)
nums=$( cut -d : -f 1 /etc/passwd | wc -w)

array=($(cut -d : -f 1 -n /etc/passwd))
length=${#array[@]}

for ((i=1;i<$length;i=$i+1));
do
echo "Account Number: $i | ${array[$i]}"
done
