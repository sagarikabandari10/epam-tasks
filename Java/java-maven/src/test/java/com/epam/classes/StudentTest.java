package com.epam.classes;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    @Test
    public void getStudentsWithValidYear() {
        List<Student> students = Student.getStudents();
        int year = 1986;
        Assert.assertTrue(Student.getStudentsByYear(students, year).size() > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStudentsByYearWithNullStudentParameter() {
        int year = 1986;
        Student.getStudentsByYear(null, year);
    }

    @Test
    public void getStudentsWithInvalidYear() {
        List<Student> students = Student.getStudents();
        int year = 2020;
        Assert.assertFalse(Student.getStudentsByYear(students, year).size() > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStudentsByYearThrowsException() {
        List<Student> students = Student.getStudents();
        int year = 123;
        Student.getStudentsByYear(students, year);
    }

    @Test
    public void getStudents() {
        Assert.assertTrue(Student.getStudents().size() > 0);
    }
}