package com.epam.exception.main;

import java.util.List;

public class University {
    private final String uName;
    private final List<Teacher> teachers;
    private final List<Student> students;
    private final List<Group> groups;

    public University(String uName, List<Teacher> teachers, List<Student> students, List<Group> groups) {
        this.uName = uName;
        this.teachers = teachers;
        this.students = students;
        this.groups = groups;
    }

    public String getuName() {
        return uName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "University{" +
                "University Name='" + uName + '\'' +
                "\n, teachers=" + teachers.toString() +
                "\n, students=" + students.toString() +
                "\n, groups=" + groups +
                '}';
    }
}
