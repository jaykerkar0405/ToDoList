import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void deleteTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task " + taskNumber + " deleted.");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a task to add: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    System.out.print("Enter the task number to delete: ");
                    int taskNumber = scanner.nextInt();
                    deleteTask(taskNumber);
                    break;
                case 4:
                    System.out.println("Exiting To-Do List...");
                    return;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.showMenu();
    }
}
