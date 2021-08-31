[![Maven Central](https://img.shields.io/maven-central/v/io.github.bonigarcia/selenium-jupiter.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3Aio.github.bonigarcia%20a%3Aselenium-jupiter)
[![Build Status](https://github.com/bonigarcia/selenium-jupiter-examples/workflows/build/badge.svg)](https://github.com/bonigarcia/selenium-jupiter-examples/actions)
[![badge-jdk](https://img.shields.io/badge/jdk-8-green.svg)](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![License badge](https://img.shields.io/badge/license-Apache2-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Backers on Open Collective](https://opencollective.com/selenium-jupiter/backers/badge.svg)](#backers)
[![Sponsors on Open Collective](https://opencollective.com/selenium-jupiter/sponsors/badge.svg)](#sponsors)
[![Support badge](https://img.shields.io/badge/stackoverflow-selenium_jupiter-green.svg?logo=stackoverflow)](https://stackoverflow.com/questions/tagged/selenium-jupiter?sort=newest)
[![Twitter Follow](https://img.shields.io/twitter/follow/boni_gg.svg?style=social)](https://twitter.com/boni_gg)

# Selenium-Jupiter Examples [![][Logo]][GitHub Repository]

*Selenium-Jupiter* is a [JUnit 5] extension aimed to ease the use of Selenium in JUnit 5 tests. This repository several test examples showing *Selenium-Jupiter* in action.

## Usage

In order to include *Selenium-Jupiter* in a Maven project, first add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>selenium-jupiter</artifactId>
    <version>${selenium-jupiter.version}</version>
    <scope>test</scope>
</dependency>
```

... or in Gradle project:

```
dependencies {
    testImplementation("io.github.bonigarcia:selenium-jupiter:${selenium-jupiter.version}")
}
```

## Documentation

If you have questions on how to use *Selenium-Jupiter* please take a look to the [Selenium-Jupiter user guide].

## Backers

Thank you to all our backers! [[Become a backer](https://opencollective.com/selenium-jupiter#backer)]

<a href="https://opencollective.com/selenium-jupiter#backers" target="_blank"><img src="https://opencollective.com/selenium-jupiter/backers.svg?width=890"></a>

## Sponsors

Support this project by becoming a sponsor. Your logo will show up here with a link to your website. [[Become a sponsor](https://opencollective.com/selenium-jupiter#sponsor)]

<a href="https://opencollective.com/selenium-jupiter/sponsor/0/website" target="_blank"><img src="https://opencollective.com/selenium-jupiter/sponsor/0/avatar.svg"></a>

## About

Selenium-Jupiter (Copyright &copy; 2017-2021) is a project by [Boni Garcia] licensed under [Apache 2.0 License].

[Apache 2.0 License]: https://www.apache.org/licenses/LICENSE-2.0
[Boni Garcia]: https://bonigarcia.github.io/
[GitHub Repository]: https://github.com/bonigarcia/selenium-jupiter-examples
[JUnit 5]: https://junit.org/junit5/docs/current/user-guide/
[Logo]: https://bonigarcia.github.io/img/selenium-jupiter.png
[Selenium-Jupiter user guide]: https://bonigarcia.github.io/selenium-jupiter/
