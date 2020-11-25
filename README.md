# RestAPIAutomation

**Overview**

This project provides an example of how to use the REST-assured library to write black-box, functional tests for REST APIs in Java.

REST-assured is a Java library that aims to make it simpler to write out-of-process, functional tests for REST APIs, that are written in Java 
(or other JVM languages). It runs on top of existing Java testing frameworks (JUnit), and includes a DSL for building API requests and asserting API responses.

In this example project, REST-assured is used to implement a suite of functional tests for a couple of REST APIs hosted by an 
imaginary User service that supports creating and retrieving a resource/entity known as a (user) 'realm', via HTTP POST and GET methods.
