package com.learnzilla.backend.lectures;

import com.learnzilla.backend.models.Enrollment;
import com.learnzilla.backend.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, String> {

    @Query("SELECT l FROM Lecture l WHERE l.lecture_id = ?1")
    Lecture findByLecture_id(String lecture_id);

    @Query("SELECT l FROM Lecture l WHERE l.course_code = ?1 AND l.academic_year = ?2")
    Lecture findBycourse_codeAndacademic_year(String course_code , String academic_year);
}