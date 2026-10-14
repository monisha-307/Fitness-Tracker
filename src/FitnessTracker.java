

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FitnessTracker {

    public void addFitnessData(Scanner sc) {

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter Steps: ");
        int steps = sc.nextInt();

        System.out.print("Enter Calories: ");
        int calories = sc.nextInt();

        System.out.print("Enter Water Intake (ml): ");
        int water = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Workout: ");
        String workout = sc.nextLine();

        String sql = "INSERT INTO fitness_data " +
                "(user_id, steps, calories, water, workout) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, steps);
            ps.setInt(3, calories);
            ps.setInt(4, water);
            ps.setString(5, workout);

            ps.executeUpdate();

            System.out.println("Data inserted into MySQL successfully!");

            con.close();

            String fileData = userId + "," + steps + "," +
                    calories + "," + water + "," + workout;

            FileHandler.saveToFile(fileData);

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());
        }
    }

    public void viewFitnessData() {

        String sql = "SELECT * FROM fitness_data";

        try {

            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== FITNESS DATA =====");

            while (rs.next()) {

                System.out.println(
                        "User ID: " + rs.getInt("user_id"));

                System.out.println(
                        "Steps: " + rs.getInt("steps"));

                System.out.println(
                        "Calories: " + rs.getInt("calories"));

                System.out.println(
                        "Water: " + rs.getInt("water") + " ml");

                System.out.println(
                        "Workout: " + rs.getString("workout"));

                System.out.println("----------------------");
            }

            con.close();

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());
        }
    }
}