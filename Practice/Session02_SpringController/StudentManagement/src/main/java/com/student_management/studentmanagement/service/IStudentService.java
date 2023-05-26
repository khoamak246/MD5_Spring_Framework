package com.student_management.studentmanagement.service;



import com.student_management.studentmanagement.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(Long id);
}

