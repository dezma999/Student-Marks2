import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Declare the "students" list as a class field
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Call the readFile method and provide an error message if it returns false
        boolean success = readFile("C:\\Users\\Dezma Thrupp\\Desktop\\Student-Marks2\\src\\studentdata.txt");
        if (!success) {
            System.out.println("Error reading the data file.");
            return; // Exit the program if there's an error
        }

        // Display the menu and process user input
        displayMenu();
    }

    private static boolean readFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                
                if (data.length >= 9) {
                    int id = Integer.parseInt(data[0].trim());
                    String firstName = data[1].trim();
                    String lastName = data[2].trim();
                    int mathMark1 = Integer.parseInt(data[3].trim());
                    int mathMark2 = Integer.parseInt(data[4].trim());
                    int mathMark3 = Integer.parseInt(data[5].trim());
                    int englishMark1 = Integer.parseInt(data[6].trim());
                    int englishMark2 = Integer.parseInt(data[7].trim());
                    int englishMark3 = Integer.parseInt(data[8].trim());
                    
                    // Call the addNewStudent method to create Student objects
                    addNewStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
                } else {
                    System.out.println("Incomplete data in a line: " + line);
                }
            }
            return true; // Return true if data is read and initialized correctly
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if there's an error reading the data file
        }
    }

    private static void addNewStudent(int id, String firstName, String lastName, int mathMark1, int mathMark2, int mathMark3, int englishMark1, int englishMark2, int englishMark3) {
        // Create a new Student object and two AssignmentMarks objects
        Student student = new Student(id, firstName, lastName);
        student.setMathMarks(new AssignmentMarks("Mathematics", mathMark1, mathMark2, mathMark3));
        student.setEnglishMarks(new AssignmentMarks("English", englishMark1, englishMark2, englishMark3));

        // Add the Student object to the list of students
        students.add(student);   
    }

    private static void displayReportByMarks() {
        // Display a list of all students with their marks
        System.out.println("\nReport by Marks:");
        for (Student student : students) {
            System.out.println(student.getFullName());
            System.out.println("Math Marks: " + student.getMathMarks().getAverageMark());
            System.out.println("English Marks: " + student.getEnglishMarks().getAverageMark());
        }
    }

    private static void displayReportByGrades() {
        // Display a list of all students with their letter grades
        System.out.println("\nReport by Grades:");
        for (Student student : students) {
            System.out.println(student.getFullName());
            System.out.println("Math Grade: " + student.getMathMarks().getAverageGrade());
            System.out.println("English Grade: " + student.getEnglishMarks().getAverageGrade());
        }
    }

    private static void displayMenu() {
        // Display the menu to the user and process user input
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Report by Marks");
            System.out.println("2. Display Report by Grades");
            System.out.println("3. Remove Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = selectMenuOption(scanner);

            switch (choice) {
                case 1:
                    displayReportByMarks();
                    break;
                case 2:
                    displayReportByGrades();
                    break;
                case 3:
                    removeStudent(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static int selectMenuOption(Scanner scanner) {
        // Ask the user to enter a menu option and perform error checking
        int choice;

        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice >= 1 && choice <= 4) {
                    break; // Valid choice, exit the loop
                } else {
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option (1-4).");
                scanner.nextLine(); // Consume invalid input
            }
        }

        return choice;
    }

    private static void removeStudent(Scanner scanner) {
        // Ask the user to enter an ID and remove the student with that ID
        System.out.print("Enter the ID of the student to remove: ");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean removed = false;

        // Iterate through the list of students to find and remove the student with the specified ID
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == idToRemove) {
                iterator.remove(); // Remove the student
                removed = true;
                System.out.println("Student with ID " + idToRemove + " removed.");
                break; // Exit the loop after removing the student
            }
        }

        if (!removed) {
            System.out.println("Student with ID " + idToRemove + " not found.");
        }
    }
}
