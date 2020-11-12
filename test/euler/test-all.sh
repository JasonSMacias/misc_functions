#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 11/12/16 
# Description: Run bash results against all others individually
# Usage: ./test-all.sh
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
