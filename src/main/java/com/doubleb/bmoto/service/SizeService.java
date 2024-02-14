package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.Size;
import com.doubleb.bmoto.repository.SizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {

    private final SizeRepository sizeRepository;

    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public List<Size> getAllSizesByProductId(Long id){
        return sizeRepository.findAllSizesByProductId(id);
    }

    public List<Size> getAllSizes(){
        return sizeRepository.findAllSizes();
    }
}
