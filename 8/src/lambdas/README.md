# JAVA LAMBDA
Lambdas are a great way to write code that not only works more efficienntly 
but also communicates effectively with other developers. We will explore the 
various ways' lambda helps us write expressive code.

### Syntax
```
(arguments)->{body}
```

A lambda expression can have 0 or more arguments

## Zero arguments
```java
public class LambdaExamples {

    interface DoSomething{
        String work();
    }

    public static void main(String[] args) {

        DoSomething something=()-> {
            String str1= "Hi glad you called me, but currently ";
            return str1+"am working";
        };
        System.out.println(something.work());
    }
}

```

## One argument expression
```java
public class LambdaExamples {
    interface Sayable{
        String say(String words);
    }
    
    public static void main(String[] args)  {
        Sayable say = (word) -> word;
        System.out.println(say.say("Hi Glad to be learning this eventually"));
    }
}

```


## 2 Argument expression
```java
public class LambdaExamples {

    interface Operation{
        int operate(int a, int b);
    }

    public static void main(String[] args) {

        //Multiple parameter interfaces
        Operation add = Integer::sum;
        System.out.println(add.operate(5,5));

        Operation div = (a,b)-> a/b;
        System.out.println(div.operate(5,5));

        Operation sub = (a,b) -> a-b;
        System.out.println(sub.operate(50,5));

        Operation multiply = (a, b) -> a*b;
        System.out.println(multiply.operate(5,5));
    }
}

```

## More examples
### Creating threads using lambda
```java
//creating a thread using lambda
        Runnable runnable=() -> System.out.println("Thread is running");
        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 =  new Thread(() -> System.out.println("Thread 2 running"));
        thread2.start();
```

### Sorting a list using lambda
```java

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", price=" + price;
    }
}


public class LambdaExamples {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("--------------------Comparator---------------------");
        List<Product> list= new ArrayList<>();

        //Adding Products
        list.add(new Product(1, "HP Laptop", 25000f));
        list.add(new Product(3, "Keyboard", 300f));
        list.add(new Product(2, "Dell Mouse", 150f));

        System.out.println("\nSorting using name");
        list.sort(Comparator.comparing(p -> p.name));
        list.forEach(System.out::println);

        System.out.println("\nSorting using id");
        list.sort(Comparator.comparing(p -> p.id));
        list.forEach(System.out::println);

        System.out.println("\nSorting using price");
        list.sort(Comparator.comparing(p -> p.price));
        list.forEach(System.out::println);
    }
}
```

Websites
  - [Java point](https://www.javatpoint.com/java-lambda-expressions) 
  - [DevDocs](https://devdocs.io/openjdk~8/java/util/stream/stream)
