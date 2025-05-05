#!/bin/bash

#############
# Kotlin, Java
#############
cd gradle && ./gradlew clean build wrap && cd ..

#############
# Online Judge Tools
#############
pip install --upgrade pip
pip install setuptools
pip3 install online-judge-tools
pip install aclogin
