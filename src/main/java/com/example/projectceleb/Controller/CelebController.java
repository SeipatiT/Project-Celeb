package com.example.projectceleb.Controller;

import com.example.projectceleb.Entity.Celeb;
import com.example.projectceleb.Service.CelebService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class CelebController {
    private CelebService celebService;


    public CelebController(CelebService celebService) {
        super();
        this.celebService = celebService;
    }

    //Handler Method returns mode and view
    @RequestMapping("/")
    public String listCelebs(Model model) {
        model.addAttribute("celebs",
                celebService.getAllCelebs());
        return "celebs";
    }

    /* Create celebrity */
    @GetMapping("/celebs/new")
    public String createCelebEntry(Model model){
        // create celeb object to hold celeb form data
        Celeb celeb = new Celeb();
        model.addAttribute("celeb",celeb);
        return "create_celeb";
    }
    @PostMapping("/celebs")
    public String saveCeleb(@ModelAttribute("celeb") Celeb celeb){
    celebService.saveCeleb(celeb);
    return "forward:/";
    }

    /* edit celebrity*/
    @GetMapping("/celebs/edit/{id}")
    public String editCelebForm(@PathVariable Long id, Model model){
    model.addAttribute("celeb", celebService.getCelebById(id));
    return "edit_celeb";
    }

    @PostMapping("/celebs/{id}")
    public String updateCeleb(@PathVariable Long id,
      @ModelAttribute("celeb") Celeb celeb,
      Model model){

    //get celeb by id from databse
    Celeb existingCeleb = celebService.getCelebById(id);
    existingCeleb.setId(id);
    existingCeleb.setFirstName(celeb.getFirstName());
    existingCeleb.setLastName(celeb.getLastName());
    existingCeleb.setMovieTitle(celeb.getMovieTitle());

    //save updated celeb object
    celebService.updateCeleb(existingCeleb);
    return "forward:/";
    }

    //delete
    @GetMapping("/celebs/{id}")
    public String deleteCeleb(@PathVariable Long id){
    celebService.deleteCelebById(id);
    return "forward:/";
    }

    //wiki info

    @GetMapping("/wiki")
    public String wikiGo(){
        return "wiki";
    }





    }

