// ToDoApp.java
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    // Stores tasks in a list
    static ArrayList<String> tasks = new ArrayList<>(); 

    // Add a task to the list
    public static void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added!");
    }
    //Display tasks
    public static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println(" No tasks yet.");
        } else {
            System.out.println(" Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    // Remove a task safely
    public static void removeTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println(" Invalid task number.");
        } else {
            // Adjust for zero-based index
            String removed = tasks.remove(index - 1);
            System.out.println("Removed: " + removed);
        }
    }
    // 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Cleaner menu formatting
            System.out.println("\n To-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                // Reads whole line, avoids Scanner skipping issues
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    break;
                case 2:
                    showTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to remove: ");
                    try {
                        int taskNum = Integer.parseInt(scanner.nextLine());
                        removeTask(taskNum);
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid number.");
                    }
                    break;
                case 4:
                    System.out.println(" Exiting To-Do App. Goodbye!");
                    return; // exit program
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}
