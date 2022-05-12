package com.learnzilla.backend.lectures;

import com.learnzilla.backend.models.Enrollment;
import com.learnzilla.backend.models.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LectureController {

    private LectureRepository lectureRepository;



    @Autowired
    public LectureController(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @GetMapping("/lecture/{lecture_id}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable String lecture_id){
        Lecture lecture = lectureRepository.findByLecture_id(lecture_id);
        return ResponseEntity.ok(lecture);
    }

    @GetMapping("/enrollment/course_code={course_code}&academic_year={academic_year}")
    public ResponseEntity<Lecture> getLectureByCourse(@PathVariable String course_code , @PathVariable String academic_year){
        Lecture lecture = lectureRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(lecture);
    }

    @PostMapping("/lecture")
    public void addLecture(@RequestBody Lecture lectureData) {
        lectureRepository.save(lectureData);
    }

}
