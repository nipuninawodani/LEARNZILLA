package com.learnzilla.backend.lectureresources;

import com.learnzilla.backend.models.Enrollment;
import com.learnzilla.backend.models.LectureResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureResourceRepository extends JpaRepository<LectureResource, String> {

    @Query("SELECT r FROM LectureResource r WHERE r.course_code = ?1 AND r.academic_year = ?2")
    LectureResource findBycourse_codeAndacademic_year(String course_code , String academic_year);

    LectureResource findByLecture_id(String lecture_id);
}