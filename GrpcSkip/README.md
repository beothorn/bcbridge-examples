# GRPC skip

In this example we have a GRPC client and a server and we want 
them to skip calling the network and just do a function call.  

For this, the configuration bridges calls to GRPC from the client to the server to go to a mapper instead.

To run this, execute:  

```
cd server
mvn clean package
cd ..
cd client
mvn clean package
cd mapper
mvn clean package
cd ..
java -jar ../bcbridge.jar bcbridge.yaml
```
