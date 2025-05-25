import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        String adminUser = "admin", adminPass = "1234";

        System.out.print("Enter username: ");
        String user = sc.next();
        System.out.print("Enter password: ");
        String pass = sc.next();

        if (!user.equals(adminUser) || !pass.equals(adminPass)) {
            System.out.println("Access Denied.");
            return;
        }

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Search by Name");
            System.out.println("5. Delete Student");
            System.out.println("6. Wipe All Records");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();
                    System.out.print("Enter Math Marks: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter Science Marks: ");
                    int m2 = sc.nextInt();
                    System.out.print("Enter English Marks: ");
                    int m3 = sc.nextInt();
                    manager.addStudent(new Student(r, n, m1, m2, m3));
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Roll No: ");
                    r = sc.nextInt();
                    Student s1 = manager.searchByRoll(r);
                    if (s1 != null)
                        s1.printReport();
                    else
                        System.out.println("Not found.");
                    break;
                case 4:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    Student[] foundStudents = manager.searchByName(name);
                    if (foundStudents.length > 0){
                        for (Student s : foundStudents) {
                            System.out.println("-----------------------");
                            s.printReport();
                        }
                    } 
                    else {
                            System.out.println("No students found with that name.");
                        }
                    break;
                case 5:
                    System.out.print("Enter Roll No to Delete: ");
                    r = sc.nextInt();
                    manager.deleteStudent(r);
                    break;
                case 6:
                    System.out.print("Are you sure? (yes/no): ");
                    sc.nextLine();
                    String conf = sc.nextLine();
                    if (conf.equalsIgnoreCase("yes")) {
                        manager.wipeAll();
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
}}