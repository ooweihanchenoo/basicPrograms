#!/bin/bash
echo " "
echo "---THIS PART IS CAESAR CYPHER ENCRYPTOION---"

echo -n "Enter a Sentence to Caesar Cipher Encryption: "
read line
echo -n "Enter the amount of offset position: "
read position

position1=$((-1*$position))
length=$((${#line}+${position1}))
echo "${line:position1} ${line:0:${length}}"

