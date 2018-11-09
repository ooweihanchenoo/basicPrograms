#!/bin/bash

echo "Please Enter your first number: " $var1
read var1
echo "Please Enter your second number: " $var2
read var2
echo "Please Enter your third number: " $var3
read var3
echo "Please Enter your fourth number: " $var4
read var4
echo "Please Enter your fifth number: " $var5
read var5
echo "Please Enter your sixth numners: " $var6
read var6

sum=$(($var1+$var2+$var3+$var4+$var5+$var6))
average=$(($sum/6))

array=( $var1 $var2 $var3 $var4 $var5 $var6 );
max=${array[0]}
min=${array[0]}

for i in "${array[@]}"
do
if [[ "$i" -gt "$max" ]];
then max="$i"
fi
if [[ "$i" -lt "$min" ]];
then min=$i
fi
done

echo "The sum is: " $sum
echo "The average is: " $average
echo "The max is: " $max
echo "The min is: " $min
