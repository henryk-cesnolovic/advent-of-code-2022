#!/bin/bash

usage() { echo "Usage: $0 [-d N] [-s 1|2] [-t]" 1>&2; exit 1; }

while getopts ":d:s:th:" o; do
    case "${o}" in
        s)
            SOLUTION="Solution"${OPTARG}
            ;;
        d)
            DAY=day${OPTARG}
            ;;
        t)
            TEST=true
            ;;
        *)
            usage
            ;;
    esac
done
shift $((OPTIND-1))

if [ -z "${DAY}" ] || [ -z "${SOLUTION}" ]; then
    usage
fi

[ -z $TEST ] && INPUT=$DAY/input/input.txt || INPUT=$DAY/input/input_test.txt

time scala-cli run $DAY/src/solution.scala --main-class $SOLUTION < $INPUT
