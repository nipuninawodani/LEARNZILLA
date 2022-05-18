package com.learnzilla.backend.register_login.repositories;

import com.learnzilla.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Students s WHERE s.email = ?1")
    Student findByEmail(String email);

}
