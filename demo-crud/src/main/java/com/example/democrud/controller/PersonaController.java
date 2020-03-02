/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.democrud.controller;

import com.example.democrud.model.Persona;
import com.example.democrud.service.api.PersonaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexv
 */
@Controller
public class PersonaController {
    
    @Autowired
    private PersonaServiceAPI personaServiceAPI;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", personaServiceAPI.getAll());
        
        return "index";
    }
    
    @GetMapping("/save/{id}")
    public String showSave(@PathVariable("id") Long id, Model model) {
        if(id != null) {
            model.addAttribute("persona", personaServiceAPI.get(id));
        }
        return "save";
    }
    
    @PostMapping("/save")
    public String save(Persona persona, Model model) {
        personaServiceAPI.save(persona);
        
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        personaServiceAPI.delete(id);
        
        return "redirect:/";
    }
}
