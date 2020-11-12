#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 
# Description: 
# Usage: ./file.sh <necessary arg> [optional arg]
#############################################
set -euf

cd ../../bash/euler

./check_all_against_racket.sh
read -p "Racket tests complete, press space to coninue"
./check_all_against_js.sh
read -p "Javascript tests complete, press space to continue"
./check_all_against_java.sh
read -p "Java tests conplete, press space to continue"
echo -e "\n**** All tests complete ****"
read -p "Would you like to remove compiled Java files? Y/n" remove_files
if [[ ${remove_files^} == 'Y' ]]; then
  cd ../../java/euler/
  ls -l
  echo "Files not yet removed"
  # Remove Java class files
else
  echo 'Leaving Java class files'
fi
