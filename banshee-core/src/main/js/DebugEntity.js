var _root = dcodeIO.ProtoBuf.newBuilder().create([
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
    }
]).build();
