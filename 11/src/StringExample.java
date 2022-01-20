/**
 * @author : Odinga David
 * @since : 1/20/22, Thu
 */
public class StringExample {

    static void printSeparator(String characters, String message, int length){
        String separator = characters
                .repeat(length)
                .concat(message)
                .concat(characters.repeat(length));

        System.out.println(separator);
    }

    public static void main(String[] args) {

        //String repeat and concat in action


        printSeparator("-*", " Welcome ", 10);

        //String blank
        printSeparator("-*", " isBlank() and isEmpty() ", 10);
        String data = "";
        System.out.println("Blank?: " +data.isBlank());
        System.out.println("Empty?: "+data.isEmpty());

        data = " ";
        System.out.println("Blank?: " +data.isBlank());
        System.out.println("Empty?: "+data.isEmpty());

        data = "yes";
        System.out.println("Blank?: " +data.isBlank());
        System.out.println("Empty?: "+data.isEmpty());

        printSeparator("-*", " lines() ", 10);
        String lines= """
                line 1
                line 2
                line 3
                line 4""";

        lines.lines().forEach(System.out::println);

        printSeparator("-*", " strip() ", 10);
        System.out.println(" David ".strip());
        System.out.println(" David ".stripLeading());
        System.out.println(" David ".stripTrailing());
    }
}
