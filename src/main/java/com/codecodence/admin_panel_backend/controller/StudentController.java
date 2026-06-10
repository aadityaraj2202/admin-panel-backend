package com.codecodence.admin_panel_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.codecodence.admin_panel_backend.dto.StudentDTO;
import com.codecodence.admin_panel_backend.service.StudentServices;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    // CREATE
    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO dto) {
        return studentServices.saveStudent(dto);
    }

    // BULK CREATE
    @PostMapping("/bulk")
    public List<StudentDTO> createMultipleStudents(@RequestBody List<StudentDTO> dtos) {
        return studentServices.saveMultipleStudents(dtos);
    }

    // GET ALL
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentServices.getAllStudents();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentServices.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public StudentDTO updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDTO dto) {
        return studentServices.updateStudent(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentServices.deleteStudent(id);
        return "Student deleted successfully";
    }
}


