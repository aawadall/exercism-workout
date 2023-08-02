#!/usr/bin/env bash
# raindrops exercise solution

# add factor function 
add_factor() {
    if (( $1 % $2 == 0 )); then
        echo "$4$3"
    else
        echo "$4"
    fi
}

# build factor sound function
build_factor_sound() {
    NUMBER=$1

    # magic numbers
    PLING=3
    PLANG=5
    PLONG=7

    # magic words
    PLING_STR="Pling"
    PLANG_STR="Plang"
    PLONG_STR="Plong"

    # main logic
    SOUND=""

    # check if divisible by 3
    SOUND=$(add_factor $NUMBER $PLING $PLING_STR $SOUND)
    # check if divisible by 5
    SOUND=$(add_factor $NUMBER $PLANG $PLANG_STR $SOUND)
    # check if divisible by 7
    SOUND=$(add_factor $NUMBER $PLONG $PLONG_STR $SOUND)

    if [ -z "$SOUND" ]; then
        SOUND="$NUMBER"
    fi

    echo "$SOUND"
}

# short circuit if number of arguments is not 1 
USAGE_MSG="Usage: $0 <number>"
if [ $# -ne 1 ]; then
  echo "$USAGE_MSG"
  exit 1
fi

# numeric argument 
build_factor_sound $1