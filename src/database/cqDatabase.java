package database;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class cqDatabase {
	
	public static void main(String args[]) throws UnknownHostException{
		makeConnection();
	}
	
	public static void makeConnection() throws UnknownHostException{
		
		 MongoClientURI uri  = new MongoClientURI("mongodb://cq_api:cqdemo@ds053778.mongolab.com:53778/cityquest"); 
	        MongoClient client = new MongoClient(uri);
	        DB db = client.getDB(uri.getDatabase());
	        Set<String> names = db.getCollectionNames();
	        System.out.println(names);
	        DBCollection collection = db.getCollection("User");
	        DBCursor cursor = collection.find();
	    	while(cursor.hasNext()) {
	    	    System.out.println(cursor.next());
	    	}
	        
		
	}

}
