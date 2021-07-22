package com.epam.exception.main;

import com.epam.exception.main.models.Groups;
import com.epam.exception.main.models.Subjects;

public class Run {
    public static void main(String[] args) {
        University university = new University();
        university.gpaForAllStudentSubjects();
        university.getAvgScore(Subjects.MATHS, Groups.MCA, "Saga");
        university.gpaInSubjectForUniversity();
    }
}
