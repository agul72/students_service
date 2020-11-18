package com.agul.studentswebservice.service;

import com.agul.studentswebservice.dto.ScoreDto;
import com.agul.studentswebservice.dto.StudentDto;
import com.agul.studentswebservice.dto.StudentResponseDto;
import com.agul.studentswebservice.dto.StudentUpdateDto;

import java.util.List;

public interface StudentService {

    boolean addStudent(StudentDto studentDto);

    StudentResponseDto findStudent(Long id);

    StudentResponseDto deleteStudent(Long id);

    StudentDto updateStudent(Long id, StudentUpdateDto studentUpdateDto);

    boolean addScore(Long id, ScoreDto scoreDto);

    List<StudentResponseDto> findStudentsByName(String name);
}
