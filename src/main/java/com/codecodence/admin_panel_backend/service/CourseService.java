package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codecodence.admin_panel_backend.dto.CourseDTO;
import com.codecodence.admin_panel_backend.entity.Courses;
import com.codecodence.admin_panel_backend.repository.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    public CourseRepository courseRepository;
    
    public CourseDTO saveCourseDTO(CourseDTO dto) {
        Courses course = new Courses();
        course.setCourseName(dto.getCourseName());
        course.setDesciption(dto.getDesciption());
        course.setDuration(dto.getDuration());
        course.setFees(dto.getFees());
        
        return new CourseDTO(courseRepository.save(course));
    }
    
    public List<CourseDTO> saveMultipleCourse(List<CourseDTO> dtos) {
        List<Courses> courses = dtos.stream().map(dto -> {
            Courses course = new Courses();
            course.setCourseName(dto.getCourseName());
            course.setDesciption(dto.getDesciption());
            course.setDuration(dto.getDuration());
            course.setFees(dto.getFees());
            return course;
        }).toList();

        return courseRepository.saveAll(courses)
                .stream()
                .map(CourseDTO::new)
                .toList();
    }
    
    // GET ALL
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseDTO::new)
                .toList();
    }
    
    // GET BY ID
    public CourseDTO getCourseById(Long id) {
       Courses course = courseRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Course not found"));
            return new CourseDTO(course);
    }

    // UPDATE
    public CourseDTO updateCourse(Long id,  CourseDTO dto) {
        Courses course = courseRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setCourseName(dto.getCourseName());
        course.setDesciption(dto.getDesciption());
        course.setDuration(dto.getDuration());
        course.setFees(dto.getFees());

        return new CourseDTO(courseRepository.save(course));
    }

    // DELETE
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}