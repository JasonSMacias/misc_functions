#!/bin/bash

find ./ -name '*.java' > sources.txt
javac @sources.txt
if [[ $? == '0' ]]; then
	echo 'The following classes were compiled'
cat sources.txt
fi

