package com.epam.exception.main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Run {
   static List<Group> groups;
   static List<Teacher> teachers;
   static List<Student> students;

    public static void setDummyData(){
        Subject che = new Subject(Common.SUBJECTS.CHEMISTRY,8);
        Subject mat = new Subject(Common.SUBJECTS.MATHS,6);
        Subject com = new Subject(Common.SUBJECTS.COMPUTERS,7);
        Subject phy = new Subject(Common.SUBJECTS.PHYSICS,9);
        Subject cmm= new Subject(Common.SUBJECTS.COMMERS,6);
        Group g1 = new Group(Common.GROUP.MBA, Arrays.asList(mat,cmm));
        Group g2 = new Group(Common.GROUP.MCA, Arrays.asList(mat,com));
        Group g3 = new Group(Common.GROUP.PHD, Arrays.asList(che));
        groups = Arrays.asList(g1,g2,g3);

        Teacher t1 = new Teacher("Saga", LocalDate.of(1989, 1, 10), "Minsk", 45287962, "Professor", Common.GROUP.MBA);
        Teacher t2 = new Teacher("Pra", LocalDate.of(2016, 5, 28), "Minsk", 111111111, "Assistant Professor", Common.GROUP.MCA);
        Teacher t3 = new Teacher("Kiran", LocalDate.of(2005, 8, 12), "Hyderabad", 222222222, "Assistant Manager", Common.GROUP.PHD);
        Teacher t4 = new Teacher("Ravi",LocalDate.of(1988,4,15),"Hyderbad",5849672,"Professor",Common.GROUP.MCA);
        Teacher t5 = new Teacher("Ajay",LocalDate.of(1988,4,15),"Hyderbad",5849672,"Junior Professor",Common.GROUP.MCA);
        Teacher t6 = new Teacher("Anil",LocalDate.of(1988,4,15),"Hyderbad",5849672,"Senior Professor",Common.GROUP.MCA);
        Teacher t7 = new Teacher("Pranavi",LocalDate.of(1988,4,15),"Hyderbad",5849672,"Junior Professor",Common.GROUP.MCA);

        teachers = Arrays.asList(t1, t2, t3,t4,t5,t6,t7);

        Student s1 = new Student("aaaa", LocalDate.of(2012, 1, 10), "Minsk", 45287962, Common.SUBJECTS.CHEMISTRY, 7);
        Student s2 = new Student("bbbb", LocalDate.of(2016, 5, 28), "Minsk", 111111111, Common.SUBJECTS.MATHS, 8);
        Student s3 = new Student("cccc", LocalDate.of(2012, 8, 12), "Minsk", 222222222, Common.SUBJECTS.CHEMISTRY, 5);
        Student s4 = new Student("dddd", LocalDate.of(2013, 1, 10), "Minsk", 45287962, Common.SUBJECTS.CHEMISTRY, 7);
        Student s5 = new Student("eeee", LocalDate.of(2014, 5, 28), "Minsk", 111111111, Common.SUBJECTS.MATHS, 8);
        Student s6 = new Student("ffff", LocalDate.of(2015, 8, 12), "Minsk", 222222222, Common.SUBJECTS.CHEMISTRY, 5);
        Student s7 = new Student("gggg", LocalDate.of(2016, 1, 10), "Minsk", 45287962, Common.SUBJECTS.CHEMISTRY, 7);
        Student s8 = new Student("hhhh", LocalDate.of(2014, 5, 28), "Minsk", 111111111, Common.SUBJECTS.MATHS, 8);
        Student s9 = new Student("iiii", LocalDate.of(2013, 8, 12), "Minsk", 222222222, Common.SUBJECTS.CHEMISTRY, 5);
        students = Arrays.asList(s1, s2, s3, s4, s5,s6,s7,s8,s9);
    }

    public static void getAvgGradeForStudents(){
        int sum = 0;
        for(Student s: students){
            sum += s.getGrade();
        }
        float avg = sum/students.size();
        System.out.println("Total Students: "+students.size()+"\nGrade sum: "+sum+"\nAverage Grade: "+avg);
    }

    public static void getTeachers(){
        for(Teacher t: teachers){
            System.out.println(t.getName()+"("+t.getTitle()+"):");
            for(Group g: groups){
                if(t.getGroup().equals(g.getgName())){
                    StringBuilder sb = new StringBuilder();
                    int sum = 0;
                    for(Subject s: g.getSubjects()){
                        sum += s.getGrade();
                        sb.append(String.format("%s[grade-%s],",s.getName().toString(),s.getGrade()));
                    }
                    float avg = sum/g.getSubjects().size();
                    System.out.printf("\t%s(%s)%n",g.getgName(), sb.substring(0,sb.length()-1));
                }

            }
        }
    }

    public static void getTeachersWithGroups() {
        for (Teacher t : teachers) {
            System.out.printf("Faculty: %s(%s) %n", t.getName(), t.getTitle());
            for (Group g : groups.stream().filter(s->s.getgName().equals(Common.GROUP.MCA)).collect(Collectors.toList())) {
                System.out.println("\tGroup: "+g.getgName());
                if (t.getGroup().equals(g.getgName())) {
                    for (Subject s : g.getSubjects().stream().filter(s->s.getName().equals(Common.SUBJECTS.MATHS)).collect(Collectors.toList())) {
                        System.out.printf("\t\tSubject: %s[grade-%s],%n", s.getName().toString(), s.getGrade());
                        for(Student std:students)
                            if(std.getSubject().equals(s.getName()))
                                System.out.println("\t\t\tStudent: "+std.getName());
                    }
                }
            }
        }
    }

   public static void getStudentsWithGroups(){
        for(Student s:students){
            System.out.println("Student: "+s.getName());
            for(Group g:groups){
                for(Subject sub:g.getSubjects()){
                    if(sub.getName().equals(s.getSubject())) {
                        System.out.println("\tTeacher: "+getTeacherByGroup(g.getgName()));
                        System.out.println("\t\tSubject: " + sub.getName()+"-(Grade "+sub.getGrade()+")");
                    }
                }
            }
        }
   }

   public static String getTeacherByGroup(Common.GROUP name){
        return teachers.stream()
                .filter(s->s.getGroup().equals(name))
                .map(a->a.getName()+"-"+a.getTitle()+"("+name+")")
                .limit(1)
                .collect(Collectors.joining());
   }

    public static void main(String[] args) {
        setDummyData();
//        getAvgGradeForStudents();
        getStudentsWithGroups();
//        University university = new University("Oxford University", teachers, students, groups);
//        System.out.println(university);
    }

}
