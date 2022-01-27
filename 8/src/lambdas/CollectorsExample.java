package lambdas;


import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Odinga David
 * @since : 1/27/22, Thu
 */
public class CollectorsExample {

    public static void main(String[] args) {

        List<Integer> scores = List.of(60,70, 80 ,6, 70,  50, 60);

        DoubleSummaryStatistics statistics= scores.stream()
                .collect(Collectors.summarizingDouble(Integer::doubleValue));

        System.out.println(statistics);
    }
}
