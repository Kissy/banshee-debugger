var _root = dcodeIO.ProtoBuf.newBuilder().create([
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
    }
]).build();
