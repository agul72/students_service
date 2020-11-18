package com.agul.studentswebservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    Long id;
    String name;
    Map<String, Integer> scores;
}
