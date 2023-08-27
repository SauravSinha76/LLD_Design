package com.example.BMS.services;

import com.example.BMS.exception.ShowNorFoundException;
import com.example.BMS.model.Show;
import com.example.BMS.repositories.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowService {

    private ShowRepository showRepository;
    public Show getShowById(int id) throws ShowNorFoundException {
        Optional<Show> show = showRepository.findById(id);
        if(show.isEmpty()){
            throw new ShowNorFoundException("No show is found of the give id:"+id);
        }
        return show.get();
    }
}
