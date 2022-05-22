package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Students;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import com.learnzilla.backend.register_login.repositories.TeacherRepository;
import com.learnzilla.backend.register_login.request.AuthenticationRequest;
import com.learnzilla.backend.register_login.response.AuthenticationResponse;
import com.learnzilla.backend.register_login.security.JWTTokenHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@CrossOrigin("*")
@RestController
public class StudentController {

    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder;
    private JWTTokenHelper jwtTokenHelper;
    private AuthenticationManager authenticationManager;


    @Autowired
    public StudentController(StudentRepository studentRepository, TeacherRepository teacherRepository, PasswordEncoder passwordEncoder, JWTTokenHelper jwtTokenHelper, AuthenticationManager authenticationManager) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenHelper = jwtTokenHelper;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/signup/student")
    public String signupStudent(@RequestBody Students studentData){
        if((studentRepository.findByEmail(studentData.getEmail())!=null) || teacherRepository.findByEmail(studentData.getEmail())!=null) {
            return "Email Already Exists";
        }
        else {
            studentData.setPassword(passwordEncoder.encode(studentData.getPassword()));
            studentRepository.save(studentData);
            return "Signup Completed Successfully";
        }
    }

    @GetMapping("/learnzilla/student/{email}")
    public ResponseEntity<Students> getStudentByEmail(@PathVariable String email){
        Students students = studentRepository.findByEmail(email);
        return ResponseEntity.ok(students);
    }


    @PostMapping("/login/student")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),authenticationRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken=jwtTokenHelper.generateToken(authentication);

        //UserDetails userDetails = authentication.getPrincipal();

        AuthenticationResponse response=new AuthenticationResponse();
        response.setToken(jwtToken);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/learnzilla/student/id/{id}")
    public ResponseEntity<Students> getStudent(@PathVariable Integer id) {
        Students students = studentRepository.findById(id).get();
        return ResponseEntity.ok(students);
    }

}
