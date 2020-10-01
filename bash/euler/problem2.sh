#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 10/1/2020
# Description: Project Euler problem 2
# Usage: ./problem1.sh
#############################################

# By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
second_to_last=0
last=1
total_evens=0

while [[ $last -lt 4000000 ]]; do
  if [[ $((last % 2)) -eq 0 ]]; then
    total_evens=$((total_evens + last))
  fi
  new_total=$((last + second_to_last))
  second_to_last=$last
  last=$new_total
done

echo $total_evens
