package com.epam.javaclasses;

import java.util.*;
import java.util.stream.Collectors;

public class Student extends Person {

    //private variable
    private String faculty;
    private String course;
    private String group;

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
    private Student(int _id, String _Surname, String _Name, String _Patronymic, String _DOB, String _Address, long _Phone,
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
                "  ", "29/07/1986", "Minsk", 988225, FACULTIES.F1.toString(), COURSES.C1.toString(), GROUPS.G1.toString()));
        list.add(new Student(1, "K", "Anil ",
                " Kumar ", "29/07/1988", "Minsk", 988985, FACULTIES.F2.toString(), COURSES.C2.toString(), GROUPS.G3.toString()));
        list.add(new Student(2, "Padakanti", " Sagarika",
                "  ", "29/07/1989", "Hyderabad", 966225, FACULTIES.F1.toString(), COURSES.C1.toString(), GROUPS.G2.toString()));
        list.add(new Student(3, "Padakanti", "Prateek kumar",
                "  ", "29/07/1984", "Minsk", 258225, FACULTIES.F2.toString(), COURSES.C3.toString(), GROUPS.G2.toString()));
        return list;
    }

    //properties
    public String getGroup() {
        return group;
    }

    public String getCourse() {
        return course;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return "Student " + super.toString() + " Faculty=" + faculty
                + ", Course=" + course + ", Group=" + group + "]";
    }

    public static void main(String[] args) {
        List<Student> studentList = getStudents();
        System.out.println("List of students of a given faculty: ");
        Map<String, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(Student::getFaculty));
        map.forEach((key, value) -> System.out.println(key + " : " + value));

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
        //Map<Integer, List<Student>> map1 =
                studentList.stream()
                .filter(p -> p.getDob().getYear() > year)
                //.collect(Collectors.groupingBy(Student::get_Year));
        .forEach(s1 -> System.out.print(s1.get_Year()+" : "+s1 +"\n"));
        //map1.forEach((key, value) -> System.out.println(key + ":" + value));

        System.out.println("\nList of the study group:");
        Collections.sort(studentList);
        map = studentList.stream()
                        .collect(Collectors.groupingBy(p -> p.getGroup()));
        map.forEach((key, value) -> System.out.println(key + ":" + value));

    }// end of main
}// end of class

