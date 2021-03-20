package com.jkl.laobamovie.Controller;

import com.jkl.laobamovie.Entity.Film_info;
import com.jkl.laobamovie.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Value("${movie_id}")
    private String movie_id;

    @Autowired
    FilmRepository filmRepository;


    @GetMapping("/film")
    @CrossOrigin
    public List<Film_info> list(@RequestParam(value = "gap",required = false,defaultValue = "20") Integer gap){
        return filmRepository.find20(new Integer(gap));
    }

    @GetMapping("/find")
    @CrossOrigin
    public Film_info findFilm(@RequestParam(value = "id") String id){
        return filmRepository.findById1(id);
    }

}
