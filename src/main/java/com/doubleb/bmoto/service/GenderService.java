package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.Gender;
import com.doubleb.bmoto.repository.GenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    private final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<Gender> getAllGenders(){
        return genderRepository.findAllGenders();
    }
}
