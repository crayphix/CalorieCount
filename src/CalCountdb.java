/**
 * The CalCountdb class is used to input food data and read food data from
 * the MySQL database MySQL database
 *
 * @bryan_speelman
 *
 */

import java.sql.*;
import java.util.Scanner;

public class CalCountdb {

    /**
     * Accepts operands to insert into food table
     *
     * @param food
     *
     */
    protected static void setFood(Food food) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Calcount?useSSL=false",
                "bryspeelm", "F33lsL1k3H0m3")) {
            try (Statement stmt = conn.createStatement()) {

                // insert data
                stmt.executeUpdate(String.format("INSERT INTO food (foodName, calories, date_created)" +
                        " VALUES ('%s', %d, '%s')", food.getFoodName(), food.calIn, food.getDate()));

                conn.close();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Calls SQL SELECT query for all records in CalCount database
     */
    protected static void getAllFood() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Calcount?useSSL=false",
                "bryspeelm", "F33lsL1k3H0m3")) {
            try (Statement stmt = conn.createStatement()) {

                // Retrieve data
                ResultSet rset = stmt.executeQuery("SELECT * FROM food ORDER BY date_created DESC");


                /* Process the ResultSet by scrolling the cursor forward via next().
                 *  For each row, retrieve the contents of the cells with getXxx(columnName).
                 */
                System.out.println("***********ALL FOOD RECORDS***********");
                int rowCount = 0;
                while (rset.next()) {   // Move the cursor to the next row, return false if no more row
                    int food_id = rset.getInt("food_id");
                    String foodName = rset.getString("foodName");
                    int calories = rset.getInt("calories");
                    Date date_created = rset.getDate("date_created");
                    System.out.println(date_created + ", " + foodName + ", " + calories);
                    ++rowCount;
                }
                System.out.println("Total number of records = " + rowCount);

                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Calls SQL query that returns all food items from specified date and total calories consumed
     * @param date
     */
    protected static void getFoodByDate(String date) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Calcount?useSSL=false",
                "bryspeelm", "F33lsL1k3H0m3")) {
            try (Statement stmt = conn.createStatement()) {

                // Retrieve data
                ResultSet rset = stmt.executeQuery(String.format("SELECT * FROM food " +
                                "WHERE date_created = '%s'", date));


                /* Process the ResultSet by scrolling the cursor forward via next().
                 *  For each row, retrieve the contents of the cells with getXxx(columnName).
                 */
                System.out.println("***********FOOD RECORD FOR " + date + "***********\n");
                int rowCount = 0;
                int totalCalories = 0;
                while (rset.next()) {   // Move the cursor to the next row, return false if no more row
                    int food_id = rset.getInt("food_id");
                    String foodName = rset.getString("foodName");
                    int calories = rset.getInt("calories");
                    totalCalories += calories;
                    Date date_created = rset.getDate("date_created");
                    System.out.println(date_created + ", " + foodName + ", " + calories);
                    ++rowCount;
                }
                System.out.printf("\nyour total calories for %s are: %d%n", date, totalCalories);
                System.out.println("Total number of food items = " + rowCount);

                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Calls SQL to delete 1 row of food determined by user given date and food item
     * @param food
     */
    protected static void deleteFoodByDate(Food food){

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Calcount?useSSL=false",
                "bryspeelm", "F33lsL1k3H0m3")) {
            try (Statement stmt = conn.createStatement()) {

                // delete data
                stmt.executeUpdate(String.format("DELETE FROM food " +
                                "WHERE date_created = '%s' AND foodName = '%s' LIMIT 1",
                                food.getDate(), food.getFoodName()));

                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected static void modifyFoodCal(Food food){
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Calcount?useSSL=false",
                "bryspeelm", "F33lsL1k3H0m3")) {
            try (Statement stmt = conn.createStatement()) {

                // modify date
                stmt.executeUpdate(String.format("UPDATE food SET calories = %d" +
                                "  WHERE date_created = '%s' AND foodName = '%s'",
                                food.getCalIn(), food.getDate(), food.getFoodName()));

                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
