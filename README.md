# nerd4j-test
This library contains utility classes to facilitate writing tests using JUnit.

## Content of this library

Currently this class contains a class hierarchy that provides:
* clean and pretty logging messages using the `TestWatcher` facility;
* the integration with the Spring framework providing an easy way for writing `JUnit` tests that load the Spring Context and allow to enable the transactional environment.


This library is also available on Maven Central [here] (http://search.maven.org/#artifactdetails|org.nerd4j|nerd4j-test|1.1.0|jar "Maven Central: nerd4j-test") and can be used with the following dependecy declaration:
```xml
<dependency>
 <groupId>org.nerd4j</groupId>
 <artifactId>nerd4j-test</artifactId>
 <version>1.1.0</version>
</dependency>
```
