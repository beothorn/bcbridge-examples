# GRPC skip

On construction

In this example we have a GRPC client and a server and we want 
them to skip calling the network and just do a function call.

To run this, execute:  

```
cd server
mvn clean package
cd ..
cd client
mvn clean package
cd ..
java -jar ../bcbridge.jar bcbridge.yaml
```
