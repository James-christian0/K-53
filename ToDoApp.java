import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    // Store tasks in a list
    static ArrayList<String> tasks = new ArrayList<>();
    // Add task to the list
    public static void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added!");
    }
    // Displays all tasks
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
    // Removes a task
    public static void removeTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println(" Invalid task number.");
        } else {
            // Adjust to zero-based index
            String removed = tasks.remove(index - 1);
            System.out.println("Removed: " + removed);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menu format
            System.out.println("\n To-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
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
                    return; // Exit Program
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}
