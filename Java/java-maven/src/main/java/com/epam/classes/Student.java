package com.epam.classes;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Student extends Person {

    //private variable
    private final String faculty;
    private final String course;
    private final String group;

    //enums
    enum FACULTIES {
        F1, F2, F3
    }

    enum COURSES {
        C1, C2, C3
    }

    enum GROUPS {
        G1, G2, G3
    }

    //constructor
    public Student(int _id, String _Surname, String _Name, String _Patronymic, LocalDate _DOB, String _Address, long _Phone,
                   String _faculty, String _course, String _group) {
        super(_id, _Surname, _Name, _Patronymic, _DOB, _Address, _Phone);
        this.faculty = _faculty;
        this.course = _course;
        this.group = _group;
    }

    //methods.
    private static List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(0, "Padakanti", "Ravi kumar",
                "  ", LocalDate.of(1986, 7,29), "Minsk", 988225, FACULTIES.F1.toString(), COURSES.C1.toString(), GROUPS.G1.toString()));
        list.add(new Student(1, "K", "Anil ",
                " Kumar ", LocalDate.of(1988, 1,14), "Minsk", 988985, FACULTIES.F2.toString(), COURSES.C2.toString(), GROUPS.G3.toString()));
        list.add(new Student(2, "Bandari", " Sagarika",
                "  ", LocalDate.of(1989, 1,10), "Hyderabad", 966225, FACULTIES.F1.toString(), COURSES.C1.toString(), GROUPS.G2.toString()));
        list.add(new Student(3, "Padakanti", "Prateek kumar",
                "  ", LocalDate.of(2016, 5,28), "Minsk", 258225, FACULTIES.F2.toString(), COURSES.C3.toString(), GROUPS.G2.toString()));
        list.add(new Student(3, "Neol", "John",
                "  ", LocalDate.of(2001, 8,12), "Minsk", 258225, FACULTIES.F3.toString(), COURSES.C1.toString(), GROUPS.G2.toString()));
        return list;
    }

    @Override
    public String toString() {
        return super.toString() + " Faculty=" + faculty
                + ", Course=" + course + ", Group=" + group + "]\n";
    }

    public static void main(String[] args) {
        List<Student> studentList = getStudents();
        System.out.println("List of students of a given faculty: ");
        for(FACULTIES f: FACULTIES.values()) {
            System.out.println(f);
            for (Student s : studentList) {
                if (s.faculty.equals(f.toString())) {
                    System.out.println("\t" + s);
                }
            }
        }
        /*Map<String, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(p -> p.faculty));
        map.forEach((key, value) -> System.out.println(key + " : " + value));*/

        System.out.println("\nLists of students for each faculty and course: ");
        /*Map<String, Map<String, List<Student>>> mapFC=studentList.stream()
		.filter(p -> p._Facutly.equals(FACULTIES.F2.toString()) && p._Course.equals(COURSES.C2.toString()))
		.forEach(s1 -> System.out.print(s1 +"\n"));
    	.collect(Collectors.groupingBy(Student :: getFaculty,Collectors.groupingBy(Student::getCourse)));*/

        for (FACULTIES f : FACULTIES.values()) {
            System.out.println(f);
            for (COURSES c : COURSES.values()) {
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
                .forEach(s1 -> System.out.print(s1.get_Year()+" : "+s1 +"\n"));

        System.out.println("\nList of the study group:");
        //Collections.sort(studentList);
        Map<String, List<Student>> map = studentList.stream()
                        .collect(Collectors.groupingBy(p -> p.group));
        map.forEach((key, value) -> System.out.println(key + ":" + value));

    }// end of main
}// end of class

