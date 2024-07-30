class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Added: " + employee);
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    // Traverse and display all employees
    public void displayEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null; // Remove the last element
            size--;
            System.out.println("Deleted employee with ID: " + employeeId);
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        Employee emp1 = new Employee(1, "Alice", "Developer", 70000);
        Employee emp2 = new Employee(2, "Bob", "Designer", 65000);
        Employee emp3 = new Employee(3, "Charlie", "Manager", 80000);

        ems.addEmployee(emp1);
        ems.addEmployee(emp2);
        ems.addEmployee(emp3);

        ems.displayEmployees();

        System.out.println("\nSearching for employee with ID 2:");
        Employee foundEmp = ems.searchEmployeeById(2);
        System.out.println(foundEmp != null ? foundEmp : "Employee not found.");

        System.out.println("\nDeleting employee with ID 2:");
        ems.deleteEmployee(2);
        ems.displayEmployees();
    }
}
