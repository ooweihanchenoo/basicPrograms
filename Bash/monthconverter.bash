#!/bin/bash

array[0]='January'
array[1]='February'
array[2]='March'
array[3]='April'
array[4]='May'
array[5]='June'
array[6]='July'
array[7]='August'
array[8]='September'
array[9]='October'
array[10]='November'
array[11]='December'

echo "please enter a month in numerical" $var
read var
echo ${array[ $var-1 ]}

