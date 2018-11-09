#!/bin/bash
name="student"
file="records"
date1=$(date +%Y)
num1=000
num2=00
single=10

if [ -e $file ];then
   rm -f $file
fi

echo -n "How many students records you want to generate?"
read nums

function genRec(){
if [ $i -lt $single ];
then
echo "$date1$num1$i"
else
echo "$date1$num2$i"
fi
}

for ((i=1;i<=$nums;i++));
do
student="$name$i"
student="$student $(genRec)"
echo $student>>$file
done
