import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // Check arguments
        if (args.length != 1) {
            System.out.println("Error: incorrect number of arguments.");
            return;
        }

        if (args[0].equals("l")) {
            System.out.println("Loading data...");
            String data = readFile();
            if (!data.isEmpty()) {
                String[] employeeNames = data.split(",");
                for (String employee : employeeNames) {
                    System.out.println(employee.trim());
                }
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data...");
            String data = readFile();
            if (!data.isEmpty()) {
                String[] employeeNames = data.split(",");
                Random random = new Random();
                int randomIndex = random.nextInt(employeeNames.length);
                System.out.println(employeeNames[randomIndex].trim());
            }
            System.out.println("Data Loaded.");
        } else if (args[0].startsWith("+")) {
            System.out.println("Adding data...");
            String newEmployee = args[0].substring(1).trim();
            writeFile(", " + newEmployee, true);
            System.out.println("Data Loaded.");
        } else if (args[0].startsWith("?")) {
            System.out.println("Searching data...");
            String searchEmployee = args[0].substring(1).trim();
            String[] employeeNames = readFile().split(",");
            boolean found = false;
            for (String employee : employeeNames) {
                if (employee.trim().equalsIgnoreCase(searchEmployee)) {
                    System.out.println("Employee found!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("c")) {
            System.out.println("Counting words...");
            String data = readFile();
            int wordCount = data.split(",").length;
            System.out.println(wordCount + " word(s) found.");
            System.out.println("Data Loaded.");
        } else if (args[0].startsWith("u")) {
            System.out.println("Updating data...");
            String updateEmployee = args[0].substring(1).trim();
            updateEmployee(updateEmployee);
        } else if (args[0].startsWith("d")) {
            System.out.println("Deleting data...");
            String deleteEmployee = args[0].substring(1).trim();
            deleteEmployee(deleteEmployee);
        } else {
            System.out.println("Invalid operation.");
        }
    }

    // Read file method
    private static String readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString().trim();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }
    }
// i am done this to use
// so i am trying to use this 
//so thats the file
    // Write file method
    private static void writeFile(String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", append))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Update employee method
    private static void updateEmployee(String employeeName) {
        String[] employees = readFile().split(",");
        boolean updated = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].trim().equalsIgnoreCase(employeeName)) {
                employees[i] = "Updated";
                updated = true;
                break;
            }
        }
        if (updated) {
            writeFile(String.join(",", employees), false);
            System.out.println("Employee updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Delete employee method
    private static void deleteEmployee(String employeeName) {
        List<String> employees = new ArrayList<>(Arrays.asList(readFile().split(",")));
        boolean removed = employees.removeIf(emp -> emp.trim().equalsIgnoreCase(employeeName));
        if (removed) {
            writeFile(String.join(",", employees), false);
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
