package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Teachers;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import com.learnzilla.backend.register_login.repositories.TeacherRepository;
import com.learnzilla.backend.register_login.request.AuthenticationRequest;
import com.learnzilla.backend.register_login.response.AuthenticationResponse;
import com.learnzilla.backend.register_login.security.JWTTokenHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@CrossOrigin("*")
@RestController
public class TeacherController {

    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private PasswordEncoder passwordEncoder;
    private JWTTokenHelper jwtTokenHelper;
    private AuthenticationManager authenticationManager;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository, StudentRepository studentRepository, PasswordEncoder passwordEncoder, JWTTokenHelper jwtTokenHelper, AuthenticationManager authenticationManager) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenHelper = jwtTokenHelper;
        this.authenticationManager = authenticationManager;
        this.studentRepository=studentRepository;
    }

    @PostMapping("/signup/teacher")
    public String signupTeacher(@RequestBody Teachers teacherData) {
        if((studentRepository.findByEmail(teacherData.getEmail())!=null) || teacherRepository.findByEmail(teacherData.getEmail())!=null) {
            return "{Msg : \"Email Already Exists\"}";
        }
        else {
            teacherData.setPassword(passwordEncoder.encode(teacherData.getPassword()));
            teacherRepository.save(teacherData);
            return "{Msg : \"Signup Completed Successfully\"}";
        }
    }

    @GetMapping("/learnzilla/teacher/{email}")
    public ResponseEntity<Teachers> getTeacherByEmail(@PathVariable String email) {
        Teachers teachers = teacherRepository.findByEmail(email);
        return ResponseEntity.ok(teachers);
    }

    @PostMapping("/login/teacher")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),authenticationRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken=jwtTokenHelper.generateToken(authentication);

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();

        AuthenticationResponse response=new AuthenticationResponse();
        response.setToken(jwtToken);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/learnzilla/teacher/id/{id}")
    public ResponseEntity<Teachers> getTeacher(@PathVariable Integer id) {
        Teachers teachers = teacherRepository.findById(id).get();
        return ResponseEntity.ok(teachers);
    }
}