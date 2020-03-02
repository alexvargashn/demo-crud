/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.democrud.service.impl;

import com.example.democrud.model.Persona;
import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.PersonaDaoAPI;
import com.example.democrud.service.api.PersonaServiceAPI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexv
 */
@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI {
    
    @Autowired
    private PersonaDaoAPI personaDaoAPI;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return  personaDaoAPI;
    }
    
}
