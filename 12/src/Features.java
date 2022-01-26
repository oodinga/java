import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Odinga David
 * @since : 1/26/22, Wed
 */
public class Features {

    public static void main(String[] args) throws IOException {
        String toIndent= "Hello developer!\nThis is Java 12 article.";
        System.out.println(toIndent.indent(5));
        System.out.println(toIndent.indent(2));
        System.out.println(toIndent.indent(-5));


//        Text transform
        String text= "David loves you code";
        text = text.transform(t -> new StringBuilder(t).reverse().toString());

        System.out.println(text);

        //Files mismatch
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        System.out.println(Files.mismatch(filePath1, filePath2));

        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3, "Java 12 Article");
        Files.writeString(filePath4, "Java 12 Tutorial");

//        long mismatch =
        System.out.println(Files.mismatch(filePath3, filePath4));


//        Teeing collector
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i), Collectors.counting(), (sum, count) -> sum / count));

        System.out.println(mean);


        // Compact number format
        NumberFormat likesShort = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);


        NumberFormat likesLong = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);

        System.out.println(likesShort.format(2592000.0));
        System.out.println(likesLong.format(2592000.0));

        Function<Long, String> shortenLikes = likesShort::format;
        List<String> likes= Stream.iterate(10L, n-> n<= 100000000000000L, n-> n*10L)
                .map(shortenLikes)
                .collect(Collectors.toList());

        System.out.println(likes);


    }
}
