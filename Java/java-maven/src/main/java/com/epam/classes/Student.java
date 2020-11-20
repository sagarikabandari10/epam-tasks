package com.epam.classes;

import com.epam.classes.models.Courses;
import com.epam.classes.models.Faculties;
import com.epam.classes.models.Groups;

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
        List<Student> students = getStudents();
        System.out.println("List of students of a given faculty: ");
        for (Faculties faculty : Faculties.values()) {
            System.out.println(faculty);
            for (Student student : students) {
                if (student.faculty.equals(faculty.toString())) {
                    System.out.println("\t" + student);
                }
            }
        }
        System.out.println("\nLists of students for each faculty and course: ");

        for (Faculties faculty : Faculties.values()) {
            System.out.println(faculty);
            for (Courses course : Courses.values()) {
                System.out.println("\t" + course);
                for (Student student : students) {
                    if (student.faculty.equals(faculty.toString()) && student.course.equals(course.toString())) {
                        System.out.println("\t\t" + student);
                    }
                }
            }
        }

        int year = 1985;
        System.out.println("\nList of students born after a given year: " + year);
        getStudentsByYear(students, year)
                .forEach(student -> System.out.print(student.get_Year() + " : " + student + "\n"));

        System.out.println("\nList of the study group:");
        Map<String, List<Student>> map = students.stream()
                .collect(Collectors.groupingBy(student -> student.group));
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public static List<Student> getStudentsByYear(List<Student> students, int year) {
        if (students == null || students.size() == 0) {
            throw new IllegalArgumentException("Invaild students.");
        }
        if (Integer.toString(year).length() != 4) {
            throw new IllegalArgumentException("Invaild year.");
        }
        return students.stream()
                .filter(student -> student.getDob().getYear() > year)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(0, "Padakanti", "Ravi kumar",
                "  ", LocalDate.of(1986, 7, 29), "Minsk", 988225, Faculties.MEDICINE.toString(), Courses.CHEMICAL.toString(), Groups.MBBS.toString()));
        list.add(new Student(1, "K", "Anil ",
                " Kumar ", LocalDate.of(1988, 1, 14), "Minsk", 988985, Faculties.ARTS.toString(), Courses.SYSTEMS.toString(), Groups.MTECH.toString()));
        list.add(new Student(2, "Bandari", " Sagarika",
                "  ", LocalDate.of(1989, 1, 10), "Hyderabad", 966225, Faculties.MEDICINE.toString(), Courses.CHEMICAL.toString(), Groups.MBA.toString()));
        list.add(new Student(3, "Padakanti", "Prateek kumar",
                "  ", LocalDate.of(2016, 5, 28), "Minsk", 258225, Faculties.ARTS.toString(), Courses.ARCHITECTURE.toString(), Groups.MBA.toString()));
        list.add(new Student(3, "Neol", "John",
                "  ", LocalDate.of(2001, 8, 12), "Minsk", 258225, Faculties.ENGINEERING.toString(), Courses.CHEMICAL.toString(), Groups.MBA.toString()));
        return list;
    }

    @Override
    public String toString() {
        return super.toString() + " faculty=" + faculty
                + ", course=" + course + ", group=" + group + "\n";
    }
}

