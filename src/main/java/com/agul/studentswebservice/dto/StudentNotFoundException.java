package com.agul.studentswebservice.dto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class StudentNotFoundException extends RuntimeException {

    /**
     *
     * @param id
     */
    public static final long serialVersionUID = 1L;


    public StudentNotFoundException(Long id) {
        super("Student with id " + id + " not found");
    }
}
