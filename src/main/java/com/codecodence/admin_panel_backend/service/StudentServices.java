package com.codecodence.admin_panel_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecodence.admin_panel_backend.dto.StudentDTO;
import com.codecodence.admin_panel_backend.entity.Student;
import com.codecodence.admin_panel_backend.repository.StudentRepository;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    // CREATE
    public StudentDTO saveStudent(StudentDTO dto) {
        Student student = new Student();
        student.setStudentName(dto.getStudentName());
        student.setStudentEmail(dto.getStudentEmail());
        student.setCourses(dto.getCourses());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setAddress(dto.getAddress());

        return new StudentDTO(studentRepository.save(student));
    }

    // BULK CREATE
    public List<StudentDTO> saveMultipleStudents(List<StudentDTO> dtos) {
        List<Student> students = dtos.stream().map(dto -> {
            Student student = new Student();
            student.setStudentName(dto.getStudentName());
            student.setStudentEmail(dto.getStudentEmail());
            student.setCourses(dto.getCourses());
            student.setPhoneNumber(dto.getPhoneNumber());
            student.setAddress(dto.getAddress());
            return student;
        }).toList();

        return studentRepository.saveAll(students)
                .stream()
                .map(StudentDTO::new)
                .toList();
    }

    // GET ALL
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentDTO::new)
                .toList();
    }

    // GET BY ID
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return new StudentDTO(student);
    }

    // UPDATE
    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setStudentName(dto.getStudentName());
        student.setStudentEmail(dto.getStudentEmail());
        student.setCourses(dto.getCourses());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setAddress(dto.getAddress());

        return new StudentDTO(studentRepository.save(student));
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}



