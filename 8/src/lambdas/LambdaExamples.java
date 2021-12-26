package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : Odinga David
 * @since : 12/26/21, Sun
 */
public class LambdaExamples {

    interface DoSomething{
        String work();
    }

    interface Sayable{
        String say(String words);
    }

    interface Operation{
        int operate(int a, int b);
    }



    public static void main(String[] args) throws InterruptedException {

        DoSomething something=()-> {
            String str1= "Hi glad you called me, but currently ";
            return str1+"am working";
        };
        Sayable say = (word) -> word;

        System.out.println(something.work());
        System.out.println(say.say("Hi Glad to be learning this eventually"));


        //Multiple parameter interfaces
        Operation add = Integer::sum;
        System.out.println(add.operate(5,5));

        Operation div = (a,b)-> a/b;
        System.out.println(div.operate(5,5));

        Operation sub = (a,b) -> a-b;
        System.out.println(sub.operate(50,5));

        Operation multiply = (a, b) -> a*b;
        System.out.println(multiply.operate(5,5));


        //creating a thread using lambda
        System.out.println("-------------Threads using lambda-----------------");
        Runnable runnable=() -> System.out.println("Thread is running");
        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 =  new Thread(() -> System.out.println("Thread 2 running"));
        thread2.start();

        Thread.sleep(500);

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
