#!/usr/bin/env bash

# Usage message
USAGE="Usage: error_handling.sh <person>"

# if arguments != 1, print usage
if [[ $# -ne 1 ]]; then
    echo "$USAGE"
    exit 1
fi

# Name is arg 1
NAME=$1

# Print hello, name
echo "Hello, $NAME"