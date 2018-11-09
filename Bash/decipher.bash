#!/bin/bash
echo " "
echo "---THIS PART IS DECIPHER---"

echo -n "Enter a Sentence to Decipher: "
read line
echo -n "Enter the decipher position: "
read position

position1=$((-1*$position))
length=$((${#line}+${position1}))
echo "${line:$position}${line:0:position}"
