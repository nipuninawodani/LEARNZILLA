package com.learnzilla.backend.postmarks;

import com.learnzilla.backend.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMarksRepository extends JpaRepository<Enrollment, String> {

    @Query("SELECT m FROM Enrollment m WHERE m.student_id = ?1 AND m.course_code = ?2")
    List<Enrollment> findByStudent_idAndCourse_code(String student_id, String course_code );

    Enrollment findByEnrollmentid(String postmarksid);

    void deleteAllByEnrollmentid(String postMarksid);

    List<Enrollment> findByStudent_id(String student_id);
}
