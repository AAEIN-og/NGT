import json
import pymongo

# Create a JSON file
data = {"name": "John Doe", "age": 30}
with open("a.json", "w") as f:
    json.dump(data, f)

# Persist the JSON file in a database
client = pymongo.MongoClient("localhost", 27017)
db = client.test # db name 
collection = db.json # collection name 
 
# Create a document from the JSON file
document = json.load(open("a.json"))
collection.insert_one(document)
print("Data inserted successfully")
# Close the database connection
client.close()