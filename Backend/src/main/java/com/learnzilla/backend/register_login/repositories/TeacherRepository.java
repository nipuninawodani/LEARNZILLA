package com.learnzilla.backend.register_login.repositories;
import com.learnzilla.backend.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("SELECT t FROM Teachers t WHERE t.email = ?1")
    Teacher findByEmail(String email);
}