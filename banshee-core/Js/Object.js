var _root = dcodeIO.ProtoBuf.newBuilder().create([
    {
        "name": "ObjectProto",
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
                "type": "ObjectPropertyProto",
                "name": "objectProperties",
                "id": 4,
                "options": {}
            }
        ],
        "enums": [],
        "messages": [],
        "options": {}
    }
]).build();
