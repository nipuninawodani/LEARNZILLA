package com.learnzilla.backend.announcements;

import com.learnzilla.backend.signup.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

}


