package com.learnzilla.backend.enrollments;

import com.learnzilla.backend.models.Course;
import com.learnzilla.backend.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollmentController {

    private EnrollmentRepository enrollmentRepository;


    @Autowired
    public EnrollmentController(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @GetMapping("/learnzilla/enrollment/check/course_code={course_code}&academic_year={academic_year}&student_id={student_id}")
    public ResponseEntity<Enrollment> checkEnroll(@PathVariable String course_code , @PathVariable String academic_year,@PathVariable Integer student_id){
        Enrollment enrollment = enrollmentRepository.findEnroll(course_code,academic_year,student_id);
        return ResponseEntity.ok(enrollment);
    }


    @GetMapping("/learnzilla/enrollment/get/course_code={course_code}&academic_year={academic_year}")
    public ResponseEntity<List<Enrollment>> getEnrollmentByCourse(@PathVariable String course_code , @PathVariable String academic_year){
        List<Enrollment> enrollment = enrollmentRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/learnzilla/enrollment/student_id={student_id}")
    public ResponseEntity<List<Enrollment>> getEnrollmentById(@PathVariable Integer student_id){
        List<Enrollment> enrollment = enrollmentRepository.findByStudent_id(student_id);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/learnzilla/enrollment/{enrollmentid}")
    public ResponseEntity<Enrollment> getEnrollmentByStudent(@PathVariable Long enrollmentid){
        Enrollment enrollment = enrollmentRepository.findByEnrollmentid(enrollmentid);
        return ResponseEntity.ok(enrollment);
    }

    @PostMapping("/learnzilla/enrollment")
    public void addEnrollment(@RequestBody Enrollment enrollmentData) {
        enrollmentRepository.save(enrollmentData);
    }

    @PostMapping("/learnzilla/enrollment/edit")
    public void updateEnrollment(@RequestBody Enrollment enrollmentData) {
        Enrollment enrollment = enrollmentRepository.findByEnrollmentid(enrollmentData.getEnrollmentid());

        if (enrollmentData.getAcademic_year()!=null){
            enrollment.setAcademic_year(enrollmentData.getAcademic_year());
        }

        if (enrollmentData.getCourse_code()!=null){
            enrollment.setCourse_code(enrollmentData.getCourse_code());
        }

        if (enrollmentData.getStudent_id()!=0){
            enrollment.setStudent_id(enrollmentData.getStudent_id());
        }

        if (enrollmentData.getOverall_grade()!=null){
            enrollment.setOverall_grade(enrollmentData.getOverall_grade());
        }

        enrollmentRepository.save(enrollment);
    }

    @PostMapping("/learnzilla/enrollment/delete")
    @Transactional
    public void deleteEnrollment(@RequestBody Enrollment enrollmentData) {
        enrollmentRepository.deleteAllByEnrollmentid(enrollmentData.getEnrollmentid());
    }

}
