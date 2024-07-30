class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        head = null;
    }

    // Add a task to the linked list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added: " + task);
    }

    // Search for a task by ID
    public Task searchTaskById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Traverse and display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
        } else {
            Node current = head;
            System.out.println("Task List:");
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }

    // Delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Deleted task with ID: " + taskId);
            return;
        }
        Node current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Deleted task with ID: " + taskId);
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        Task task1 = new Task(1, "Task 1", "Incomplete");
        Task task2 = new Task(2, "Task 2", "Complete");
        Task task3 = new Task(3, "Task 3", "Incomplete");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        taskList.displayTasks();

        System.out.println("\nSearching for task with ID 2:");
        Task foundTask = taskList.searchTaskById(2);
        System.out.println(foundTask != null ? foundTask : "Task not found.");

        System.out.println("\nDeleting task with ID 2:");
        taskList.deleteTask(2);
        taskList.displayTasks();
    }
}
