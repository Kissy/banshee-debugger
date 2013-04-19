var _root = dcodeIO.ProtoBuf.newBuilder().create([
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
                "type": "bytes",
                "name": "value",
                "id": 2,
                "options": {}
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    }
]).build();
