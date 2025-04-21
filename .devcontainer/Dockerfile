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
    && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/*
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
# Others
# #############
# add path to custom command directory
RUN echo "export PATH=\$PATH:/workspace/paiza-skillcheck/command" >> ~/.bashrc
RUN echo "[[ -s \"$HOME/.bashrc\" ]]" >> ~/.bash_profile

# avoid below error in building docker container
# ERROR --: /root/.nvm/nvm.sh: No such file or directory
ENV HOME=/home/$USER_NAME

USER $USER_NAME
CMD ["/bin/bash"]
