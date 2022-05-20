package com.learnzilla.backend.postmarks;

import com.learnzilla.backend.enrollments.EnrollmentRepository;
import com.learnzilla.backend.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PostMarksController {

    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public PostMarksController(EnrollmentRepository enrollmentRepository){
        this.enrollmentRepository= enrollmentRepository;
    }

    @GetMapping("/enrollment/student_id={student_id}")
    public ResponseEntity<List<Enrollment>> getEnrollmentById(@PathVariable String student_id){
        List<Enrollment> enrollment = enrollmentRepository.findByStudent_id(student_id);
        return ResponseEntity.ok(Enrollment);
    }

    @PostMapping("/enrollment")
    public void postMarks(@RequestBody Enrollment enrollmentData){
        enrollmentRepository.save(enrollmentData);
    }

    @PostMapping("/entollment/edit")
    public void updatePostMarks(@RequestBody Enrollment enrollmentData) {


        Enrollment enrollment = enrollmentRepository.findByEnrollmentid(enrollmentData.getEnrollmentid());
        if (enrollmentData.getStudent_id()!=null){
            enrollment.setStudent_id(enrollmentData.getStudent_id());
        }

        if (enrollmentData.getOverall_grade()!=null){
            enrollment.setOverall_grade(enrollmentData.getOverall_grade());
        }
        enrollmentRepository.save(enrollmentData);
    }

    @PostMapping("/enrollment/delete")
    public void deletePostMarks(@RequestBody Enrollment enrollmentData) {
        enrollmentRepository.deleteAllByEnrollmentid(enrollmentData.getEnrollmentid());
    }

}
