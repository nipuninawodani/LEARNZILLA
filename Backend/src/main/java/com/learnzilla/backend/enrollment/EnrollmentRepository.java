package com.learnzilla.backend.enrollment;

import com.learnzilla.backend.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {

    @Query("SELECT e FROM Enrollment e WHERE e.course_code = ?1 AND e.academic_year = ?2")
    Enrollment findBycourse_codeAndacademic_year(String course_code , String academic_year);
}