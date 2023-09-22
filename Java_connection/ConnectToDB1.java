import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.Iterator;
import org.bson.Document;
import com.mongodb.MongoClient; 
import com.mongodb.BasicDBObject;
 
public class ConnectToDB1
{ 
   public static void main( String args[] ) 
   {  
      // Creating a Mongo client 
      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
     
	 // Accessing the database 
      MongoDatabase database = mongo.getDatabase("temp"); 
      System.out.println("Databse connected");     
	  
	  MongoCollection<Document> collection = database.getCollection("test1"); //accessing collection
      System.out.println("Collection sampleCollection1 selected successfully");
		
		
	  // Inserting Documents 
	  
      Document document = new Document(); 
      document.append("name", "B");
      document.append("age", 15); 
      	  
      collection.insertOne(document); 
	  System.out.println("Document inserted successfully");
	  
	  
	  
	  // Deleting the Documents 
      collection.deleteMany(Filters.eq("name", "B"));
      System.out.println("Document deleted successfully...");   
	  
	  
	  // updating documents
	  BasicDBObject updateDocument = new BasicDBObject();
	  updateDocument.append("$set", new BasicDBObject().append("name", "C"));

	  BasicDBObject searchQuery2 = new BasicDBObject().append("name", "A");

	  collection.updateMany(searchQuery2, updateDocument);
	  
	  System.out.println("Document Updated successfully..."); 
   } 
} 
