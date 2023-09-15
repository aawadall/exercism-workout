#!/usr/bin/env bash

# main method
main() {
    # short circuit if no arguments
    if [[ $# -eq 0 ]]; then
        echo "false"
        exit 0
    fi

    # short circuit if arg 1 length < 26 
    if [[ ${#1} -lt 26 ]]; then
        echo "false"
        exit 0
    fi

    # convert to lowercase
    local lower=${1,,}

    # remove non-alphabetic characters
    local clean=${lower//[^a-z]/}

    # remove duplicates
    local unique=$(echo $clean | tr -d ' ' | fold -w1 | sort | uniq | tr -d '\n')

    # check if length of unique string is 26
    if [[ ${#unique} -eq 26 ]]; then
        echo "true"
    else
        echo "false"
    fi
} 

main "$@"
