//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // Check arguments
        //changing the argument for task 2
        if (args.length !=1) {
            System.out.println("error: incrrect number");
            return;
        }
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader = new BufferedReader ( new InputStreamReader ( new FileInputStream ("employees.txt")))){
                String line = reader.readLine();
                for (String employee : line.split(",")) {
                    System.out.println(employee);
                }
            } catch (Exception e) {
            System.out.println("Data Loaded.");
        } 
    }
    else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader = new BufferedReader (new InputStreamReader ( new FileInputStream ("employees.txt"))))//change the if statement
                {
                    String line = reader.readLine();
                    String[] employeeNames = line.split(",");
                    Random randomGenerator = new Random();
                    System.out.println(employeeNames[randomGenerator.nextInt(employeeNames.length)]);
                    
            } catch (Exception e) {
            System.out.println("Data Loaded.");
        } 
    }
    else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try (
                BufferedWriter writer = new BufferedWriter(//w = writer
                        new FileWriter("employees.txt", true))){
                
                writer.write(", " + args[0].substring(1));

                writer.close();
            } catch (Exception e) {//cnges to e to employeeNames
            System.out.println("Data Loaded.");
        } 
    } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader  = new BufferedReader (
                        new InputStreamReader (
                                new FileInputStream ("employees.txt")))){
                                    String line = reader.readLine();
                                    String[] employeeNames = line.split(",");
                                    String searchEmployee = args[0].substring(1);
                                    for (String employee : employeeNames) {
                                        if (employee.equals(searchEmployee)) {
                                            System.out.println("Employee found!");
                                            return;
                                        }
                                    }
                                    
            } catch (Exception e) {
            System.out.println("Data Loaded.");
        } 
    } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader  = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")))){
                                    String line = reader.readLine();
String[] words = line.split("\\s+");  // split by spaces
System.out.println(words.length + " word(s) found.");

            } catch (Exception e) {
            System.out.println("Data Loaded.");
        } 
    }else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")))){
                String line = reader.readLine();
                String employeeNames[] = line.split(",");
                String n = args[0].substring(1);
                for (int i = 0; i < employeeNames.length; i++) {
                    if (employeeNames[i].equals(n)) {
                        employeeNames[i] = "Updated";
                    }
                }
                BufferedWriter writer = new BufferedWriter(//w=writer
                        new FileWriter("employees.txt"));
                        writer.write(String.join(",", employeeNames));
                        writer.close();
            } catch (Exception e) {
            System.out.println("Data Updated.");
        } 
    }else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader  = new BufferedReader ( new InputStreamReader (
                                new FileInputStream ("employees.txt")))){
                                    String line = reader.readLine();
                                    String[] employeeNames = line.split(",");
                                    String n = args[0].substring(1);
                                    List<String> list = new ArrayList<>(Arrays.asList(employeeNames));
                                    if (list.remove(n)) {
                                        BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
                                        writer.write(String.join(",", list));
                                    } else {
                                        System.out.println("Employee not found.");
                                    }
                                    
    }
    }
    //for read
    private static String readFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")))) {
            return reader.readLine();  // Read and return the first line of the file
        } catch (Exception e) {
            System.out.println("Error reading file.");
            return "";
        }
    }
    //for write 
    private static void writeFile(String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", append))) {
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        }
    }
}
