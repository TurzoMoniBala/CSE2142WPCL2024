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
                String employeeNames[] = line.split(",");
                for (String employee : employeeNames) {
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
                System.out.println(line);
                String employeeNames[] = line.split(",");
                Random randomGenerator= new Random();
                int randomIndex = randomGenerator.nextInt(employeeNames.length);//idx to randomIndex
                System.out.println(employeeNames[randomIndex]);
            } catch (Exception employeeNames) {
            System.out.println("Data Loaded.");
        } 
    }
    else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try (
                BufferedWriter writer = new BufferedWriter(//w = writer
                        new FileWriter("employees.txt", true))){
                String newEmployee = args[0].substring(1);//n= newEmployee
                writer.write(", " + newEmployee);
                writer.close();
            } catch (Exception employeeNames) {//cnges to e to employeeNames
            System.out.println("Data Loaded.");
        } 
    } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader  = new BufferedReader (
                        new InputStreamReader (
                                new FileInputStream ("employees.txt")))){
                String line = reader.readLine();
                String employeeNames[] = line.split(",");
                boolean found = false;
                String searchEmployee = args[0].substring(1);//s=searchEmployee
                for (int i = 0; i < employeeNames.length && !found; i++) {
                    if (employeeNames[i].equals(searchEmployee)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception employeeNames) {
            System.out.println("Data Loaded.");
        } 
    } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader  = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")))){
                String line = reader.readLine();
                char[] chars = line.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
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
            } catch (Exception employeeNames) {
            System.out.println("Data Updated.");
        } 
    }else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try (
                BufferedReader reader  = new BufferedReader ( new InputStreamReader (
                                new FileInputStream ("employees.txt")))){
                String line = reader.readLine();
                String employeeNames[] = line.split(",");
                String n = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(employeeNames));
                list.remove(n);
                BufferedWriter writer= new BufferedWriter(
                        new FileWriter("employees.txt"));
                        writer.write(String.join(",", list));
                        writer.close();
            } catch (Exception employeeNames) {
            System.out.println("Data Deleted.");
        }
    }
    }
}
