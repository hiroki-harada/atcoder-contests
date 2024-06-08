#!/bin/bash

readonly URL=https://atcoder.jp/

source .env

# check if signed in
oj login --check -u $ATCODER_USER_NAME --use-browser never $URL

# if not signed in, exex sign in
if [ $? -eq 1 ]; then
    oj login -u $ATCODER_USER_NAME --use-browser never $URL
fi
