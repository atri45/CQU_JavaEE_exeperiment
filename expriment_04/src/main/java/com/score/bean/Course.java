package com.score.bean;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private int courseId;

    private String name;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
