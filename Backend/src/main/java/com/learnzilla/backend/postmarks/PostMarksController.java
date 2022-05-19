package com.learnzilla.backend.postmarks;

import com.learnzilla.backend.models.Students;
import com.learnzilla.backend.models.PostMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostMarksController {

    private  PostMarksRepository postMarksRepository;

    @Autowired
    public PostMarksController(PostMarksRepository postMarksRepository){
        this.postMarksRepository= postMarksRepository;
    }

    @GetMapping("/postMarks/student_id={student_id}")
    public ResponseEntity<List<PostMarks>> getPostMarksById(@PathVariable String student_id){
        List<PostMarks> postMarks = postMarksRepository.findByStudent_id(student_id);
        return ResponseEntity.ok(PostMarks);
    }

    @PostMapping("/postMarks")
    public void postMarks(@RequestBody PostMarks postMarksData){
        postMarksRepository.save(postMarksData);
    }

    @PostMapping("/postMarks/edit")
    public void updatePostMarks(@RequestBody PostMarks postMarksData) {

        PostMarks  postMarks = postMarksRepository.findByPostMarksid(postMarksData.getPostMarksid());
        if (postMarksData.getStudent_id()!=null){
            postMarks.setStudent_id(postMarksData.getStudent_id());
        }

        if (postMarksData.getMarks()!=null){
            lectureResource.setMarks(postMarksData.getMarks());
        }
        postMarksRepository.save(postMarksData);
    }

    @PostMapping("/postMarks/delete")
    public void deletePostMarks(@RequestBody PostMarks postMarksData) {
        postMarksRepository.deleteAllByPostMarksid(postMarksData.getPostMarksid());
    }

}
