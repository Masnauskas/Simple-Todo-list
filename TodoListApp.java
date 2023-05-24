import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

class TodoList {
    private List<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name) {
        Task task = new Task(name);
        tasks.add(task);
    }

    public void completeTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            Task task = tasks.get(index - 1);
            task.setCompleted(true);
        }
    }

    public void displayTasks() {
        System.out.println("Todo List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "[X]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " + task.getName());
        }
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}

public class TodoListApp {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1. Add task");
            System.out.println("2. Complete task");
            System.out.println("3. Display tasks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
    
                switch (choice) {
                    case 1:
                        System.out.print("Enter task name: ");
                        String taskName = scanner.nextLine();
                        todoList.addTask(taskName);
                        System.out.println("Task added.");
                        break;
                    case 2:
                        todoList.displayTasks();
                        if (todoList.isEmpty()) {
                            System.out.println("No tasks to complete.");
                            break;
                        }
                        System.out.print("Enter task index: ");
                        int taskIndex = scanner.nextInt();
                        scanner.nextLine(); 
                        todoList.completeTask(taskIndex);
                        System.out.println("Task completed.");
                        break;
                    case 3:
                        if (todoList.isEmpty()) {
                        System.out.println("No tasks to display.");
                        break;
                    }
                        todoList.displayTasks();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please choose between 1, 2, 3 or 0.");
                scanner.nextLine(); 

            }
           
        }

        System.out.println("Exiting Todo List Application.");
    }
}
