# Redirection on same app

This redirects one function to another in the same application.  
This can easily be achieved in other ways, but there may be cases where
the source can't be changed for some reason, or maybe having this as an 
external yaml configuration is more convenient.

To run this, execute:  

```
gradle build
java -jar ../bcbridge.jar bcbridge.yaml
```