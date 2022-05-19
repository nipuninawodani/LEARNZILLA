package com.learnzilla.backend.postmarks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostMarksRepository extends JpaRepository<PostMarks, String> {

    @Query("SELECT m FROM PostMarks m WHERE m.student_id = ?1 AND m.course_code = ?2")
    List<PostMarks> findByStudent_idAndCourse_code(String student_id, String course_code );

    PostMarks findByPostMarksid(String postmarksid);

    void deleteAllByPostMarksid(String postMarksid);

}
