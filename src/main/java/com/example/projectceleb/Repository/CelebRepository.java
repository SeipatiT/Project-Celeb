package com.example.projectceleb.Repository;

import com.example.projectceleb.Entity.Celeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelebRepository
        extends JpaRepository<Celeb, Long> {
}
