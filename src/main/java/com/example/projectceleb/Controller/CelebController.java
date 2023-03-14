package com.example.projectceleb.Controller;

import com.example.projectceleb.Entity.Celeb;
import com.example.projectceleb.Service.CelebService;


import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CelebController {
    private CelebService celebService;


    public CelebController(CelebService celebService) {
        super();
        this.celebService = celebService;
    }

    //Handler Method returns mode and view
    @GetMapping("/")
    public String listCelebs(Model model) {
        model.addAttribute("celebs",
                celebService.getAllCelebs());
        return "celebs";
    }

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
        return "redirect:/celebs";
        }

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
        return "redirect:/celebs";
        }

        //delete
        @GetMapping("/celebs/{id}")
        public String deleteCeleb(@PathVariable Long id){
        celebService.deleteCelebById(id);
        return "redirect:/celebs";
        }


    }

