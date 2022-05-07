package com.learnzilla.backend.enrollment;

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

    @GetMapping("/enrollment/{course_code}&{academic_year}")
    public ResponseEntity<Enrollment> getEnrollment(@PathVariable String course_code , @PathVariable String academic_year){
        Enrollment enrollment = enrollmentRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(enrollment);
    }

    @PostMapping("/enrollment")
    public void addEnrollment(@RequestBody Enrollment enrollmentData) {
        enrollmentRepository.save(enrollmentData);
    }

}
