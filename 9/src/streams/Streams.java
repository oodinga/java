package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static streams.MyPredicates.compare;
import static streams.MyPredicates.divisibleBy;

/**
 * @author : Odinga David
 * @since : 1/13/22, Thu
 */
public class Streams {

    public static void takeWhileOps(List<Integer> numbers, String comparator, int number){
        System.out.println(numbers.stream()
                .takeWhile(compare(comparator, number))
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));
    }

    public static void dropWhileOps(List<Integer> numbers, String comparator, int number){
        System.out.println(numbers
                .stream()
                .dropWhile(compare(comparator, number))
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));
    }

    public static  void takeWhile(){

        List<Integer>  numbers = new java.util.ArrayList<>(List.of(1, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        numbers.sort(Comparator.reverseOrder());
        takeWhileOps(numbers,  ">", 5);
        takeWhileOps(numbers,  ">=", 8);

        numbers.sort(Comparator.naturalOrder());
        takeWhileOps(numbers,  "<", 5);
        takeWhileOps(numbers,  "<=", 5);

//        Divisible
        takeWhileOps(numbers,  "/", 1);
        takeWhileOps(numbers,  "/", 2);

        numbers.sort(Comparator.reverseOrder());
        takeWhileOps(numbers,  "/", 9);
    }

    public static void dropWhile(){
        List<Integer>  numbers = new java.util.ArrayList<>(List.of(1, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        numbers.sort(Comparator.reverseOrder());
        dropWhileOps(numbers,  ">", 5);
        dropWhileOps(numbers,  ">=", 8);

        numbers.sort(Comparator.naturalOrder());
        dropWhileOps(numbers,  "<", 5);
        dropWhileOps(numbers,  "<=", 5);

        //        Divisible
        dropWhileOps(numbers,  "/", 1);
        dropWhileOps(numbers,  "/", 2);

        numbers.sort(Comparator.reverseOrder());
        dropWhileOps(numbers,  "/", 9);
    }

    public static void streamIterate() {
        //Stream.iterate(initial value, next value)
       String first10= Stream.iterate(0, n -> n + 1)
               .limit(10)
               .map(String::valueOf)
               .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(first10);

        String odds =Stream.iterate(0, n -> n + 1)
                .filter(x -> x % 2 != 0) //odd
                .limit(10)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(odds);

        //fibonacci
        String fibonacci = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(n -> String.valueOf(n[0]))
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(fibonacci);

        System.out.println("\nIterate with condition");
        Stream.iterate(1, n-> n < 200, n-> n*2)
                .filter(divisibleBy(2))
                .forEach(x-> Stream.iterate(1, n-> n < x, n->n+1)
                        .filter(divisibleBy(3))
                        .forEach(y-> System.out.println( x+" -> "+y)));
    }

    public static void main(String[] args) {
        System.out.println("------------------takeWhile ops-------------");
        takeWhile();
        System.out.println("--------------------------------------------");

        System.out.println("------------------dropWhile ops---------------");
        dropWhile();
        System.out.println("--------------------------------------------");


        System.out.println("------------------Stream iterate---------------");
        streamIterate();
        System.out.println("--------------------------------------------");


    }
}
