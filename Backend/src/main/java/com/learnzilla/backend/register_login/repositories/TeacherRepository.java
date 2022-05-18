package com.learnzilla.backend.register_login.repositories;

import com.learnzilla.backend.models.Student;
import com.learnzilla.backend.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("SELECT * FROM Teachers WHERE email = ?1")
    public Teacher findByEmail(String email);
}