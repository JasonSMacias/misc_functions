#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 9/30/2020
# Description: Project Euler problem 1
# Usage: ./problem1.sh 
#############################################

# If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
# Find the sum of all the multiples of 3 or 5 below 1000.

ret_val=0

for x in {3..999}
do
    if [[ $(($x % 3)) -eq 0 || $(($x % 5)) -eq 0 ]]; then
        ret_val=$((ret_val + x))
    fi
done
echo The result is:
echo $ret_val