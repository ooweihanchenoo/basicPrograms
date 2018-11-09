#!/bin/bash
groupadd CSC424
for ((i=0;i<10;i=$i+1))
do
num=$(($i+1))
useradd -um student$num -p  -g CSC424
echo "Student $num is created and added in CSC424"
studentname="student$num"
echo "#!/bin/bash
echo 'Hello $studentname, Welcome to CSC424'" > /home/$studentname/welcome.sh
done;
echo "done"
