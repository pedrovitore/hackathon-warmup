package hitbra.hackathon.warmup.spring;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Teste {

	public static void main(String[] args) {
		//Veículo alienado NAO PODE SER VENDIDO!!!
		//As pessoas que vendem fazem GAMBIARRA. transferência de dívida não garante que o carro transfere de dono.
		//Arriscadíssimo!!!
		//https://www.maiscredit.com.br/blog/como-transferir-um-veiculo-com-alienacao-fiduciaria/
		
		
		MongoClient client = new MongoClient("localhost",27017);
        MongoDatabase db = client.getDatabase("hackathon");
        MongoCollection<Document> collection = db.getCollection("veiculos");
        Document query = new Document();
        query.append("local","{ $regex: /, $options: 'i' }");
        Document setData = new Document();
        setData.append("status", "'Disponível'");
        Document update = new Document();
        update.append("$set", setData);
        //To update single Document  
        collection.updateMany(query, update);
        client.close();
	}
}
