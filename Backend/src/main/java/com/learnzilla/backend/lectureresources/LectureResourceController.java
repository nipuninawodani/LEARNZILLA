package com.learnzilla.backend.lectureresources;

import com.learnzilla.backend.models.LectureResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LectureResourceController {

    private LectureResourceRepository lectureResourceRepository;



    @Autowired
    public LectureResourceController(LectureResourceRepository lectureResourceRepository) {
        this.lectureResourceRepository = lectureResourceRepository;
    }

    @GetMapping("/lectureResource/{course_code}&{academic_year}")
   /* public ResponseEntity<LectureResource> getLectureResource(@PathVariable String course_code , @PathVariable String academic_year){
        LectureResource lectureResource = lectureResourceRepository.findBycourse_codeAndacademic_year(course_code , academic_year);
        return ResponseEntity.ok(lectureResource);
    }*/

    @PostMapping("/lectureResource")
    public void addLectureResource(@RequestBody LectureResource lectureResourceData) {
        lectureResourceRepository.save(lectureResourceData);
    }

}
