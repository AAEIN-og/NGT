import pymongo

myclient = pymongo.MongoClient("mongodb://localhost:27017/")

mydb = myclient["temp"]
print("Database Connected")

mycol = mydb["test1"]
print("Collection Connected")

#insert===============================
mydict = {"name":"Sunita","age":50}
x = mycol.insert_one(mydict)
print("Inserted")

#Updated==============================
myquery={"name":"Sunita"}
newvalues = {"$set":{"age":90}}
mycol.update_many(myquery,newvalues)
print("Updated")
#Delete===============================
myquery={"name":"XYZ"}
mycol.delete_many(myquery)
print("Deleted")

#select================================
for x in mycol.find():
    print(x)
