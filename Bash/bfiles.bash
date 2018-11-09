#!/bin/bash

echo "please enter the file name in the folder you want to backup: "
read filename
date=$(date +%Y-%m-%d)
cp -r "$filename" "$filename _backup_( $date )"
