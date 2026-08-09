# Maven plugin example

This project is the step-by-step test application for `bcbridge-maven-plugin`.

First, install the plugin locally:

```shell
cd /home/lucas/dev/bcbridge-maven-plugin
mvn install
```

Before packaging, the original compiled method prints its own message:

```shell
mvn clean compile
java -cp target/classes br.com.isageek.bcbridge.example.App
```

```text
original: Hello from code
```

Then package this example. The build invokes the plugin's `rewrite` goal during the `package` phase:

```shell
cd /home/lucas/dev/bcbridge-examples/mavenPlugin
mvn package
```

Run the packaged application:

```shell
java -jar target/bcbridge-maven-plugin-example-1.0.0-SNAPSHOT.jar
```

The packaged application now calls `printRedirected(String)` directly, with the original parameter relayed:

```text
redirected: Hello from code
```
