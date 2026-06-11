import java.util.Scanner;

public class Databse_code {

    public static class StudentRecordSystem {
        // We use basic arrays to store up to 100 students (Empty Lockers!)
        static String[] studentNames = new String[100];
        static int[] studentIDs = new int[100];
        static int studentCount = 0; // Keeps track of how many lockers are full

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            System.out.println("--- Welcome to the Student Record System ---");

            // The main menu loop
            while (running) {
                System.out.println("\n1. Add New Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                // The Decision Maker (If / Else block)
                if (choice == 1) {
                    addStudent(scanner);
                } else if (choice == 2) {
                    viewStudents();
                } else if (choice == 3) {
                    searchStudent(scanner);
                } else if (choice == 4) {
                    System.out.println("Saving records... Exiting system.");
                    running = false;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            scanner.close();
        }

        // --- CUSTOM COMMANDS (Methods) ---

        public static void addStudent(Scanner scanner) {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter Student Name: ");
            scanner.nextLine(); // Clear the scanner buffer
            String name = scanner.nextLine();

            // Put the data into the empty lockers
            studentIDs[studentCount] = id;
            studentNames[studentCount] = name;
            studentCount++; // Move to the next empty locker for next time

            System.out.println("Student Added Successfully!");
        }

        public static void viewStudents() {
            if (studentCount == 0) {
                System.out.println("No students in the system yet.");
                return;
            }

            System.out.println("""
                    --- Current Records ---""");
            // A standard loop to walk through the filled lockers
            for (int i = 0; i < studentCount; i++) {
                System.out.println("ID: " + studentIDs[i] + " | Name: " + studentNames[i]);
            }
        }

        public static void searchStudent(Scanner scanner) {
            System.out.print("Enter ID to search: ");
            int searchID = scanner.nextInt();

            // This is the EXACT Linear Search logic you wrote earlier!
            for (int i = 0; i < studentCount; i++) {
                if (studentIDs[i] == searchID) {
                    System.out.println("Student Found! Name: " + studentNames[i]);
                    return; // Stop searching once we find them
                }
            }
            System.out.println("Student not found.");

        }
    }
}
