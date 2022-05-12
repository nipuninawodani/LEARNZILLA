package com.learnzilla.backend.courses;

import com.learnzilla.backend.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    private CourseRepository courseRepository;



    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/course/{course_code}&{academic_year}")
    public ResponseEntity<Course> getCourseByCourseCode(@PathVariable String course_code , @PathVariable String academic_year){
        Course course = courseRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/course")
    public ResponseEntity<Course> getAllCourses(){
        Course course = courseRepository.getAll();
        return ResponseEntity.ok(course);
    }

    @PostMapping("/course")
    public void addCourse(@RequestBody Course courseData) {
        courseRepository.save(courseData);
    }

}
