#!/usr/bin/env bash
# Description: Check if a number is an Armstrong number

# Get Number of Digits
function get_number_of_digits() {
    local number="$1"
    local number_of_digits=0
    while [ $number -gt 0 ]; do
        number_of_digits=$((number_of_digits + 1))
        number=$((number / 10))
    done
    echo "$number_of_digits"
}

# Get Poewr
function get_power() {
    # Special Case; if 0^0 -> 0
    if [ $1 -eq 0 ]; then
        echo 0
        return
    fi
    # Normal Case
    local number="$1"
    local power="$2"
    local result=1
    for ((i = 1; i <= power; i++)); do
        result=$((result * number))
    done
    echo "$result"
}

# Main Function
function main() {
    # Check if the number of arguments is equal to 1
    if [ $# -ne 1 ]; then
        echo "Usage: $0 <number>"
        exit 1
    fi

    # Check if the argument is a number
    if ! [[ "$1" =~ ^[0-9]+$ ]]; then
        echo "Error: Only positive numbers are allowed"
        exit 1
    fi

    local number="$1"
    local number_of_digits=$(get_number_of_digits "$number")

    # Calculate the sum of the digits raised to the power of the number of digits
    local sum=0
    local numbers=($(echo "$number" | grep -o .))
    for i in "${numbers[@]}"; do
        sum=$((sum + $(get_power "$i" "$number_of_digits")))
    done

    # Check if the number is an Armstrong number
    if [ $sum -eq "$number" ]; then
        echo "true"
    else
        echo "false"
    fi
}

main "$@"
