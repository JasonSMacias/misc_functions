#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 10/22/2020
# Description: Checks bash result agains Java result, using arguments or else interactively
# Usage: ./check_against_java.sh <problem number>
#############################################
set -euf -o pipefail



GRN='\033[1;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

java_problems_path="../../java/euler/"

set +u
if [[ -z $1 ]]; then
    echo Please enter the number of the bash script to check
    read
    problem_number=$REPLY
    else
    problem_number=$1
fi
set +u
set +f
is_bash_input_there=''
is_java_input_there=''
echo "Checking files in java directory:"
for file in ${java_problems_path}*.java;
do
    echo $file
    if [[ $(basename ${file}) == "Problem${problem_number}.java" ]]; then
        is_java_input_there=y
        printf "${GRN}*match*${NC}\n"
        break
    fi
done

echo "Checking files in bash directory:"
for file in *.sh;
do
    echo $file
    if [[ $file == "problem${problem_number}.sh" ]]; then
        is_bash_input_there=y
        printf "${GRN}*match*${NC}\n"
        break
    fi
done
set -f

if [[ -z $is_java_input_there ]]; then
    echo Java file entered does not exist
    exit 1
fi
if [[ -z $is_bash_input_there ]]; then
    echo Bash file entered does not exist
    exit 1
fi

BASH_RESULT=$(bash "problem${problem_number}.sh")
cd $java_problems_path
# Compile all java problems
javac -d . Driver.java Problem1.java Problem2.java Problem3.java
JAVA_RESULT=$(java problems.Driver ${problem_number}) 

printf "\nresult from Java:\n"
echo $JAVA_RESULT
echo "result from Bash:"
echo $BASH_RESULT

if [[ $JAVA_RESULT -eq $BASH_RESULT ]]; then
    printf "\n${GRN}*Results Match*${NC}\n\n"
    exit 0

    printf "\n${RED}*Results Do Not Match*${NC}\n\n"
    exit 1
fi
