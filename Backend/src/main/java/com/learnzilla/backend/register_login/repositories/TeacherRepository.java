package com.learnzilla.backend.register_login.repositories;
import com.learnzilla.backend.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Integer> {

    @Query("SELECT t FROM Teachers t WHERE t.email = ?1")
    Teachers findByEmail(String email);
}