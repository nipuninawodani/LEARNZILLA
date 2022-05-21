package com.learnzilla.backend.lectureresources;

import com.learnzilla.backend.models.Enrollment;
import com.learnzilla.backend.models.LectureResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureResourceRepository extends JpaRepository<LectureResource, String> {

    @Query("SELECT r FROM LectureResource r WHERE r.lecture_id = ?1")
    List<LectureResource> findByLecture_id(Long lecture_id);

    LectureResource findByLectureresourseid(Long lectureresourseid);

    void deleteAllByLectureresourseid(Long lectureresourseid);
}