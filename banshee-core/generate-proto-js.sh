#!/bin/sh
proto2js Proto/Common/Property.proto -class > Js/Property.js
proto2js Proto/Debug/ObjectProperty.proto -class > Js/ObjectProperty.js
proto2js Proto/Debug/Object.proto -class > Js/Object.js
proto2js Proto/Debug/Debug.proto -class > Js/Debug.js