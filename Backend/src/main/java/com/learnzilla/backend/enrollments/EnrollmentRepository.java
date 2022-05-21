package com.learnzilla.backend.enrollments;

import com.learnzilla.backend.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {

    @Query("SELECT e FROM Enrollment e WHERE e.course_code = ?1 AND e.academic_year = ?2")
    List<Enrollment> findBycourse_codeAndacademic_year(String course_code , String academic_year);

    @Query("SELECT e FROM Enrollment e WHERE e.student_id = ?1")
    List<Enrollment> findByStudent_id(Integer student_id);

    @Query("SELECT e FROM Enrollment e WHERE e.course_code = ?1 AND e.academic_year = ?2 AND e.student_id = ?3")
    Enrollment findEnroll(String course_code,String academic_year,int student_id);

    @Query("SELECT e FROM Enrollment e WHERE e.enrollmentid = ?1")
    Enrollment findByEnrollmentid(Long enrollmentid);

    void deleteAllByEnrollmentid(Long enrollmentid);
}