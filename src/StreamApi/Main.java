package StreamApi;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StreamExample example = new StreamExample();

        // Get the processed names using Stream API
        List<String> processedNames = example.processNames();

        // Display results
        System.out.println("Filtered and processed names:");
        processedNames.forEach(System.out::println);
    }
}

