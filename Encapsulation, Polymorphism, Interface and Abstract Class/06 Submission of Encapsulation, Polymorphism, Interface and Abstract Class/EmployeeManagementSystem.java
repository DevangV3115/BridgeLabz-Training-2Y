// Interface
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// Abstract Class
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base: " + baseSalary);
    }
}

// Subclasses
class FullTimeEmployee extends Employee implements Department {
    private String dept;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary
    }

    public void assignDepartment(String dept) { this.dept = dept; }
    public String getDepartmentDetails() { return dept; }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double ratePerHour;
    private String dept;

    public PartTimeEmployee(int id, String name, double ratePerHour, int hoursWorked) {
        super(id, name, ratePerHour * hoursWorked);
        this.ratePerHour = ratePerHour;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hoursWorked * ratePerHour;
    }

    public void assignDepartment(String dept) { this.dept = dept; }
    public String getDepartmentDetails() { return dept; }
}

// Main
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(101, "Alice", 30000);
        Employee e2 = new PartTimeEmployee(102, "Bob", 200, 40);

        e1.displayDetails();
        System.out.println("Salary: " + e1.calculateSalary());

        e2.displayDetails();
        System.out.println("Salary: " + e2.calculateSalary());
    }
}
