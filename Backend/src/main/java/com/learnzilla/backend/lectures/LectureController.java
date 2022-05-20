package com.learnzilla.backend.lectures;

import com.learnzilla.backend.models.Enrollment;
import com.learnzilla.backend.models.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LectureController {

    private LectureRepository lectureRepository;

    @Autowired
    public LectureController(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @GetMapping("/lecture/{lectureid}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable Long lectureid){
        Lecture lecture = lectureRepository.findByLectureid(lectureid);
        return ResponseEntity.ok(lecture);
    }

    @GetMapping("/lecture/get/course_code={course_code}&academic_year={academic_year}")
    public ResponseEntity<List<Lecture>> getLectureByCourse(@PathVariable String course_code , @PathVariable String academic_year){
        List<Lecture> lecture = lectureRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(lecture);
    }

    @PostMapping("/lecture")
    public void addLecture(@RequestBody Lecture lectureData) {
        lectureRepository.save(lectureData);
    }

    @PostMapping("/lecture/edit")
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

        if (lectureData.getWeek()!=null){
            lecture.setWeek(lectureData.getWeek());
        }

        lectureRepository.save(lecture);
    }

    @PostMapping("/lecture/delete")
    public void deleteLecture(@RequestBody Lecture lectureData) {
        lectureRepository.deleteAllByLectureid(lectureData.getLectureid());
    }
}
