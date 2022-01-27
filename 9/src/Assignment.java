import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Odinga David
 * @since : 1/6/22, Thu
 */
public class Assignment {

    public static String palindrome(int n, int k){
        List<Character> alphabet = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',  'u', 'v', 'w', 'z', 'y', 'z');

        List<Character> lettersToUse = alphabet.stream().limit(k).collect(Collectors.toList());

        Character[] palindrome = new Character[n];

            for (int i = 0; i < n; i++) {

                if (palindrome[i] == null) {
                    Character letter = lettersToUse.get(new Random().nextInt(k));
                    palindrome[i] = letter;

                    if (palindrome[n - (i + 1)] == null)
                        palindrome[n - (i + 1)] = letter;
                } else {
                    break;
                }
            }

        System.out.println(Arrays.stream(palindrome)
                .map(String::valueOf)
                .reduce("",(partial, elem)-> partial + elem));

        return Arrays
                .stream(palindrome)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }



    public static int Solution(String S){
        int count =Integer.parseInt(S) % 3 == 0? 1: 0;
        for (int i= 0; i< S.length(); i++){
            int index = i;

            Predicate<Integer> isDivisibleBy3 = n -> n%3 == 0;
            Function<Integer, String>  replaceNumber = s -> {
                StringBuilder str = new StringBuilder(S);
                str.setCharAt(index, (char)(s+'0'));
                return str.toString();
            };
            Function<String, Integer> convertToInt = Integer::parseInt;

            count += (Long) Stream.iterate(0, n -> n < 10, n -> n+1)
                    .filter(num ->S.charAt(index) != (char)(num+'0'))
                    .map(replaceNumber.andThen(convertToInt))
                    .filter(isDivisibleBy3)
                    .count();
        }
        return count;
    }


    public static void main(String[] args) {
//        System.out.println(palindrome(6, 3));

        System.out.println(Solution("0081"));
    }

}
