package com.learnzilla.backend.signup;

import com.learnzilla.backend.signup.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
