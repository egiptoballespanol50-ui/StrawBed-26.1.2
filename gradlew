#!/bin/sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
app_path=$0

# Need this for daisy-chained symlinks.
while
    APP_HOME=${app_path%"${app_path##*/}"}
    [ -h "$app_path" ]
do
    cd "$(dirname "$app_path")"
    app_path=$(readlink "$app_path")
done

cd "$(dirname "$app_path")"
APP_HOME=$(pwd -P)
cd "$OLDPWD"
export APP_HOME

appName="Gradle"
appPath="$APP_HOME/gradlew"
appArgs="$@"

case "$(uname)" in
    Darwin*)
        cygwin=false
        darwin=true
        ;;
    CYGWIN*)
        cygwin=true
        darwin=false
        ;;
    MSYS* | MINGW*)
        cygwin=true
        darwin=false
        ;;
    NONSTOP*)
        cygwin=false
        darwin=false
        ;;
esac

if [ "$cygwin" = true ] || [ "$darwin" = true ] || [ "$NONSTOP" = true ]; then
    set -m
    case "$(uname)" in
        Darwin*)
            JAVA_MODULE_OPTS="-XX:+IgnoreUnrecognizedVMOptions --add-modules java.base"
            ;;
    esac
    CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar
    export CLASSPATH
    exec "$JAVA_EXE" $JAVA_OPTS $JAVA_MODULE_OPTS -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
else
    exec "$JAVA_EXE" $JAVA_OPTS -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
fi
