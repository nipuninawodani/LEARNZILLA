package com.learnzilla.backend.enrollments;

import com.learnzilla.backend.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnrollmentController {

    private EnrollmentRepository enrollmentRepository;



    @Autowired
    public EnrollmentController(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @GetMapping("/enrollment/course_code={course_code}&academic_year={academic_year}")
    public ResponseEntity<Enrollment> getEnrollmentByCourse(@PathVariable String course_code , @PathVariable String academic_year){
        Enrollment enrollment = enrollmentRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/enrollment/student_id={student_id}")
    public ResponseEntity<Enrollment> getEnrollmentByStudent(@PathVariable String student_id){
        Enrollment enrollment = enrollmentRepository.findByStudent_id(student_id);
        return ResponseEntity.ok(enrollment);
    }
    @PostMapping("/enrollment")
    public void addEnrollment(@RequestBody Enrollment enrollmentData) {
        enrollmentRepository.save(enrollmentData);
    }

}
