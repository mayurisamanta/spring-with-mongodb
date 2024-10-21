package com.spring.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Field("subject_name")
    private String subjectName;

    @Field("marks_obtained")
    private int marksObtained;
}
