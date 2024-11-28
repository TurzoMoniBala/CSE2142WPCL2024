import java.io.*;
import java.util.*;

public class EmployeeManager {
    //cheack the argument count
    public static void main(String[] args) {
        // Check arguments
        if (args.length != 1) {
            System.out.println("Error: Incorrect number of arguments.");
            return;
        }
        
        // Handling different operations
        String operation = args[0];

        // Check for 'l' (loading employee data)//also check the file 
        if (operation.equals("l")) {
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")))) {
                String line = reader.readLine();
                for (String employee : line.split(",")) {
                    System.out.println(employee);
                }
                //if the file is not there then this block of code run
            } catch (Exception e) {
                System.out.println("Error loading data.");
            }
        }
        // Check for 's' (selecting a random employee)//search the data
        else if (operation.equals("s")) {
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")))) {
                String line = reader.readLine();
                String[] employeeNames = line.split(",");
                Random randomGenerator = new Random();
                System.out.println(employeeNames[randomGenerator.nextInt(employeeNames.length)]);
            } catch (Exception e) {
                System.out.println("Error loading data.");
            }
        }
        // Check for '+' (adding an employee)
        else if (operation.contains("+")) {
            String employeeName = operation.substring(1);
            if (employeeName.isEmpty()) {
                System.out.println("Error: No employee name provided to add.");
                return;
            }
            System.out.println("Adding employee ...");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", true))) {
                writer.write(", " + employeeName);
            } catch (Exception e) {
                System.out.println("Error adding employee.");
            }
        }
        // Check for '?' (searching for an employee)
        else if (operation.contains("?")) {
            String searchEmployee = operation.substring(1);
            if (searchEmployee.isEmpty()) {
                System.out.println("Error: No employee name provided to search.");
                return;
            }
            System.out.println("Searching employee ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")))) {
                String line = reader.readLine();
                String[] employeeNames = line.split(",");
                if (Arrays.asList(employeeNames).contains(searchEmployee)) {
                    System.out.println("Employee found");
                } else {
                    System.out.println("Employee not found");
                }
            } catch (Exception e) {
                System.out.println("Error loading data.");
            }
        }
        // Check for 'c' (counting employees)
        else if (operation.contains("c")) {
            System.out.println("Counting employees ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")))) {
                String line = reader.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    String[] employeeNames = line.split("\\s+");  // split by spaces
                    System.out.println(employeeNames.length + " employee(s) found.");
                } else {
                    System.out.println("No employees found");
                }
            } catch (Exception e) {
                System.out.println("Error loading data.");
            }
        }
        // Check for 'u' (updating employee)
        else if (operation.contains("u")) {
            String updatedEmployee = operation.substring(1);
            if (updatedEmployee.isEmpty()) {
                System.out.println("Error: No employee name provided to update.");
                return;
            }
            System.out.println("Updating employee ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")))) {
                String line = reader.readLine();
                String[] employeeNames = line.split(",");
                boolean updated = false;
                for (int i = 0; i < employeeNames.length; i++) {
                    if (employeeNames[i].equals(updatedEmployee)) {
                        employeeNames[i] = "Updated";
                        updated = true;
                    }
                }
                if (updated) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
                    writer.write(String.join(",", employeeNames));
                    writer.close();
                    System.out.println("Employee updated.");
                } else {
                    System.out.println("Employee not found for update.");
                }
            } catch (Exception e) {
                System.out.println("Error updating data.");
            }
        }
        // Check for 'd' (deleting employee)
        else if (operation.contains("d")) {
            String employeeToDelete = operation.substring(1);
            if (employeeToDelete.isEmpty()) {
                System.out.println("Error: No employee name provided to delete.");
                return;
            }
            System.out.println("Deleting employee ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")))) {
                String line = reader.readLine();
                String[] employeeNames = line.split(",");
                List<String> list = new ArrayList<>(Arrays.asList(employeeNames));
                if (list.remove(employeeToDelete)) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
                    writer.write(String.join(",", list));
                    writer.close();
                    System.out.println("Employee deleted.");
                } else {
                    System.out.println("Employee not found.");
                }
            } catch (Exception e) {
                System.out.println("Error deleting employee.");
            }
        }
        // If invalid operation is entered
        else {
            System.out.println("Error: Invalid argument. Please use one of the following operations: l, s, +<name>, ?<name>, c, u<name>, d<name>");
        }
    }

    // for read
    private static String readFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")))) {
            return reader.readLine();  // Read and return the first line of the file
        } catch (Exception e) {
            System.out.println("Error reading file.");
            return "";
        }
    }

    // for write 
    private static void writeFile(String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", append))) {
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        }
    }
}
