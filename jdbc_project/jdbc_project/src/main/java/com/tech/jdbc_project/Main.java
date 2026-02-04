package com.tech.jdbc_project;
import java.util.Scanner;
public class Main {
      public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService ss = new StudentService();
        ResultService rs = new ResultService();

        while (true) {

            System.out.println("\n1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Update Student");
            System.out.println("4 Delete Student");
            System.out.println("5 Add Result");
            System.out.println("6 View Results");
            System.out.println("7 Update Result");
            System.out.println("8 Delete Result");
            System.out.println("9 Exit");

            System.out.print("Choose: ");
            try {
                int ch = Integer.parseInt(sc.nextLine());

                switch (ch) {

                    case 1:
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Course: ");
                        String course = sc.nextLine();
                        System.out.println(ss.addStudent(id, name, course) ? "Added" : "Failed");
                        break;

                    case 2:
                        ss.viewStudents();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        id = sc.nextLine();
                        System.out.print("New Name: ");
                        name = sc.nextLine();
                        System.out.print("New Course: ");
                        course = sc.nextLine();
                        System.out.println(ss.updateStudent(id, name, course) ? "Updated" : "Failed");
                        break;

                    case 4:
                        System.out.print("ID: ");
                        id = sc.nextLine();
                        System.out.println(ss.deleteStudent(id) ? "Deleted" : "Failed");
                        break;

                    case 5:
                        System.out.print("Result ID: ");
                        String rid = sc.nextLine();
                        System.out.print("Student ID: ");
                        String sid = sc.nextLine();
                        System.out.print("Marks1: ");
                        int m1 = Integer.parseInt(sc.nextLine());
                        System.out.print("Marks2: ");
                        int m2 = Integer.parseInt(sc.nextLine());
                        System.out.print("Marks3: ");
                        int m3 = Integer.parseInt(sc.nextLine());
                        System.out.println(rs.addResult(rid, sid, m1, m2, m3) ? "Added" : "Failed");
                        break;

                    case 6:
                        rs.viewResults();
                        break;

                    case 7:
                        System.out.print("Result ID: ");
                        rid = sc.nextLine();
                        System.out.print("Marks1: ");
                        m1 = Integer.parseInt(sc.nextLine());
                        System.out.print("Marks2: ");
                        m2 = Integer.parseInt(sc.nextLine());
                        System.out.print("Marks3: ");
                        m3 = Integer.parseInt(sc.nextLine());
                        System.out.println(rs.updateResult(rid, m1, m2, m3) ? "Updated" : "Failed");
                        break;

                    case 8:
                        System.out.print("Result ID: ");
                        rid = sc.nextLine();
                        System.out.println(rs.deleteResult(rid) ? "Deleted" : "Failed");
                        break;

                    case 9:
                        System.out.println("Bye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

                System.out.print("Go to menu? (Y to continue): ");
                if (!sc.nextLine().equalsIgnoreCase("y")) break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
            }
        }
        sc.close();
        }

    }
