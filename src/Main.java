import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FitnessTracker tracker = new FitnessTracker();

        while (true) {

            System.out.println("\n===== FITNESS TRACKER =====");
            System.out.println("1. Add Fitness Data");
            System.out.println("2. View Fitness Data");
            System.out.println("3. View File Data");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    tracker.addFitnessData(sc);
                    break;

                case 2:
                    tracker.viewFitnessData();
                    break;

                case 3:
                    FileHandler.readFromFile();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}