#!/bin/sh
protoc Proto/Debug/*.proto --cpp_out=Cpp --java_out=Java
