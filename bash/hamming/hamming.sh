#!/usr/bin/env bash
# Hamming distance between two DNA strands

# Short circuit with error if args is not 2 
if [ $# -ne 2 ]; then
  echo "Usage: hamming.sh <string1> <string2>"
  exit 1
fi

leftStrand=$1
rightStrand=$2

# Short circuit with error if strings are not equal length
if [ ${#leftStrand} -ne ${#rightStrand} ]; then
  echo "left and right strands must be of equal length"
  exit 1
fi


# calculate distance 
distance=0

# while length of left and right > 0
while [ ${#leftStrand} -gt 0 ]; do
  # Compare left and right first char
  leftChar=${leftStrand:0:1}
  rightChar=${rightStrand:0:1}

  # increment distance if not equal
  if [ "$leftChar" != "$rightChar" ]; then
    ((distance++))
  fi

  # take out first char of left and right
  leftStrand=${leftStrand:1}
  rightStrand=${rightStrand:1}
done

echo $distance
