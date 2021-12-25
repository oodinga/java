#STREAMS<T>
 
Introduced in **JAVA 8**, streams provide a more efficient way of 
manipulating a collection of data of any type. Previously we needed to use 
loops to access these data which was not only difficult to understand but 
was inefficient as well.

##Topics
- [Creating streams](#creating-streams)
- [Types of streams](#types-of-streams)
- [Operations](#operations)

##Creating streams
There are two main ways of creating a stream. 
 1. Using Collections.stream() method
 2. Using Stream.of() method

### Collection.stream()
```java
List<String> cities = Arrays.asList("New York", "Nairobi", "Cape Town", 
        "London"); 

Stream<String> citieStream = cities.stream(); 
```

##Types of streams
##Operations

