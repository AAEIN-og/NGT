import json

# Opening JSON file
f = open('a.json',)

# returns JSON object as
# a dictionary
data = json.load(f)

# Iterating through the json
# list
for i in data['employee']:
	print(i)

# Closing file
f.close()