package com.epam.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student extends Person {

    private final String faculty;
    private final String course;
    private final String group;

    public Student(int id, String surname, String name, String patronymic, LocalDate dob, String address, long phone,
                   String faculty, String course, String group) {
        super(id, surname, name, patronymic, dob, address, phone);
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public static void main(String[] args) {
        List<Student> studentList = getStudents();
        System.out.println("List of students of a given faculty: ");
        for (Faculties f : Faculties.values()) {
            System.out.println(f);
            for (Student s : studentList) {
                if (s.faculty.equals(f.toString())) {
                    System.out.println("\t" + s);
                }
            }
        }
        System.out.println("\nLists of students for each faculty and course: ");

        for (Faculties f : Faculties.values()) {
            System.out.println(f);
            for (Courses c : Courses.values()) {
                System.out.println("\t" + c);
                for (Student s : studentList) {
                    if (s.faculty.equals(f.toString()) && s.course.equals(c.toString())) {
                        System.out.println("\t\t" + s);
                    }
                }
            }
        }

        int year = 1985;
        System.out.println("\nList of students born after a given year: " + year);
        studentList.stream()
                .filter(p -> p.getDob().getYear() > year)
                .forEach(s1 -> System.out.print(s1.get_Year() + " : " + s1 + "\n"));

        System.out.println("\nList of the study group:");
        Map<String, List<Student>> map = studentList.stream()
                .collect(Collectors.groupingBy(p -> p.group));
        map.forEach((key, value) -> System.out.println(key + ":" + value));

    }

    private static List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(0, "Padakanti", "Ravi kumar",
                "  ", LocalDate.of(1986, 7, 29), "Minsk", 988225, Faculties.F1.toString(), Courses.C1.toString(), Groups.G1.toString()));
        list.add(new Student(1, "K", "Anil ",
                " Kumar ", LocalDate.of(1988, 1, 14), "Minsk", 988985, Faculties.F2.toString(), Courses.C2.toString(), Groups.G3.toString()));
        list.add(new Student(2, "Bandari", " Sagarika",
                "  ", LocalDate.of(1989, 1, 10), "Hyderabad", 966225, Faculties.F1.toString(), Courses.C1.toString(), Groups.G2.toString()));
        list.add(new Student(3, "Padakanti", "Prateek kumar",
                "  ", LocalDate.of(2016, 5, 28), "Minsk", 258225, Faculties.F2.toString(), Courses.C3.toString(), Groups.G2.toString()));
        list.add(new Student(3, "Neol", "John",
                "  ", LocalDate.of(2001, 8, 12), "Minsk", 258225, Faculties.F3.toString(), Courses.C1.toString(), Groups.G2.toString()));
        return list;
    }

    @Override
    public String toString() {
        return super.toString() + " faculty=" + faculty
                + ", course=" + course + ", group=" + group + "\n";
    }

    private enum Faculties {F1, F2, F3}

    private enum Courses {C1, C2, C3}

    private enum Groups {G1, G2, G3}
}

