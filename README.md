# bcbridge-examples

A collection of examples using bcbridge

[bcbridge](https://github.com/beothorn/bcbridge) is a container for java applications 
that enables bytecode manipulation through configuration.  
On a yaml file you can configure:  
- Redirect functions calls from one app to another
- Overwrite environment variables
- Redirect app output to file

## Hello world

Minimal setup to run bcbridge.  

## Redirection on same app

Redirects a function inside a single app.

## Multitenant  

Runs two apps on the same process with different environment variable.

## GRPC skip

Runs three apps, a client, a server and a mapper. Client is supposed to talk to server through the neywork using GRPC, but the mapper intercepts the calls and send them directly to the server.
