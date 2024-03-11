import java.util.ArrayList;
import java.util.Scanner;

public class TravelPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        String destination = getDestination(scanner);
        int travelDays = getTravelDays(scanner);
        ArrayList<String> preferences = getPreferences(scanner);

        // Generate itinerary
        Itinerary itinerary = generateItinerary(destination, travelDays, preferences);

        // Display itinerary
        displayItinerary(itinerary);

        scanner.close(); // Close Scanner to free resources
    }

    private static String getDestination(Scanner scanner) {
        System.out.print("Enter your desired destination: ");
        return scanner.nextLine();
    }

    private static int getTravelDays(Scanner scanner) {
        System.out.print("Enter the number of travel days: ");
        return scanner.nextInt();
    }

    private static ArrayList<String> getPreferences(Scanner scanner) {
        ArrayList<String> preferences = new ArrayList<>();
        System.out.println("Enter your travel preferences (e.g., sightseeing, museums, hiking): ");
        String preference;
        do {
            preference = scanner.nextLine();
            if (!preference.isEmpty()) {
                preferences.add(preference);
            }
        } while (!preference.equalsIgnoreCase("done"));
        return preferences;
    }

    // This method needs further implementation to use external APIs for maps, weather, and budget calculations
    private static Itinerary generateItinerary(String destination, int travelDays, ArrayList<String> preferences) {
        Itinerary itinerary = new Itinerary(destination, travelDays);

        // Simulate adding activities based on preferences
        for (int i = 0; i < travelDays; i++) {
            itinerary.addActivity("Activity " + (i + 1));
        }

        return itinerary;
    }

    private static void displayItinerary(Itinerary itinerary) {
        System.out.println("** Your Travel Itinerary **");
        System.out.println("Destination: " + itinerary.getDestination());
        System.out.println("Duration: " + itinerary.getTravelDays() + " days");
        System.out.println("Activities:");
        for (String activity : itinerary.getActivities()) {
            System.out.println("- " + activity);
        }

        // You can call methods to display additional information like weather and budget estimates
        // based on implemented functionalities
        // System.out.println("Weather forecast: ...");
        // System.out.println("Estimated budget: ...");
    }
}

class Itinerary {
    private String destination;
    private int travelDays;
    private ArrayList<String> activities;

    public Itinerary(String destination, int travelDays) {
        this.destination = destination;
        this.travelDays = travelDays;
        this.activities = new ArrayList<>();
    }

    public String getDestination() {
        return destination;
    }

    public int getTravelDays() {
        return travelDays;
    }

    public ArrayList<String> getActivities() {
        return activities;
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }
}
