#! /bin/bash

read -p "What is the temperature? (In Celsius): " celsius
fahrenheit=$((celsius*9/5+32))
echo "The temperature in Fahrenheit will be: $fahrenheit "

