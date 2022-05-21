package com.learnzilla.backend.announcements;

import com.learnzilla.backend.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

    @Query("SELECT a FROM Announcement a WHERE a.course_code = ?1 ORDER BY a.id")
    List<Announcement> findAnnouncementByCourse_code(String course_code);

}


