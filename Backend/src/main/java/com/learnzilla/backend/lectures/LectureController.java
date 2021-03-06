package com.learnzilla.backend.lectures;

import com.learnzilla.backend.models.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class LectureController {

    private LectureRepository lectureRepository;

    @Autowired
    public LectureController(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @GetMapping("/learnzilla/lecture/{lectureid}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable Long lectureid){
        Lecture lecture = lectureRepository.findByLectureid(lectureid);
        return ResponseEntity.ok(lecture);
    }

    @GetMapping("/learnzilla/lecture/get/course_code={course_code}&academic_year={academic_year}")
    public ResponseEntity<List<Lecture>> getLectureByCourse(@PathVariable String course_code , @PathVariable String academic_year){
        List<Lecture> lecture = lectureRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(lecture);
    }


    @PostMapping("/learnzilla/lecture")
    public String addLecture(@RequestBody Lecture lectureData) {
        lectureRepository.save(lectureData);
        return String.valueOf(lectureData.getLectureid());
    }

    @PostMapping("/learnzilla/lecture/edit")
    public void updateLecture(@RequestBody Lecture lectureData) {
        Lecture lecture = lectureRepository.findByLectureid(lectureData.getLectureid());

        if (lectureData.getAcademic_year()!=null){
            lecture.setAcademic_year(lectureData.getAcademic_year());
        }

        if (lectureData.getCourse_code()!=null){
            lecture.setCourse_code(lectureData.getCourse_code());
        }

        if (lectureData.getDescription()!=null){
            lecture.setDescription(lectureData.getDescription());
        }

        if (lectureData.getTitle()!=null){
            lecture.setTitle(lectureData.getTitle());
        }

        lectureRepository.save(lecture);
    }

    @PostMapping("/learnzilla/lecture/delete")
    @Transactional
    public void deleteLecture(@RequestBody Lecture lectureData) {
        lectureRepository.deleteAllByLectureid(lectureData.getLectureid());
    }
}
