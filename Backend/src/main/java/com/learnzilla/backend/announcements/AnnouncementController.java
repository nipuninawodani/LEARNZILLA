package com.learnzilla.backend.announcements;

import com.learnzilla.backend.email.EmailSenderService;
import com.learnzilla.backend.enrollments.EnrollmentRepository;
import com.learnzilla.backend.models.Enrollment;
import com.learnzilla.backend.models.Students;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class AnnouncementController {

    private AnnouncementRepository announcementRepository;
    private EnrollmentRepository enrollmentRepository;
    private StudentRepository studentRepository;
    @Autowired
    private EmailSenderService mailSender;

    @Autowired
    public AnnouncementController(AnnouncementRepository announcementRepository, EnrollmentRepository enrollmentRepository, StudentRepository studentRepository) {
        this.announcementRepository = announcementRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/learnzilla/announcement/{id}")
    public Announcement getAnnouncement(@PathVariable Integer id){
        return announcementRepository.findById(id).get();
    }

    @GetMapping("/learnzilla/announcement/Get/{course_code}")
    public ResponseEntity<List<Announcement>> getAnnouncementByCourseCode(@PathVariable String course_code){
        List<Announcement> announcements = announcementRepository.findAnnouncementByCourse_code(course_code);
        return ResponseEntity.ok(announcements);
    }

    @GetMapping("/learnzilla/announcement")
    public List<Announcement> getAnnouncements(){
        return announcementRepository.findAll();
    }

    @PostMapping("/learnzilla/announcement")
    public void setAnnouncement(@RequestBody Announcement announcement){
      announcementRepository.save(announcement);
        List<Enrollment> enrollments = enrollmentRepository.findBycourse_code(announcement.course_code);
        enrollments.forEach((n)->{
            Students student = studentRepository.findById(n.getStudent_id()).get();
                    String Email = student.getEmail();
            mailSender.sendEmail(Email,announcement.title,announcement.message);
                });

    }
}


