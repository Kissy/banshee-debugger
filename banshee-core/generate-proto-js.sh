#!/bin/sh
proto2js Proto/Debug/DebugPropertyDTO.proto -class > Js/DebugPropertyDTO.js
proto2js Proto/Debug/DebugObjectDTO.proto -class > Js/DebugObjectDTO.js
proto2js Proto/Debug/DebugHolderDTO.proto -class > Js/DebugHolderDTO.js