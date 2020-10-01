#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 9/30/2020
# Description: Checks bash result agains Racket result, using arguments or else interactively
# Usage: ./check_against_racket.sh <bash script name> <racket file name>
#############################################

GRN='\033[1;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

bash_script=$1
racket_file=$2
racket_path="../../scheme/euler/${2}"

if [[ -z $1 ]]; then
    echo Please enter the name of the bash script
    read
    bash_script=$REPLY
fi

if [[ -z $2 ]]; then
    echo Please enter the name of the Racket file
    read
    racket_file=$REPLY
fi

echo "Checking files in racket directory:"
for file in ../../scheme/euler/*.rkt;
do
    echo $file
    if [[ $file == $racket_path ]]; then
        is_racket_input_there=y
        printf "${GRN}*match*${NC}\n"
        break
    fi
done

echo "Checking files in bash directory:"
for file in *.sh;
do
    echo $file
    if [[ $file == $bash_script ]]; then
        is_bash_input_there=y
        printf "${GRN}*match*${NC}\n"
        break
    fi
done

if [[ -z $is_racket_input_there ]]; then
    echo Racket file entered does not exist
    exit 1
fi
if [[ -z $is_bash_input_there ]]; then
    echo Bash file entered does not exist
    exit 1
fi

RKT_RESULT=$(racket ${racket_path})
BASH_RESULT=$(bash ${bash_script})

printf "\nresult from Racket:"
echo $RKT_RESULT
echo result from Bash
echo $BASH_RESULT

if [[ $RKT_RESULT -eq BASH_RESULT ]]; then
    printf "\n${GRN}*Results Match*${NC}\n\n"
    exit 0

    printf "\n${RED}*Results Do Not Match*${NC}\n\n"
    exit 1
fi 
