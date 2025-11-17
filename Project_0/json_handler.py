import json

def json_dump(file_name, data):
    with open(file_name, "w") as f:
        json.dump(data, f, indent=2, sort_keys=False)

def json_load(file_name):
    with open(file_name, "r") as f:
        return json.load(f)
