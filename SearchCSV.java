import java.io.*;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
import java.util.List;

public class SearchCSV {
    public static void main(String[] args) throws Exception {

        // read records from csv file using scannner
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("ProgrammingAssignment.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
                // System.out.println(getRecordFromLine(scanner.nextLine()));
            }
        }

        // variables
        boolean running = true;
        Scanner inputScanner = new Scanner(System.in);  // Create scanner object for input
        String value, city, state;

        while(running) {
            System.out.println("What do you want to search by?");
            System.out.println("(1)ZipCode (2)State (3)City (4)Type (5)BankName (6)City&State (7)All (0)Quit");
            String input = inputScanner.nextLine();  // Read user input
            switch (input) {
                case "1":
                    System.out.println("Enter zip code:");
                    value = inputScanner.nextLine();
                    searchRecords(records, 5, value);
                    break;
                case "2":
                    System.out.println("Enter state:");
                    value = inputScanner.nextLine();
                    searchRecords(records, 4, value);
                    break;
                case "3":
                    System.out.println("Enter city:");
                    value = inputScanner.nextLine();
                    searchRecords(records, 3, value);
                    break;
                case "4":
                    System.out.println("Enter type:");
                    value = inputScanner.nextLine();
                    searchRecords(records, 2, value);
                    break;
                case "5":
                    System.out.println("Enter bank name:");
                    value = inputScanner.nextLine();
                    searchRecords(records, 1, value);
                    break;
                case "6":
                    System.out.println("Enter city:");
                    city = inputScanner.nextLine();
                    System.out.println("Enter state:");
                    state = inputScanner.nextLine();
                    searchCityState(records, city, state);
                    break;
                case "7":
                    for (List<String> entry:records) {
                        System.out.println(entry);
                    }
                    break;
                case "0":
                    running = false;
                    break;
            }
        }
    }

    // search records with a specific value in specified category
    private static void searchRecords(List<List<String>> records ,int category, String value) {
        // Search for specific city (New York)
        for (List<String> entry:records) {
            // System.out.println(entry);
            if (entry.get(category).equals(value)) {
                System.out.println(entry);
            }
        }
    }

    // search records with a specific value in specified category
    private static void searchCityState(List<List<String>> records ,String city, String state) {
        // Search for specific city (New York)
        for (List<String> entry:records) {
            // System.out.println(entry);
            if (entry.get(3).equals(city) && entry.get(4).equals(state)) {
                System.out.println(entry);
            }
        }
    }

    // Takes a string and seperates it by commas
    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}