package com.learnzilla.backend.enrollments;

import com.learnzilla.backend.models.Course;
import com.learnzilla.backend.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollmentController {

    private EnrollmentRepository enrollmentRepository;


    @Autowired
    public EnrollmentController(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @GetMapping("/enrollment/course_code={course_code}&academic_year={academic_year}")
    public ResponseEntity<List<Enrollment>> getEnrollmentByCourse(@PathVariable String course_code , @PathVariable String academic_year){
        List<Enrollment> enrollment = enrollmentRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/enrollment/student_id={student_id}")
    public ResponseEntity<List<Enrollment>> getEnrollmentByStudent(@PathVariable String student_id){
        List<Enrollment> enrollment = enrollmentRepository.findByStudent_id(student_id);
        return ResponseEntity.ok(enrollment);
    }
    @PostMapping("/enrollment")
    public void addEnrollment(@RequestBody Enrollment enrollmentData) {
        enrollmentRepository.save(enrollmentData);
    }

    @PostMapping("/enrollment/edit")
    public void updateEnrollment(@RequestBody Enrollment enrollmentData) {
        Enrollment enrollment = enrollmentRepository.findByEnrollmentid(enrollmentData.getEnrollmentid());

        if (enrollmentData.getAcademic_year()!=null){
            enrollment.setAcademic_year(enrollmentData.getAcademic_year());
        }

        if (enrollmentData.getCourse_code()!=null){
            enrollment.setCourse_code(enrollmentData.getCourse_code());
        }

        if (enrollmentData.getStudent_id()!=null){
            enrollment.setStudent_id(enrollmentData.getStudent_id());
        }

        if (enrollmentData.getOverall_grade()!=null){
            enrollment.setOverall_grade(enrollmentData.getOverall_grade());
        }

        enrollmentRepository.save(enrollment);
    }

    @PostMapping("/enrollment/delete")
    public void deleteEnrollment(@RequestBody Enrollment enrollmentData) {
        enrollmentRepository.deleteAllByEnrollmentid(enrollmentData.getEnrollmentid());
    }

}
