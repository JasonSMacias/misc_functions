#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 11/11/20 
# Description: Project Euler Problem 4
# Usage: ./problem4.sh
#############################################

# for safe scripts
set -euf -o pipefail

# A palindromic number reads the same both ways.
# The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
# Find the largest palindrome made from the product of two 3-digit numbers.

ret_val=0
for i in {100..999}; do
  for (( j = $i; j < 1000; j++)); do
    x=$(( i * j ))
    if [[ $x -gt $ret_val && $x == $( rev <<< $x ) ]]; then
      ret_val=$x
    fi
  done
done

echo $ret_val