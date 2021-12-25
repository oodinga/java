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
 1. [Using Collections.stream() method](#using-collectionstream)
 2. [Using Stream.of() method](#using-streamof)

### Using Collection.stream()
```java
List<String> cities = Arrays.asList("New York", "Nairobi", "Cape Town", 
        "London"); 

Stream<String> citieStream = cities.stream(); 
```

### Using stream.of()
```java
Stream<String> citieStream = Stream.of("New York", "Nairobi", "Cape Town",
        "London");
```

##Types of streams
Java gives us ability to create many types of streams out of the box. Stream 
being a generic class means we can create a stream of any kind of object. In 
this tutorial we will explore the types of streams we can create out of the box.
 1. Stream<T>
 2. IntStream
 3. DoubleStream
 4. LongStream


We have already explored how to create the first type of stream. Lets see 
how we can create the remaining types of stream. 

Stream class provides us with a number of methods that we can call to 
directly generate streams of either long, Integer or even Double. In 
addition, we could generate these streams from a set of objects. We will look 
at this example below

```java
//Generating an IntStream
//Using Stream.builder
IntStream studentEntries = IntStream.builder()
        .add(10)
        .add(20)
        .add(30)
        .build();

//Using mapToInt
List<Student> students = Arrays.asList(
        new Student("Mary", 20),
        new Student("John", 18),
        new Student("Mark", 21),
        new Student("Risper", 20)
        )        
IntStream studentAges = students.stream()
                            .mapToInt(Student::getAge);
```
##Operations

