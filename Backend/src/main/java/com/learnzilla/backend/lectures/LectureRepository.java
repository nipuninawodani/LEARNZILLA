package com.learnzilla.backend.lectures;

import com.learnzilla.backend.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, String> {

    @Query("SELECT e FROM Lecture e WHERE e.course_code = ?1 AND e.academic_year = ?2")
    Lecture findBycourse_codeAndacademic_year(String course_code , String academic_year);
}