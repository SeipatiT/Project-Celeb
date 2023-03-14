package com.example.projectceleb.Service;

import com.example.projectceleb.Entity.Celeb;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CelebService {

    List<Celeb> getAllCelebs();

    Celeb saveCeleb(Celeb celeb);

    Celeb updateCeleb(Celeb celeb);

    Celeb getCelebById(Long id);

    void deleteCelebById(Long id);



}
