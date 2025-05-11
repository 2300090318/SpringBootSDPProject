package com.klef.sdp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.sdp.springboot.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    Faculty findByUsernameAndPassword(String username, String password);
}