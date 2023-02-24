package com.xqy.tms.service;

import com.xqy.tms.mapper.CornerAluminumRepository;
import com.xqy.tms.model.CornerAluminum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CornerAluminumService{

    @Autowired
    private CornerAluminumRepository cornerAluminumRepository;


    public CornerAluminum addCornerAluminum(CornerAluminum cornerAluminum) {
        return cornerAluminumRepository.save(cornerAluminum);
    }


    public CornerAluminum updateCornerAluminum(CornerAluminum cornerAluminum) {
        return cornerAluminumRepository.save(cornerAluminum);
    }


    public Optional<CornerAluminum> findCornerAluminumById(Long id) {
        return cornerAluminumRepository.findById(id);
    }
    
}
