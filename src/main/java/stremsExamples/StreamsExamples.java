package stremsExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {

  public static void main(String[] args) {
    // create a list of integers
    List<Integer> number = Arrays.asList(2,3,4,5);

    // demonstration of map method
    List<Integer> square =
        number
            .stream()
            .map(x -> x*x)
            .collect(Collectors.toList());


    // create a list of String
    List<String> names =
        Arrays.asList("Reflection","Collection","Stream");

    // demonstration of filter method
    List<String> result = names
        .stream()
        .filter(s->s.startsWith("R"))
        .collect(Collectors.toList());

    // demonstration of sorted method
    List<String> show =
        names.stream().sorted().collect(Collectors.toList());

    // create a list of integers
    List<Integer> numbers = Arrays.asList(2,3,4,5,2);

    // collect method returns a set
    Set<Integer> squareSet =
        numbers.stream().map(x->x*x).collect(Collectors.toSet());

    // demonstration of forEach method
    //number.stream().map(x->x*x).forEach(y->System.out.println(y));

    // demonstration of reduce method
    int even =
        number.stream().filter(x->x%2==0).reduce(0, Integer::sum);

    System.out.println(even);
  }
}
