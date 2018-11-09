#!/bin/bash
var1=$( cut -d : -f 1 /etc/passwd )
echo "The total number of users in the system: "
echo "$var1" | wc -w
var2=$( users | wc -w )
echo "The total number of logged in users: "
echo "$var2"
