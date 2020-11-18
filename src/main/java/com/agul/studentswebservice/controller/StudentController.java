package com.agul.studentswebservice.controller;

import com.agul.studentswebservice.dto.ScoreDto;
import com.agul.studentswebservice.dto.StudentDto;
import com.agul.studentswebservice.dto.StudentResponseDto;
import com.agul.studentswebservice.dto.StudentUpdateDto;
import com.agul.studentswebservice.service.StudentService;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    //    @Autowired
    private final StudentService studentService;

    @PostMapping("/student")
    public boolean addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }

    @GetMapping("/student/{id}")
    public StudentResponseDto findStudent(@PathVariable Long id) {
        return studentService.findStudent(id);
    }

    @DeleteMapping("/student/{id}")
    public StudentResponseDto deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/student/{id}")
    public StudentDto editStudent(
            @PathVariable long id,
            @RequestBody StudentUpdateDto studentUpdateDto
    ) {
        return studentService.updateStudent(id, studentUpdateDto);
    }

    @PutMapping("/student/score/{id}")
    public boolean addScore(
            @PathVariable long id,
            @RequestBody ScoreDto scoreDto
    ) {
        return studentService.addScore(id, scoreDto);
    }

    @GetMapping("/students/name/{name}")
    public List<StudentResponseDto> findStudentByName(@PathVariable String name) {
        return studentService.findStudentsByName(name);
    }
}
