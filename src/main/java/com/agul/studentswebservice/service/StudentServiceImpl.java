package com.agul.studentswebservice.service;

import com.agul.studentswebservice.dao.StudentRepository;
import com.agul.studentswebservice.dto.*;
import com.agul.studentswebservice.model.Student;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    //        @Autowired
    private final StudentRepository studentRepository;

    @Override
    public boolean addStudent(StudentDto studentDto) {
        if (studentRepository.existsById(studentDto.getId())) {
            return false;
        }
        Student student = new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getPassword()
        );
        studentRepository.save(student);
        return true;
    }

    private StudentResponseDto studentToStudentResponseDto(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .scores(student.getScores())
                .build();
    }

    @Override
    public StudentResponseDto findStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return studentToStudentResponseDto(student);
    }

    @Override
    public StudentResponseDto deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.delete(student);
        return studentToStudentResponseDto(student);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentUpdateDto studentUpdateDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        if (studentUpdateDto.getName() != null) {
            student.setName(studentUpdateDto.getName());
        }
        if (studentUpdateDto.getPassword() != null) {
            student.setPassword(studentUpdateDto.getPassword());
        }
        studentRepository.save(student);
        return studentToStudentDto(student);
    }

    private StudentDto studentToStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .password(student.getPassword())
                .build();
    }

    @Override
    public boolean addScore(Long id, ScoreDto scoreDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        boolean res = student.addScore(scoreDto.getExamName(), scoreDto.getScore());
        studentRepository.save(student);
        return res;
    }

    @Override
    public List<StudentResponseDto> findStudentsByName(String name) {
        return studentRepository.findByName(name)
                .map(this::studentToStudentResponseDto)
                .collect(Collectors.toList());
    }


}
