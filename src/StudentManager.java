public class StudentManager {
    private Student[] students = new Student[100];
    private int count = 0;

    public void addStudent(Student s) {
        if (count < students.length) {
            students[count++] = s;
        }
    }

    public void viewAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println("-----------------------");
            students[i].printReport();
        }
    }

    public Student searchByRoll(int roll) {
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNo() == roll) {
                return students[i];
            }
        }
        return null;
    }

    public Student[] searchByName(String name) {
    // Step 1: Count matches
    int matchCount = 0;
    for (int i = 0; i < count; i++) {
        if (students[i].getName().equalsIgnoreCase(name)) {
            matchCount++;
        }
    }

    // Step 2: Create array of matched size
    Student[] matchedStudents = new Student[matchCount];

    // Step 3: Fill array with matching students
    int index = 0;
    for (int i = 0; i < count; i++) {
        if (students[i].getName().equalsIgnoreCase(name)) {
            matchedStudents[index] = students[i];
            index++;
        }
    }

    return matchedStudents; // will be empty if no matches
}


    public void deleteStudent(int roll) {
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNo() == roll) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null;
                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void wipeAll() {
        for (int i = 0; i < count; i++) {
            students[i] = null;
        }
        count = 0;
        System.out.println("All records wiped.");
    }

}