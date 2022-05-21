package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Students;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import com.learnzilla.backend.register_login.request.AuthenticationRequest;
import com.learnzilla.backend.register_login.response.AuthenticationResponse;
import com.learnzilla.backend.register_login.security.JWTTokenHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@CrossOrigin("*")
@RestController
public class StudentController {

    private StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private JWTTokenHelper jwtTokenHelper;
    private AuthenticationManager authenticationManager;


    @Autowired
    public StudentController(StudentRepository studentRepository, PasswordEncoder passwordEncoder, PasswordEncoder passwordEncoder1, JWTTokenHelper jwtTokenHelper, AuthenticationManager authenticationManager) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder1;
        this.jwtTokenHelper = jwtTokenHelper;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/signup/student")
    public void signupStudent(@RequestBody Students studentData){
        studentData.setPassword(passwordEncoder.encode(studentData.getPassword()));
        studentRepository.save(studentData);
    }

    @GetMapping("/student/{email}")
    public ResponseEntity<Students> getStudentByEmail(@PathVariable String email){
        Students students = studentRepository.findByEmail(email);
        return ResponseEntity.ok(students);
    }


    @PostMapping("/student/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),authenticationRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Students student = (Students)authentication.getPrincipal();
        String jwtToken=jwtTokenHelper.generateToken(student.getEmail());

        AuthenticationResponse response=new AuthenticationResponse();
        response.setToken(jwtToken);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/student/id/{id}")
    public ResponseEntity<Students> getStudent(@PathVariable Integer id) {
        Students students = studentRepository.findById(id).get();
        return ResponseEntity.ok(students);
    }

}
