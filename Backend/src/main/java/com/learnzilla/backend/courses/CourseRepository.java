package com.learnzilla.backend.courses;

import com.learnzilla.backend.models.Course;
import com.learnzilla.backend.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query("SELECT c FROM Course c WHERE c.course_code = ?1 AND c.academic_year = ?2")
    Course findBycourse_codeAndacademic_year(String course_code , String academic_year);

    Course findByCourseid(Long courseid);
}