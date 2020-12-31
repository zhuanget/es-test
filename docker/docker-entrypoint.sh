#!/bin/bash
set -e
if [[ $# -eq 0 ]] || [[ "${1:0:1}" = "-" ]]; then
    exec java -jar *.jar "$@"
else
    exec "$@"
fi