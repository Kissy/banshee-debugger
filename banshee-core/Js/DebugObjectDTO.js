var _root = dcodeIO.ProtoBuf.newBuilder().create([
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
    }
]).build();
