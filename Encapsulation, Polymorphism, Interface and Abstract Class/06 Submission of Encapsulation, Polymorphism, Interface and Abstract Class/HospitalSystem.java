interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        this.patientId = id;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

class InPatient extends Patient implements MedicalRecord {
    private int days;
    public InPatient(int id, String name, int age, int days) { super(id, name, age); this.days = days; }
    public double calculateBill() { return days * 1000; }
    public void addRecord(String record) { System.out.println("InPatient Record Added: " + record); }
    public void viewRecords() { System.out.println("Viewing InPatient Records"); }
}

class OutPatient extends Patient implements MedicalRecord {
    private int visits;
    public OutPatient(int id, String name, int age, int visits) { super(id, name, age); this.visits = visits; }
    public double calculateBill() { return visits * 500; }
    public void addRecord(String record) { System.out.println("OutPatient Record Added: " + record); }
    public void viewRecords() { System.out.println("Viewing OutPatient Records"); }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Patient p1 = new InPatient(1, "Rahul", 30, 5);
        Patient p2 = new OutPatient(2, "Neha", 25, 3);

        p1.getPatientDetails();
        System.out.println("Bill: " + p1.calculateBill());

        p2.getPatientDetails();
        System.out.println("Bill: " + p2.calculateBill());
    }
}
