#!/bin/bash

if [ $# -lt 1 ]
then
	echo "Missing parameter"
	exit
fi
echo "Creating module $1"
module=$1

cd src/main/java/com/cleancodeheroes
mkdir -p $module "$module/domain"
mkdir -p "$module/adapter" "$module/adapter/in" "$module/adapter/out"
mkdir -p "$module/application" "$module/application/service" "$module/application/port" "$module/application/port/in" "$module/application/port/out"
