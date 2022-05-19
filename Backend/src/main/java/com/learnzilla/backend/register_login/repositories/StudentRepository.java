package com.learnzilla.backend.register_login.repositories;

import com.learnzilla.backend.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {

    @Query("SELECT s FROM Students s WHERE s.email = ?1")
    Students findByEmail(String email);

}
