package com.epam.classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getStudentsWithValidYear() {
        List<Student> students = Student.getStudents();
        int year = 1986;
        assertTrue(Student.getStudentsByYear(students, year).size() > 0);
    }

    @Test
    void getStudentsByYearWithNullStudentParameter() {
        int year = 1986;
        assertThrows(IllegalArgumentException.class, () -> Student.getStudentsByYear(null, year));
    }

    @Test
    void getStudentsByYearWithNoStudent() {
        int year = 1986;
        assertThrows(IllegalArgumentException.class, () -> Student.getStudentsByYear(new ArrayList<>(), year));
    }

    @Test
    void getStudentsWithInvalidYear() {
        List<Student> students = Student.getStudents();
        int year = 2020;
        assertFalse(Student.getStudentsByYear(students, year).size() > 0);
    }

    @Test
    void getStudentsByYearThrowsException() {
        List<Student> students = Student.getStudents();
        int year = 123;
        assertThrows(IllegalArgumentException.class, () -> Student.getStudentsByYear(students, year));
    }

    @Test
    void getStudents() {
        assertTrue(Student.getStudents().size() > 0, "Student should not be empty.");
    }
}