import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static ArrayList<String> toDoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    updateTask();
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("1. Add a Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Remove a Task");
        System.out.println("4. Update a Task");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        toDoList.add(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (toDoList.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("\nYour To-Do List:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    private static void removeTask() {
        viewTasks();
        if (!toDoList.isEmpty()) {
            System.out.print("Enter the task number to remove: ");
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= toDoList.size()) {
                toDoList.remove(taskNumber - 1);
                System.out.println("Task removed successfully.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    private static void updateTask() {
        viewTasks();
        if (!toDoList.isEmpty()) {
            System.out.print("Enter the task number to update: ");
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= toDoList.size()) {
                System.out.print("Enter the new task: ");
                String newTask = scanner.nextLine();
                toDoList.set(taskNumber - 1, newTask);
                System.out.println("Task updated successfully.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
