package streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static streams.MyPredicates.compare;

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

    public static void main(String[] args) {
        System.out.println("------------------takeWhile ops-------------");
        takeWhile();
        System.out.println("--------------------------------------------");

        System.out.println("------------------dropWhile ops---------------");
        dropWhile();
        System.out.println("--------------------------------------------");

    }
}
