#!/bin/bash

echo "Please Enter A Number in Seconds"
read seconds

for ((i=$seconds;i>0;i=$i-1))
do
printf "%3d\r" "$i"
sleep 1
done
