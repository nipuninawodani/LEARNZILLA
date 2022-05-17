package com.learnzilla.backend.repositories;

import com.learnzilla.backend.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}