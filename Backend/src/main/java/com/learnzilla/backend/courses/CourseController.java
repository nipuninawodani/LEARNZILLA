package com.learnzilla.backend.courses;

import com.learnzilla.backend.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CourseController {

    private CourseRepository courseRepository;



    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/learnzilla/course/get/{course_code}&{academic_year}")
    public ResponseEntity<Course> getCourseByCourseCode(@PathVariable String course_code , @PathVariable String academic_year){
        Course course = courseRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/learnzilla/course/{teacher_id}")
    public ResponseEntity<List<Course>> getCoursesByTeacher(@PathVariable String teacher_id){
        List<Course> course = courseRepository.findByTeacher_id(teacher_id);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/learnzilla/course")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> course = courseRepository.findAll();
        return ResponseEntity.ok(course);
    }

    @PostMapping("/course")
    public void addCourse(@RequestBody Course courseData) {
        courseRepository.save(courseData);
    }


    @PostMapping("/course/edit")
    public void updateCourse(@RequestBody Course courseData) {
        Course course = courseRepository.findByCourseid(courseData.getCourseid());

        if (courseData.getLanguage()!=null){
            course.setLanguage(courseData.getLanguage());
        }

        if (courseData.getLevel()!=null){
            course.setLevel(courseData.getLevel());
        }

        if (courseData.getSemester()!=null){
            course.setSemester(courseData.getSemester());
        }

        if (courseData.getTitle()!=null){
            course.setTitle(courseData.getTitle());
        }

        if (course.getTeacher_id()!=null){
            course.setTeacher_id(course.getTeacher_id());
        }

        if (courseData.getDescription()!=null){
            course.setDescription(courseData.getDescription());
        }
        courseRepository.save(course);
    }

    @PostMapping("/course/delete")
    @Transactional
    public void deleteCourse(@RequestBody Course courseData) {
        courseRepository.deleteAllByCourseid(courseData.getCourseid());
    }

}
