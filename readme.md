# Spring Data REST Example

This project is a smaller example of using Spring Data REST, reduced in complexity
from the Restbucks application here:

https://github.com/olivergierke/spring-restbucks

## Setup

From the command line, clone the project in Git, cd in to its directory, then:

```
mvn jetty:run
```

This also includes Eclipse files, so you can open it in Eclipse without
needing to re-import the Maven-ness.

It relies on [Lombok](projectlombok.org) which must be installed in Eclipse.

## Project description

The project uses:

- [Spring (MVC)](http://github.com/SpringSource/spring-framework) - 3.2.0.RELEASE
- [Spring Data JPA](http://github.com/SpringSource/spring-data-jpa) - 1.2.0.RELEASE
- [Spring Data REST](http://github.com/SpringSource/spring-data-rest) - 1.0.0.RELEASE
- [Spring Hateoas](http://github.com/SpringSource/spring-hateoas) - 0.4.0.BUILD-SNAPSHOT
- [Spring Plugin](http://github.com/SpringSource/spring-plugin) - 0.8.0.BUILD-SNAPSHOT

Here's what the individual projects used contribute to the sample in from a high-level point of view:

### Spring Data JPA

The Spring Data repository mechanism is used to reduce the effort to implement persistence for the domain objects to the declaration of an interface per aggregate root. See `OrderRepository` and `PaymentRepository` for example. Beyond that, using the repository abstract enables the Spring Data REST module to do its work.

### Spring Data REST

We're using Spring Data REST to expose the `OrderRepository` as REST resource without additional effort.

### Spring HATEOAS

Spring Hateoas provides a generic `Resource` abstraction that we leverage to create hypermedia-driven representations. Spring Data REST also leverages this abstraction so that we can deploy `ResourceProcessor` implementations (e.g. `PaymentorderResourceProcessor`) to enrich the representations for `Order` instance with links to the `PaymentController`. Read more on that below in the Hypermedia section.

The final important piece is the `EntityLinks` abstraction that allows to create `Link` instance in a type-safe manner avoiding the repetition of URI templates and parts all over the place. See `PaymentLinks` for example usage.

### Spring Plugin

The Spring Plugin library provides means to collect Spring beans by type and exposing them for selection based on a selection criterion. It basically forms the foundation for the `EntityLinks` mechanism provided in Spring Hateoas and our custom extension `RestResourceEntityLinks`.

### Miscellaneous

The project uses [Lombok](http://projectlombok.org) to reduce the amount of boilerplate code to be written for Java entities and value objects.

## Hypermedia

A core focus of this sample app is to demonstrate how easy resources can be modeled in a hypermedia driven way.

