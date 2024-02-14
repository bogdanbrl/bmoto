package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.Colour;
import com.doubleb.bmoto.repository.ColourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColourService {

    private final ColourRepository colourRepository;

    public ColourService(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    public List<Colour> getAllColoursByProductId(Long id){
        return colourRepository.findAllColoursByProductId(id);
    }

    public List<Colour> getAllColours(){
        return colourRepository.findAllColours();
    }
}
