#!/bin/bash
if [[ $1 = "-h" ]]; then
  echo "$(basename $0) is custom command"
  echo "Usage : \"login-atcoder\"  then check whether is logined or not atcoder, and login if not yet"
  echo ""
  exit 0
fi


readonly URL=https://atcoder.jp/

source .env

# check if signed in
oj login --check -u $ATCODER_USER_NAME --use-browser never $URL

# if not signed in, exex sign in
if [ $? -eq 1 ]; then
    oj login -u $ATCODER_USER_NAME --use-browser never $URL
fi
