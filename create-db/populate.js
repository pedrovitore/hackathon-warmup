var csvjson = require('csvjson');
var fs = require('fs');

const MongoClient = require('mongodb').MongoClient;
const uri = "mongodb://localhost:27017/hackathon";

fs.readFile('data/2019.csv', 'utf8', function (err, contents) {
    // console.log(err);
    // console.log(contents);

    MongoClient.connect(uri, { useNewUrlParser: true }, (err, client) => {
    	if (err) {
    		console.log(err);
    		return;
		}
    	db = client.db('hackathon');

		var obj = csvjson.toObject(contents, {delimiter: ',', quote: '\"'});
		obj.forEach((item) => {
			var versions = item.body_styles.split(',');
			versions.forEach((version) => {
				var veiculo = {
					marca: item.make,
					modelo: item.model + " " + version,
					ano: item.year,
					valor: randomValue(999) * 100
				}
				db.collection('veiculos').insertOne(veiculo);
				console.log("Vehicle saved: "+ JSON.stringify(veiculo));
			});
		});
    });
});

function randomValue(max) {
	return Math.floor(Math.random() * max) + 1;  
}


