package com.agul.studentswebservice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode(of = {"id"})
@Document(collection = "students")
public class Student {
    long id;
    @Setter
    String name;
    @Setter
    String password;
    Map<String, Integer> scores;

    public Student(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        scores = new HashMap<>();
    }

    public boolean addScore(String examName, int score) {
        return scores.put(examName, score) != null;
    }
}
