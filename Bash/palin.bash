#!/bin/bash
echo -n  "This is a palidrome detector program: "
read string
i=1
len=$((${#string}+1))
mid=$(($len/2))

while [ $i -le $mid ];
do
if [ "$(echo "$string" | cut -c$i)" != "$(echo "$string" | cut -c$(($len-$i)))" ]
then 
echo "$string IS NOT a Palindrome"
exit
fi
i=$(($i+1))
done
echo "$string IS a Palindrome"
