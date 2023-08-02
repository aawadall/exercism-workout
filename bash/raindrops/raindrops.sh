#!/usr/bin/env bash
# raindrops exercise solution

# short circuit if number of arguments is not 1 
USAGE_MSG="Usage: $0 <number>"
if [ $# -ne 1 ]; then
  echo "$USAGE_MSG"
  exit 1
fi

# globals
# declare -A sounds
sounds=()
sounds[3]="Pling"
sounds[5]="Plang"
sounds[7]="Plong"

# add factor function 
add_factor() {
    if (( $1 % $2 == 0 )); then
        echo "$3"
    fi
}

# build factor sound function
build_factor_sound() {
    number=$1

    sound=""

    for factor in "${!sounds[@]}"; do
        sound+=$(add_factor "$number" "$factor" "${sounds[$factor]}")
    done

    echo "${sound:-$number}"
}

# numeric argument 
build_factor_sound "$1"