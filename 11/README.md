# JAVA 11

## Topics covered
 1. [Reading and writing to Files](#reading-and-writing-to-files)
 2. [HTTP Client](#http-client)
 3. [String Operations](#string-operations)

### Reading and writing to Files
Reading and writing to files has never been any simpler than before. 
Introduction or `Files.readString()` and `Files.witeString()` has absolutely 
eased this process that used to be such a tedious task.

##### Code Samples
First lets look at how we can read contexts of a file.
```java
        //Read from a file
String uri= "example.txt";
String data = Files.readString(Path.of(uri));
```

To write to a file, we will give an additional parameter called OpenOptions
```java
// Writing to a file
String uri= "example.txt";
Files.writeString(Path.of(uri), "Hello", StandardOpenOption.APPEND);
```

### HTTP Client
### String Operations


