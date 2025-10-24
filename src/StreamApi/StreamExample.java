package StreamApi;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public List<String> processNames() {
        // Create a list of names
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "David", "Angela");

        // Stream API usage:
        // 1. Filter names starting with 'A'
        // 2. Convert to uppercase
        // 3. Sort alphabetically
        // 4. Collect into a new list
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        return result;
    }
}

