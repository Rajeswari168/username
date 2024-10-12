import java.util.*;

public class UserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the names of 5 users in the format {name1,name2,name3,name4,name5}: ");
        String input = scanner.nextLine();

        // Remove the curly braces and split the input string by commas, then trim spaces
        if (!input.matches("\\{[a-zA-Z]+(,[a-zA-Z]+){4}\\}")) {
            System.out.println("Invalid format. Please use the format {name1,name2,name3,name4,name5}");
            return;
        }

        input = input.replaceAll("[{}]", "").trim();
        String[] namesArray = input.split("\\s*,\\s*");

        // Ensure there are exactly 5 names
        if (namesArray.length != 5) {
            System.out.println("Please enter exactly 5 names.");
            return;
        }

        // Use LinkedHashSet to maintain insertion order
        Set<String> namesSet = new LinkedHashSet<>(Arrays.asList(namesArray));

        // Print names in a single line in set format
        System.out.print("Names: {");
        for (String name : namesSet) {
            System.out.print(name + ", ");
        }
        // Remove the last comma and space, then add closing brace
        System.out.println("\b\b}");

        // Find the longest and shortest names
        String longestName = Collections.max(namesSet, Comparator.comparingInt(String::length));
        String shortestName = Collections.min(namesSet, Comparator.comparingInt(String::length));

        System.out.println("Longest Name: " + longestName);
        System.out.println("Shortest Name: " + shortestName);

        // Create a list from the set and reverse it
        List<String> namesList = new ArrayList<>(namesSet);
        Collections.reverse(namesList);

        // Print names in reverse order set format
        System.out.print("Names in Reverse Order Set: {");
        for (String name : namesList) {
            System.out.print(name + ", ");
        }
        // Remove the last comma and space, then add closing brace
        System.out.println("\b\b}");

        scanner.close();
    }
}
