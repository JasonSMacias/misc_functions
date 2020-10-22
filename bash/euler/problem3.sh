#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 10/22/20 
# Description: Project euler problem 3
# Usage: ./problem3.sh 
#############################################
# The prime factors of 13195 are 5, 7, 13 and 29.
# What is the largest prime factor of the number 600851475143 ?
set -euf -o pipefail

get_LPF() {
  if [[ $# -ne 1 ]]; then
    echo "one argument required"
    exit 1
  fi
  number=$1
  ret_val=1
  sqrt_num=$(( $(bc <<< "sqrt($number)" ) + 1 ))
  
  while [[ $(( number % 2 )) -eq 0 ]]; do
    ret_val=2
    number=$(( number / 2 ))
  done

  for (( i = 3; i < $sqrt_num; i = i + 1 ))
  do
    while [[ $(( number % i )) -eq 0 ]]; do
      ret_val=$i
      number=$(( number / i ))
    done
  done
  if [[ $number -gt 2 ]]; then
    ret_val=$number
  fi
  echo $ret_val
}

# get_LPF $(( 13195 * 2 )) #29
# get_LPF "13195" #29
get_LPF "600851475143" # 6857