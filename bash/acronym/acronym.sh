#!/usr/bin/env bash
# Acronym generator
# Assuming that the first argument is the string to analyze

phrase=$1

# replace remove apostrophes
phrase=${phrase//\'/}

# replace non alphanumeric characters with spaces
phrase=${phrase//[^a-zA-Z0-9]/ }

# convert to uppercase
phrase=${phrase^^}

# split into words array
words=($phrase)

# iterate over words and print the first letter
for word in "${words[@]}"; do
    printf "%s" "${word:0:1}"
done