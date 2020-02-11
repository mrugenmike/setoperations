import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOperationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>(); // Set is an interface, HashSet is a specific Implementation.
        Set<Integer> set2 = new HashSet<>();
        buildSetFromUserInput(scanner, set1);
        buildSetFromUserInput(scanner, set2);
        SetOperations setOperations = new SetOperations(set1, set2);
        setOperations.union();
        setOperations.intersection();
        setOperations.subSet();
    }

    private static void buildSetFromUserInput(Scanner scanner, Set<Integer> set1) {
        System.out.println("Please enter numbers to add to set (enter -1 to finish adding):");
        while (scanner.hasNextInt()) {
            int currentValue = scanner.nextInt();
            if (currentValue >= 0) {
                set1.add(currentValue);
            } else {
                break;
            }
        }
    }
}
