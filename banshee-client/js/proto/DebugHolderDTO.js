var debugHolderProtoBuilder = dcodeIO.ProtoBuf.newBuilder("DebugHolderDTO").create([
    {
        "name": "DebugPropertyProto",
        "fields": [
            {
                "rule": "required",
                "type": "string",
                "name": "key",
                "id": 20,
                "options": {}
            },
            {
                "rule": "required",
                "type": "string",
                "name": "value",
                "id": 21,
                "options": {}
            },
            {
                "rule": "optional",
                "type": "string",
                "name": "category",
                "id": 22,
                "options": {
                    "default": "default"
                }
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    },
    {
        "name": "DebugObjectProto",
        "fields": [
            {
                "rule": "required",
                "type": "string",
                "name": "id",
                "id": 10,
                "options": {}
            },
            {
                "rule": "required",
                "type": "string",
                "name": "name",
                "id": 20,
                "options": {}
            },
            {
                "rule": "optional",
                "type": "string",
                "name": "category",
                "id": 30,
                "options": {
                    "default": "default"
                }
            },
            {
                "rule": "repeated",
                "type": "DebugPropertyProto",
                "name": "properties",
                "id": 40,
                "options": {}
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    },
    {
        "name": "DebugHolderProto",
        "fields": [
            {
                "rule": "repeated",
                "type": "DebugObjectProto",
                "name": "objects",
                "id": 1,
                "options": {}
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    }
]).build("DebugHolderDTO");
