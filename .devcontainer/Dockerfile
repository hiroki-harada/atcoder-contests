FROM ubuntu:24.04


#############
# common
#############
SHELL ["/bin/bash", "-o", "pipefail", "-c"]
ARG DEBIAN_FRONTEND=noninteractive

ARG USER_NAME=gitpod
RUN useradd -l -u 33333 -G sudo -md /home/$USER_NAME -s /bin/bash $USER_NAME && \
    echo "$USER_NAME:$USER_NAME" | chpasswd
USER $USER_NAME


USER root
RUN apt-get update && apt-get install -yq --no-install-recommends \
    sudo git curl dirmngr bsdmainutils ca-certificates \
    unzip zip \
    # oj needed
    locales build-essential zlib1g-dev libssl-dev libbz2-dev \
    libncurses-dev libffi-dev libreadline-dev liblzma-dev \
    sqlite3 libsqlite3-dev \
    && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/*
RUN locale-gen en_US.UTF-8
USER $USER_NAME


#############
# Kotlin
#############
# install the version manager for Kotlin, Gradle and Java
ARG JAVA_VERSION=17.0.8.fx-zulu
ARG KOTLIN_VERSION=1.8.20
RUN curl -s "https://get.sdkman.io" | bash
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && \
    sdk i java $JAVA_VERSION && \
    sdk use java $JAVA_VERSION --default && \
    sdk i kotlin $KOTLIN_VERSION
RUN echo 'source "$HOME/.sdkman/bin/sdkman-init.sh"' >> ~/.bashrc


#############
# Online Judge Tools
#############
ARG PYTHON_VERSION=3.12.3
RUN curl -fsSL https://pyenv.run | bash && \
    export PYENV_ROOT="$HOME/.pyenv" && \
    export PATH="$PYENV_ROOT/bin:$PATH" && \
    eval "$(pyenv init - bash)" && \
    echo 'export PYENV_ROOT="$HOME/.pyenv"' >> ~/.bashrc && \
    echo '[[ -d $PYENV_ROOT/bin ]] && export PATH="$PYENV_ROOT/bin:$PATH"' >> ~/.bashrc && \
    echo 'eval "$(pyenv init - bash)"' >> ~/.bashrc && \
    pyenv install $PYTHON_VERSION && \
    echo "export PATH=\$PATH:$HOME/.pyenv/versions/$PYTHON_VERSION/bin" >> ~/.bashrc && \
    pyenv global $PYTHON_VERSION

#############
# Others
# #############
# add path to custom command directory
RUN echo "export PATH=\$PATH:/workspace/atcoder-contests/command" >> ~/.bashrc
RUN echo "[[ -s \"$HOME/.bashrc\" ]]" >> ~/.bash_profile

# avoid below error in building docker container
# ERROR --: /root/.nvm/nvm.sh: No such file or directory
ENV HOME=/home/$USER_NAME

USER $USER_NAME
CMD ["/bin/bash"]
