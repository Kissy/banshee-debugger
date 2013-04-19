var debugProtoBuilder = dcodeIO.ProtoBuf.newBuilder("DebugDTO").create([
    {
        "name": "PropertyProto",
        "fields": [
            {
                "rule": "required",
                "type": "string",
                "name": "name",
                "id": 1,
                "options": {}
            },
            {
                "rule": "repeated",
                "type": "string",
                "name": "value",
                "id": 2,
                "options": {}
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    },
    {
        "name": "DebugPropertyProto",
        "fields": [
            {
                "rule": "optional",
                "type": "string",
                "name": "category",
                "id": 1,
                "options": {
                    "default": "default"
                }
            },
            {
                "rule": "repeated",
                "type": "PropertyProto",
                "name": "properties",
                "id": 2,
                "options": {}
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    },
    {
        "name": "DebugEntityProto",
        "fields": [
            {
                "rule": "required",
                "type": "string",
                "name": "id",
                "id": 1,
                "options": {}
            },
            {
                "rule": "required",
                "type": "string",
                "name": "name",
                "id": 2,
                "options": {}
            },
            {
                "rule": "optional",
                "type": "string",
                "name": "category",
                "id": 3,
                "options": {
                    "default": "default"
                }
            },
            {
                "rule": "repeated",
                "type": "DebugPropertyProto",
                "name": "properties",
                "id": 4,
                "options": {}
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    },
    {
        "name": "DebugProto",
        "fields": [
            {
                "rule": "repeated",
                "type": "DebugEntityProto",
                "name": "entities",
                "id": 1,
                "options": {}
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    }
]).build("DebugDTO");
