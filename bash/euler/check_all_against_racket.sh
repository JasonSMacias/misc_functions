#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 10/1/2020
# Description: Checks all bash result against Racket results
# Usage: ./check_all_against_racket.sh
#############################################

GRN='\033[1;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

printf "\nChecking Problem 1:\n"
bash check_against_racket.sh problem1.sh problem1.rkt
if [[ $? -eq 0 ]]; then
    echo Problem 1 passed
    else
    echo Problem 1 failed
    are_failures=Y
fi

if [[ -z $are_failures ]]; then
    printf "\n==========\n${GRN}All Problems Passed${NC}\n\n"
    else
    printf "\n==========\n${RED}Some Problems Failed${NC}\n\n"
fi