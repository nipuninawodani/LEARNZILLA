package com.learnzilla.backend.announcements;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
}
