var _root = dcodeIO.ProtoBuf.newBuilder().create([
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
    }
]).build();
