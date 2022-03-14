
curl -v \
http://localhost:8080/products


curl -v \
http://localhost:8080/products/1

curl -v \
http://localhost:8080/products?name=fanta


curl -v -X DELETE http://localhost:8080/products/3

curl -v -H "Content-Type: application/json" -X POST http://localhost:8080/products \
	-d '{"createdBy":"dbracamo","updatedBy":"dbracamo","name":"sprite","description":"Refresco de lima","price":20.0}'