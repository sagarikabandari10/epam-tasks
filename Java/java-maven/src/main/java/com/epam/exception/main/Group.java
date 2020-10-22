package com.epam.exception.main;

import java.util.List;

public class Group {
    private final List<Subject> subjects;
    private final Common.GROUP gName;

    public Group(Common.GROUP gName, List<Subject> subjects) {
        this.subjects = subjects;
        this.gName = gName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Common.GROUP getgName() {
        return gName;
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "subjects=" + subjects +
                ", GroupName='" + gName + '\'' +
                '}';
    }
}
