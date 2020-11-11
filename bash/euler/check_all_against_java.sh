#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 10/22/20 
# Description: Checks all bash result against Java results
# Usage: ./check_all_against_java.sh
#############################################

GRN='\033[1;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

printf "\nChecking Problem 1:\n"
./check_against_java.sh 1
if [[ $? -eq 0 ]]; then
    echo Problem 1 passed
    else
    echo Problem 1 failed
    are_failures=Y
fi

printf "\nChecking Problem 2:\n"
./check_against_java.sh 2
if [[ $? -eq 0 ]]; then
    echo Problem 2 passed
    else
    echo Problem 2 failed
    are_failures=Y
fi

printf "\nChecking Problem 3:\n"
./check_against_java.sh 3
if [[ $? -eq 0 ]]; then
    echo Problem 3 passed
    else
    echo Problem 3 failed
    are_failures=Y
fi

printf "\nChecking Problem 4:\n"
./check_against_java.sh 4
if [[ $? -eq 0 ]]; then
    echo Problem 4 passed
    else
    echo Problem 4 failed
    are_failures=Y
fi

if [[ -z $are_failures ]]; then
    printf "\n==========\n${GRN}All Problems Passed${NC}\n\n"
    else
    printf "\n==========\n${RED}Some Problems Failed${NC}\n\n"
fi
