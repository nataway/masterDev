##bai1 :
```
GET dantri/_search
{
    "query": {
        "bool" : {
            "must" : [
                {
                    "multi_match" : {
                        "query":  "an toàn",
                        "type":   "phrase",
                        "fields": [ "title", "description", "content"]
                    }
                },
                {
                    "multi_match" : {
                        "query":  "đường bộ",
                        "type":   "phrase",
                        "fields": [ "title", "description", "content"]
                    }
                },
                {
                    "multi_match" : {
                        "query":  "đường sắt",
                        "type":   "phrase",
                        "fields": [ "title", "description", "content"]
                    }
                },
                {
                    "range": {
                        "time": {
                            "gte": 1356998400,
                            "lt": 1388534400
                        }
                    }
                }
            ]
        }
    }
}
```

##bai 2:
```
GET dantri/_search
{
    "query": {
        "bool" : {
            "must" : {
                "prefix": {
                "title.keyword": "Hà Nội"
            }
            },
            "must_not" :{
                "match_phrase": {
                    "description": {
                        "query": "Hà Nội"
                    }
                }
            }
        }
    },
    "sort" : [
        { "time" : "desc" }
    ]
}
```
