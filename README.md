# spring-microservice-zookeeper-example
This is an basic example project to show how we can use spring boot with zookeeper and also swagger-codegen and H2 database with spring data.

After clone this project to your local repo, first you have to install zookeeper and run server. If you don't have an idea about how you can install and run zookeeper you can search for any forum about it.

After start zookeeper service registry you will ready to run this app. In this application we have three service. Fisrt one is Customer which runs on 8081 port and store Customers in a H2 embeded database. Second one is Product service which runs on 8082 post on server and store Products in a H2 database which called product_db. The last one is Order service. This one runs on 8083 porst on server. And this service reachs other services(product and customer) on a zookeeper service registry.

After run Product and Customer service you should add some product and customer via sevice to database. And then you can get this product and customer via Order services with its IDs. I added an request example to call Product and Cutomer service via Order service. 

Endpoint URL and request example for Order service;

URL: http://localhost:8083/order
Method: POST
Request Body: 
{
 "productId": "2",
 "customerId":"1",
 "amount":2
} 
