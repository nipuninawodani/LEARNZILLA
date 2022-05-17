package com.learnzilla.backend.signup;

import com.learnzilla.backend.signup.models.Student;
import com.learnzilla.backend.signup.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public SignupController(StudentRepository studentRepository,TeacherRepository teacherRepository ) {

        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/signup/teacher")
    public void signupTeacher(@RequestBody Teacher teacherData){
        teacherRepository.save(teacherData);
    }


    @PostMapping("/signup/student")
    public void signupStudent(@RequestBody Student studentData){
        studentRepository.save(studentData);
    }
}
