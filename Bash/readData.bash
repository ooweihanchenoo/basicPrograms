#!/bin/bash
if [ $# -gt 0 ];then
    file=$1
else
    file="data"
fi

#We first exam whether the file exist or not. If the file exist, delete the file
if [ ! -e $file ];
then
    echo "$file does not exist!"
    exit 1
fi
min=$((2**63-1))
max=0
sum=0
count=0
while read -r num
do
   if [ $num -lt $min ];then
	min=$num
   fi
   if [ $num -gt $max ];then
	max=$num
   fi
   sum=$(($sum+$num))
   count=$(($count+1))
done < $file

echo "The sum is $sum"
echo "The average is $((sum/count))"
echo "The max number is $max"
echo "The min number is $min"
