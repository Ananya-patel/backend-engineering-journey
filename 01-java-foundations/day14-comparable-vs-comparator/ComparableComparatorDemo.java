import java.util.*;

class Student implements Comparable<Student> {
    int rollNo;

    Student(int rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public int compareTo(Student other) {
        return this.rollNo - other.rollNo;
    }
}

public class ComparableComparatorDemo {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student(5));
        list.add(new Student(1));
        list.add(new Student(3));

        // Comparable sorting
        Collections.sort(list);
        System.out.println("Comparable:");
        for (Student s : list) {
            System.out.println(s.rollNo);
        }

        // Comparator sorting (reverse)
        Collections.sort(list, (a, b) -> b.rollNo - a.rollNo);
        System.out.println("Comparator:");
        for (Student s : list) {
            System.out.println(s.rollNo);
        }
    }
}

