package com.learnzilla.backend.postmarks;

import com.learnzilla.backend.enrollments.EnrollmentRepository;
import com.learnzilla.backend.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MarksController {

    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public MarksController(EnrollmentRepository enrollmentRepository){
        this.enrollmentRepository= enrollmentRepository;
    }

    @PostMapping("/learnzilla/postmarks/edit")
    public void updatePostMarks(@RequestBody Enrollment enrollmentData) {

        Enrollment enrollment = enrollmentRepository.findByEnrollmentid(enrollmentData.getEnrollmentid());

        if (enrollmentData.getOverall_grade()!=null){
            enrollment.setOverall_grade(enrollmentData.getOverall_grade());
        }
        enrollmentRepository.save(enrollment);
    }

    @GetMapping("/learnzilla/getmarks/student_id={student_id}")
    public ResponseEntity<List<Enrollment>> getMarksById(@PathVariable Integer student_id){
        List<Enrollment> enrollment = enrollmentRepository.findByStudent_id(student_id);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/learnzilla/getmarks/course_code={course_code}&academic_year={academic_year}&student_id={student_id}")
    public ResponseEntity<Enrollment> getMarksByCourse(@PathVariable String course_code , @PathVariable String academic_year, @PathVariable Integer student_id){
        Enrollment enrollment = enrollmentRepository.findEnroll(course_code , academic_year , student_id);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/learnzilla/getmarks")
    public ResponseEntity<List<Enrollment>> getMarks(){
        List<Enrollment> enrollment = enrollmentRepository.findAll();
        return ResponseEntity.ok(enrollment);
    }

}
