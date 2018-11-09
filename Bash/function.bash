#!/bin/bash
function check(){
if [ -e $pwd ];
then
return 0
else
return 1
fi
}
echo "Enter the name of the file: " ; read x
if check $x
then 
echo "$x exists!"
else
echo "$x does not exists!"
fi
