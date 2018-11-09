#!/bin/bash
if [ $# -gt 0  ];then
   file=$1
else
   file="data"
fi

#We first exam whether the file exist or not. If the file exist, delete the file
if [ -e $file ];
then
    rm -f $file
fi
for ((i=0;i<100;i=$i+1))
do
   echo $RANDOM>>$file
done
