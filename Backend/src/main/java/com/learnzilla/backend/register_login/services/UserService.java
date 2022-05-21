package com.learnzilla.backend.register_login.services;

import com.learnzilla.backend.models.Students;
import com.learnzilla.backend.models.Teachers;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import com.learnzilla.backend.register_login.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public UserService(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails user = null;
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Students student = studentRepository.findByEmail(username);

        if (student == null) {

            Teachers teacher = teacherRepository.findByEmail(username);
            if (teacher == null) {
                throw new UsernameNotFoundException("User not found");
            }
            else{
                user = new User(teacher.getEmail(), teacher.getPassword(), authorities);
            }

        }
        else {
            user = new User(student.getEmail(), student.getPassword(), authorities);
        }
        return user;
    }
}
