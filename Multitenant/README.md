# Multitenant

In this example the app is running twice, but each instance has different environment variables.  
The environment variables LANG is set to "en_us" on app MultitenantEN and port to 8080 and 
set to "pt_br" and port 8081 on MultitenantPT.  
Then they are printed on the console.  
To run this, execute:  

```
gradle build
java -jar ../bcbridge.jar bcbridge.yaml
```
