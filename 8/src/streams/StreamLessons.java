package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : Odinga David
 * @since : 12/24/21, Fri
 */
public class StreamLessons {

    public static void main(String[] args) {

        //creating an empty stream
        Stream<String> stringStream=Stream.empty();

        //create a stream using .of method
        Stream<String> cities = Stream.of("Nairobi", "Mombasa", "Kisumu", "Nakuru", "Kampala");

        //creating a stream from a collection
        List<String> countries = Arrays.asList("Kenya", "Uganda", "South Africa", "Nigeria", "Egypt");
        Stream<String> countriesStream = countries.stream();

        Predicate<String> containsO = x -> x.toLowerCase().contains("o");

        //terminal operations
        System.out.println(cities.allMatch(containsO));
        System.out.println(countriesStream.anyMatch(containsO));


        //Get numbers divisible by 7
        Predicate<Integer> divisibleBy7 = x -> x%7 == 0;

        List<Integer> divisible = Stream.of(1, 7, 10, 11, 21, 28, 40, 60, 70, 60, 221, 215, 700)
                .filter(divisibleBy7)
                .collect(Collectors.toList());

        System.out.println(divisible);

        //Stream con"catanation
        Stream<Integer> numbers = Stream.concat(Stream.of(1,2,3,4,5,6,7), Stream.of(1,2,3,4,5));

        List<Integer> eventsNumbers = numbers
                .peek(System.out::println)
                .filter(e -> e %2 == 0)
                .peek(System.out::println)
                .collect(Collectors.toList());

        eventsNumbers.forEach(System.out::println);

        List<Item> items= Arrays.asList(new Item("Item1", 10.0, 30),
                new Item("Item2", 11.97, 3),
                new Item("Item3", 15.0, 50),
                new Item("Item4", 110.0, 11),
                new Item("Item5", 51.90, 25),
                new Item("Item6", 75.78, 87),
                new Item("Item7", 7.30, 14));

        IntStream quantities = items.stream().mapToInt(Item::getQuantity);

        int sumQuantities =items
                .stream()
                .mapToInt(Item::getQuantity)
                .sum();
        System.out.println("Sum quantities: "+sumQuantities);

        double totalSales = items
                .stream()
                .mapToDouble(Item::totalSales)
                .sum();
        System.out.println("total sales: "+totalSales);

        //sum of prices of items exceeding 20 quantities
        double prices = items.stream()
                .filter(e -> e.getQuantity() > 20)
                .mapToDouble(Item::getPrice)
                .sum();
        System.out.println("Sum prices for products exceeding 20 in quantity: "+prices);


    }
}
