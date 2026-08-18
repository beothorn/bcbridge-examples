# Maven plugin example

This project is the step-by-step test application for `bcbridge-maven-plugin`.

First, install the plugin locally:

```shell
cd /home/lucas/dev/bcbridge-maven-plugin
mvn install
```

Before packaging, the original compiled methods print their own messages:

```shell
mvn clean compile
java -cp target/classes br.com.isageek.bcbridge.example.App
```

```text
original using default nameContains: Hello from code
original using named: Hello from code
original using namedIgnoreCase: Hello from code
original using nameStartsWith: Hello from code
original using nameStartsWithIgnoreCase: Hello from code
original using nameEndsWith: Hello from code
original using nameEndsWithIgnoreCase: Hello from code
original using nameContains: Hello from code
original using nameContainsIgnoreCase: Hello from code
original using nameMatches: Hello from code
original: redirect arguments
original: redirect no arguments
original: redirect this only
original: redirect this and arguments
original using enter arguments: enter arguments
original using enter no arguments: enter no arguments
original using enter this only: enter this only
original using enter this and arguments: enter this and arguments
original using exit arguments: exit arguments
original using exit no arguments: exit no arguments
original using exit this only: exit this only
original using exit this and arguments: exit this and arguments
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

The packaged application now demonstrates redirects plus enter/exit hooks with argument and receiver capture:

```text
redirected using default nameContains: Hello from code
redirected using named: Hello from code
redirected using namedIgnoreCase: Hello from code
redirected using nameStartsWith: Hello from code
redirected using nameStartsWithIgnoreCase: Hello from code
redirected using nameEndsWith: Hello from code
redirected using nameEndsWithIgnoreCase: Hello from code
redirected using nameContains: Hello from code
redirected using nameContainsIgnoreCase: Hello from code
redirected using nameMatches: Hello from code
destination redirect arguments received: redirect arguments
destination redirect no arguments received: not captured
destination redirect this only received: App
destination redirect this and arguments received: App, redirect this and arguments
hook enter arguments received: enter arguments
original using enter arguments: enter arguments
hook enter no arguments received: not captured
original using enter no arguments: enter no arguments
hook enter this only received: App
original using enter this only: enter this only
hook enter this and arguments received: App, enter this and arguments
original using enter this and arguments: enter this and arguments
original using exit arguments: exit arguments
hook exit arguments received: exit arguments
original using exit no arguments: exit no arguments
hook exit no arguments received: not captured
original using exit this only: exit this only
hook exit this only received: App
original using exit this and arguments: exit this and arguments
hook exit this and arguments received: App, exit this and arguments
```

## Matcher examples

The ten calls in `App.main` demonstrate every matcher supported by the source-expression parser. Each bridge uses
the same matcher for its class and method portions where practical:

- A bare value demonstrates the default `nameContains` behavior and legacy `Class#method` compatibility.
- `named` and `namedIgnoreCase` demonstrate exact matching.
- `nameStartsWith` and `nameStartsWithIgnoreCase` demonstrate prefix matching.
- `nameEndsWith` and `nameEndsWithIgnoreCase` demonstrate suffix matching.
- `nameContains` and `nameContainsIgnoreCase` demonstrate explicit substring matching.
- `nameMatches` demonstrates regular-expression matching.

The mixed-case arguments in the ignore-case examples are intentional. Inspect the `<bridges>` section of
`pom.xml` for the complete expressions. Running `mvn clean compile` shows the original implementations; running
`mvn package` and then the packaged JAR shows that all ten matcher methods were redirected.

## Bridge option examples

The final bridges in `pom.xml` demonstrate the three `captureArguments` behaviors for every bridge type:

| Options | Required destination parameters |
| --- | --- |
| `captureArguments` omitted | `()` |
| `captureArguments=args` | The source parameters, unchanged |
| `captureArguments=array` | `(Object[] arguments)` |
| Omitted, `thisAsParameter=true` | `(Object receiver)` |
| `captureArguments=args`, `thisAsParameter=true` | `(Object receiver, <source parameters>)` |
| `captureArguments=array`, `thisAsParameter=true` | `(Object receiver, Object[] arguments)` |

When `thisAsParameter` is true, the first parameter must be declared as exactly `Object`. When
`captureArguments` is `args`, every remaining parameter must exactly match the source method's parameters, in the
same order. With `array`, reference arguments are placed directly in the array and primitive arguments are boxed.
Omitting `captureArguments` passes nothing. `thisAsParameter` defaults to false.

### `redirect`

`redirect` replaces the original body. Its destination return type must also exactly match the source return type.
The redirect example source methods return `String`, so their destinations also return `String`:

```java
String redirectArgumentsDestination(String value)
String redirectNoArgumentsDestination()
String redirectThisOnlyDestination(Object receiver)
String redirectThisAndArgumentsDestination(Object receiver, String value)
String redirectArrayDestination(Object[] arguments)
```

The plain and combined XML configurations are:

```xml
<bridge>
  <source>named(br.com.isageek.bcbridge.example.App)#named(redirectArgumentsOriginal)</source>
  <dest>br.com.isageek.bcbridge.example.App#redirectArgumentsDestination</dest>
  <type>redirect</type>
  <captureArguments>args</captureArguments>
</bridge>

<bridge>
  <source>named(br.com.isageek.bcbridge.example.App)#named(redirectThisAndArgumentsOriginal)</source>
  <dest>br.com.isageek.bcbridge.example.App#redirectThisAndArgumentsDestination</dest>
  <type>redirect</type>
  <captureArguments>args</captureArguments>
  <thisAsParameter>true</thisAsParameter>
</bridge>
```

The adjacent redirect examples omit `captureArguments` for no arguments and use `array` for one `Object[]`.

### `OnMethodEnter`

`OnMethodEnter` calls its destination before the original body. The destination must return `void`. Example
signatures include:

```java
void enterArgumentsDestination(String value)
void enterNoArgumentsDestination()
void enterThisOnlyDestination(Object receiver)
void enterThisAndArgumentsDestination(Object receiver, String value)
void enterArrayDestination(Object[] arguments)
```

For example, this receiver-only hook does not capture the source `String`:

```xml
<bridge>
  <source>named(br.com.isageek.bcbridge.example.App)#named(enterThisOnlyOriginal)</source>
  <dest>br.com.isageek.bcbridge.example.App#enterThisOnlyDestination</dest>
  <type>OnMethodEnter</type>
  <thisAsParameter>true</thisAsParameter>
</bridge>
```

### `OnMethodExit`

`OnMethodExit` calls its destination after the original method returns normally. The destination must return
`void`. Example signatures include:

```java
void exitArgumentsDestination(String value)
void exitNoArgumentsDestination()
void exitThisOnlyDestination(Object receiver)
void exitThisAndArgumentsDestination(Object receiver, String value)
void exitArrayDestination(Object[] arguments)
```

This combined case receives the source instance followed by all source arguments:

```xml
<bridge>
  <source>named(br.com.isageek.bcbridge.example.App)#named(exitThisAndArgumentsOriginal)</source>
  <dest>br.com.isageek.bcbridge.example.App#exitThisAndArgumentsDestination</dest>
  <type>OnMethodExit</type>
  <captureArguments>args</captureArguments>
  <thisAsParameter>true</thisAsParameter>
</bridge>
```

See the final `<bridge>` entries in `pom.xml` and `App.java` for matching source and destination methods. The array
examples use both a `String` and an `int`, showing that all values arrive in one array and the `int` is boxed.
