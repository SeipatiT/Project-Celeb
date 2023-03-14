package com.example.projectceleb.Service;

import com.example.projectceleb.Entity.Celeb;
import com.example.projectceleb.Repository.CelebRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelebServiceImpl implements CelebService {

    private CelebRepository celebRepository;

    public CelebServiceImpl(CelebRepository celebRepository) {
        super();
        this.celebRepository = celebRepository;
    }

    @Override
    public List<Celeb> getAllCelebs() {

        return celebRepository.findAll();
    }

    @Override
    public Celeb saveCeleb(Celeb celeb) {

        return celebRepository.save(celeb);
    }


    @Override
    public Celeb getCelebById(Long id) {
        return celebRepository.findById(id).get();
    }

    @Override
    public Celeb updateCeleb(Celeb celeb) {
        return celebRepository.save(celeb);
    }


    @Override
    public void deleteCelebById(Long id) {
        celebRepository.deleteById(id);

    }
}
