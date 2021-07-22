package com.epam.exception.main;

import com.epam.exception.main.models.Groups;
import com.epam.exception.main.models.Subjects;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class University {
    private List<Faculty> faculties;
    private List<Student> students;
    private List<Group> groups;

    public University() {
        setDummyData();
    }

    public void setDummyData() {

        Faculty t1 = new Faculty("Saga", LocalDate.of(1989, 1, 10), "Minsk", 45287962, "Professor", Subjects.MATHS);
        Faculty t8 = new Faculty("Saga", LocalDate.of(1989, 1, 10), "Minsk", 45287962, "Professor", Subjects.MATHS);
        Faculty t2 = new Faculty("Pra", LocalDate.of(2016, 5, 28), "Minsk", 111111111, "Assistant Professor", Subjects.ACCOUNTS);
        Faculty t3 = new Faculty("Kiran", LocalDate.of(2005, 8, 12), "Gomel", 222222222, "Assistant Manager", Subjects.PHYSICS);
        Faculty t4 = new Faculty("Ravi", LocalDate.of(1988, 4, 15), "Brest", 5849672, "Professor", Subjects.CHEMISTRY);
        Faculty t5 = new Faculty("Ajay", LocalDate.of(1988, 4, 15), "Viciebsk", 5849672, "Junior Professor", null);
        Faculty t6 = new Faculty("Anil", LocalDate.of(1988, 4, 15), "Brest", 5849672, "Senior Professor", Subjects.COMPUTERS);
        Faculty t7 = new Faculty("Karan", LocalDate.of(1988, 4, 15), "Minsk", 5849672, "Junior Professor", null);
        faculties = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8);

        Group mbaGroup = new Group(Groups.MBA, Arrays.asList(new Subject(Subjects.MATHS), new Subject(Subjects.ACCOUNTS)));
        Group mcaGroup = new Group(Groups.MCA, Arrays.asList(new Subject(Subjects.MATHS), new Subject(Subjects.COMPUTERS), new Subject(Subjects.ACCOUNTS)));
        Group phdGroup = new Group(Groups.PHD, Arrays.asList(new Subject(Subjects.PHYSICS), new Subject(Subjects.COMMERCE)));
        Group noSubGroup = new Group(Groups.NOSUB, null);
        groups = Arrays.asList(mbaGroup, mcaGroup, phdGroup, noSubGroup);

        Student s1 = setStudent("Andrey", LocalDate.of(1989, 1, 10), "Minsk", 111111111, mcaGroup);
        Student s2 = setStudent("John", LocalDate.of(2016, 5, 28), "Groan", 111111111, mcaGroup);
        Student s3 = setStudent("Sam", LocalDate.of(2012, 8, 12), "Brest", 222222222, null);
        Student s4 = setStudent("Rooney", LocalDate.of(2013, 1, 10), "Platsk", 45287962, null);
        Student s5 = setStudent("Yana", LocalDate.of(2014, 5, 28), "Minsk", 111111111, phdGroup);
        Student s6 = setStudent("Sasha", LocalDate.of(2015, 8, 12), "Gomel", 222222222, mbaGroup);
        Student s7 = setStudent("Lisa", LocalDate.of(2016, 1, 10), "Mogilev", 45287962, null);
        Student s8 = setStudent("Dank", LocalDate.of(2014, 5, 28), "Grodno", 111111111, mcaGroup);
        Student s9 = setStudent("Mark", LocalDate.of(2013, 8, 12), "Minsk", 222222222, noSubGroup);

        students = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9);
    }

    private Student setStudent(String name, LocalDate dob, String address, long phone, Group group) {
        setSubjectGrade(group);
        return new Student(name, dob, address, phone, group);
    }

    private void setSubjectGrade(Group group) {
        if (group != null && group.getSubjects() != null) {
            Random r = new Random();
            for (Subject s : group.getSubjects()) {
                s.setScore(r.nextInt(100));
            }
        }
    }

    public void gpaForAllStudentSubjects() {
        for (Student s : students) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("'").append(s.getName()).append("': ");
                if (s.getGroup() == null)
                    throw new UniversityException("'" + s.getName() + "' was not assign to any group.");
                double sum = 0;
                if (s.getGroup().getSubjects() == null)
                    throw new UniversityException("'" + s.getName() + "' of group '" + s.getGroup().getgName() + "' has no subjects.");
                sb.append("sub: ");
                for (Subject sub : s.getGroup().getSubjects()) {
                    sb.append(sub.getName()).append(", ");
                    sum += sub.getScore();
                }
                //((sum of marks / total subject * 100 ) * 100) / grade (generating random number)
                double gpa = ((sum / (s.getGroup().getSubjects().size() * 100)) * 100) / new Random().nextInt(10);
                if (gpa < 0.0 || gpa > 10.0)
                    throw new UniversityException("'" + s.getName() + "' score is '" + gpa + "', should be greater than 0 and less than 10.");
                sb.append("\nGPA: ").append(gpa);
                System.out.println(sb);
            } catch (UniversityException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void getAvgScore(Subjects subject, Groups group, String faculty) {
        int sum = 0, count = 0;
        try {
            for (Group g : groups) {
                if (g.getgName().toString().equals(group.toString())) {
                    for (Subject s : g.getSubjects()) {
                        if(s.getName().name().equals(subject.toString())) {
                            for (Faculty f : faculties) {
                                if (f.getName().equals(faculty)) {
                                    sum += s.getScore();
                                    count++;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }
            System.out.printf("%nAvg score for Subject '%s', Group '%s' and Faculty '%s': %s%n%n", subject, group, faculty, sum / count);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void gpaInSubjectForUniversity() {
        double maths = 0, computers = 0, physics = 0, chemistry = 0, accounts = 0, commerce = 0;
        for (Group g : groups) {
            if (g.getSubjects() == null) continue;
            for (Subject s : g.getSubjects()) {
                switch (s.getName()) {
                    case MATHS:
                        maths += s.getScore();
                        break;
                    case CHEMISTRY:
                        chemistry += s.getScore();
                        break;
                    case ACCOUNTS:
                        accounts += s.getScore();
                        break;
                    case COMMERCE:
                        commerce += s.getScore();
                        break;
                    case COMPUTERS:
                        computers += s.getScore();
                        break;
                    case PHYSICS:
                        physics += s.getScore();
                        break;
                }
            }
        }
        gpaForAllSubjects(maths, computers, physics, chemistry, accounts, commerce);
    }

    private void gpaForAllSubjects(double maths, double computers, double physics, double chemistry, double accounts, double commerce) {
        for (Subjects s : Subjects.values()) {
            switch (s) {
                case MATHS:
                    System.out.println("GPA for subject " + Subjects.MATHS + " is: " + maths / 100 * 4);
                    break;
                case CHEMISTRY:
                    System.out.println("GPA for subject " + Subjects.CHEMISTRY + " is: " + chemistry / 100 * 4);
                    break;
                case ACCOUNTS:
                    System.out.println("GPA for subject " + Subjects.ACCOUNTS + " is: " + accounts / 100 * 4);
                    break;
                case COMMERCE:
                    System.out.println("GPA for subject " + Subjects.COMMERCE + " is: " + commerce / 100 * 4);
                    break;
                case COMPUTERS:
                    System.out.println("GPA for subject " + Subjects.COMPUTERS + " is: " + computers / 100 * 4);
                    break;
                case PHYSICS:
                    System.out.println("GPA for subject " + Subjects.PHYSICS + " is: " + physics / 100 * 4);
                    break;
            }
        }
    }
}
