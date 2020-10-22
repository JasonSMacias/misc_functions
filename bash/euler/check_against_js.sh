#!/bin/bash

#############################################
# Author: Jason Macias
# Version: v1.0.0
# Date: 10/22/20 
# Description: Checks bash result agains Javascript result, using arguments or else interactively
# Usage: ./check_against_js.sh <problem number>
#############################################
set -euf -o pipefail

GRN='\033[1;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

js_problems_path="../../javascript/euler/"

set +u
if [[ -z $1 ]]; then
    echo Please enter the number of the bash script to check
    read
    problem_number=$REPLY
    else
    problem_number=$1
fi
set -u

set +f
is_bash_input_there=''
is_js_input_there=''
echo "Checking files in the javascript directory:"
for file in ${js_problems_path}*.js;
do
  if [[ $(basename ${file}) == "problem${problem_number}.js" ]]; then
    is_js_input_there=y
    printf "${GRN}*match*${NC}\n"
    break
  fi
done

echo "Checking files in bash directory:"
for file in *.sh;
do
  if [[ $file == "problem${problem_number}.sh" ]]; then
    is_bash_input_there=y
    printf "${GRN}*match*${NC}\n"
    break
  fi
done
set -f

if [[ -z $is_js_input_there ]]; then
    echo javascript file entered does not exist
    exit 1
fi
if [[ -z $is_bash_input_there ]]; then
    echo Bash file entered does not exist
    exit 1
fi

BASH_RESULT=$(bash "problem${problem_number}.sh")
cd $js_problems_path
JS_RESULT=$(node problem${problem_number}.js)

printf "\nresult from Javascript:\n"
echo $JS_RESULT
echo "result from Bash:"
echo $BASH_RESULT

if [[ $JS_RESULT -eq $BASH_RESULT ]]; then
    printf "\n${GRN}*Results Match*${NC}\n\n"
    exit 0
else
    printf "\n${RED}*Results Do Not Match*${NC}\n\n"
    exit 1
fi