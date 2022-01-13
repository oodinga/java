package streams;

import java.util.function.Predicate;

/**
 * @author : Odinga David
 * @since : 1/13/22, Thu
 */
public class MyPredicates {

    private static Predicate<Integer> moreThan(int number){
        return n -> n > number;
    }

    private static Predicate<Integer> moreThanEqual(int number){
        return n -> n >= number;
    }

    private static Predicate<Integer> lessThan(int number){
        return n -> n < number;
    }

    private static Predicate<Integer> lessThanEqual(int number){
        return n -> n <= number;
    }

     private static Predicate<Integer> divisibleBy(int number){
        return n -> n % number == 0;
    }

    static Predicate<Integer> compare(String comparator, int number){
       return switch (comparator) {
            case ">":
                yield moreThan(number);
            case ">=":
                yield moreThanEqual(number);
            case "<":
                yield lessThan(number);
            case "<=":
                yield lessThanEqual(number);
            case "/" :
                yield divisibleBy(number);
            default:
                throw new IllegalStateException("Unexpected value: " + comparator);
        };
    }
}
