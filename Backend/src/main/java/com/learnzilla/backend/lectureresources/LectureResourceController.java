package com.learnzilla.backend.lectureresources;

import com.learnzilla.backend.models.Lecture;
import com.learnzilla.backend.models.LectureResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LectureResourceController {

    private LectureResourceRepository lectureResourceRepository;

    @Autowired
    public LectureResourceController(LectureResourceRepository lectureResourceRepository) {
        this.lectureResourceRepository = lectureResourceRepository;
    }

    @GetMapping("/learnzilla/lectureResource/lecture_id={lecture_id}")
    public ResponseEntity<List<LectureResource>> getLectureResourceById(@PathVariable Long lecture_id){
        List<LectureResource> lectureResource = lectureResourceRepository.findByLecture_id(lecture_id);
        return ResponseEntity.ok(lectureResource);
    }

    @PostMapping("/learnzilla/lectureResource")
    public void addLectureResource(@RequestBody LectureResource lectureResourceData) {
        lectureResourceRepository.save(lectureResourceData);
    }


    @PostMapping("/learnzilla/lectureResource/edit")
    public void updateLectureResource(@RequestBody LectureResource lectureResourceData) {

        LectureResource lectureResource = lectureResourceRepository.findByLectureresourseid(lectureResourceData.getLectureresourseid());

        if (lectureResourceData.getLecture_id()!=null){
            lectureResource.setLecture_id(lectureResourceData.getLecture_id());
        }

        if (lectureResourceData.getResource()!=null){
            lectureResource.setResource(lectureResourceData.getResource());
        }

        lectureResourceRepository.save(lectureResourceData);
    }

    @PostMapping("/learnzilla/lectureResource/delete")
    @Transactional
    public void deleteLectureResource(@RequestBody LectureResource lectureResourceData) {
        lectureResourceRepository.deleteAllByLectureresourseid(lectureResourceData.getLectureresourseid());
    }

}
