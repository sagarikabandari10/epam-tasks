package com.epam.exception.main;

import com.epam.exception.main.models.Groups;

import java.util.List;

public class Group {
    private final List<Subject> subject;
    private final Groups gName;

    public Group(Groups gName, List<Subject> subjects) {
        this.subject = subjects;
        this.gName = gName;
    }

    public List<Subject> getSubjects() {
        return subject;
    }

    public Groups getgName() {
        return gName;
    }

    @Override
    public String toString() {
        return "{'" + gName + '\'' +
                '}';
    }
}
