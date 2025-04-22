#!/bin/bash

#############
# common
#############
# display git branch on commandline
curl https://raw.githubusercontent.com/git/git/master/contrib/completion/git-prompt.sh > ~/.git-prompt.sh
curl https://raw.githubusercontent.com/git/git/master/contrib/completion/git-completion.bash > ~/.git-completion.bash
echo "source ~/.git-prompt.sh" >> ~/.bashrc
echo "source ~/.git-completion.bash" >> ~/.bashrc
echo "PS1='\${debian_chroot:+(\$debian_chroot)}\[\033[01;32m\]\u \[\033[01;34m\]\w\[\033[00m\]\$(__git_ps1) \$ '" >> ~/.bashrc

#############
# Kotlin, Java
#############
cd gradle && ./gradlew clean build wrap && cd ..

#############
# Post execute
#############
./login-atcoder.sh
