> bai1 :
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

> bai 2:
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
> bai 3:
- Code python(GEN.py) để extract title từ các file data_1.json, data_2.json, data_3.json

- Sử dụng pivi (pyhton library tách từ tiếng Việt theo ngữ nghĩa) rồi ghi lại vào file out.json mới

- Tạo index title_suggest dùng cho search suggestion
```
{
    "mappings": {
        "properties" : {
            "suggest_title" : {
                "type" : "completion"
            }
        }
    }
}
```
- Đẩy dữ liệu lên ElasticSearch:

curl -s -H "Content-Type: application/json" -XPOST 172.17.80.25:9200/_bulk --data-binary @out.json

- Search bằng query DSL:
```
{
    "suggest": {
        "title-suggest" : {
            "prefix" : "thành",
            "completion" : {
                "field" : "suggest_title",
                "skip_duplicates": true,
                "size" : 10
            }
        }
    }
}
```
