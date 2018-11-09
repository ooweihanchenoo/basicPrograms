#!/bin/bash

read -p "Enter A Sentence without any spaces in between: " line

echo "$line" | sed 's/\([A-Z]\)/ \1/g'
