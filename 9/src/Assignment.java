import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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



        StringBuilder builder = new StringBuilder();
        for (Character c : palindrome) {
            builder.append(c);
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(palindrome(6, 3));
    }

}
