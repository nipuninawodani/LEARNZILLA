package com.learnzilla.backend.register_login.repositories;

import com.learnzilla.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT * FROM Students WHERE email = ?1")
    public Student findByEmail(String email);

}
