package com.codecodence.admin_panel_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codecodence.admin_panel_backend.dto.CourseDTO;
import com.codecodence.admin_panel_backend.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    // CREATE
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO dto) {
        return courseService.saveCourseDTO(dto);
    }
    
    // BULK CREATE
    @PostMapping("/bulk")
    public List<CourseDTO> createMultipleCourses(@RequestBody List<CourseDTO> dtos) {
        return courseService.saveMultipleCourse(dtos);
    }
    
    // GET ALL
    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }
    
    // GET BY ID
    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
    
    // UPDATE
    @PutMapping("/{id}")
    public CourseDTO updateCourse(
            @PathVariable Long id,
            @RequestBody CourseDTO dto) {
        return courseService.updateCourse(id, dto);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course deleted successfully";
    }
}