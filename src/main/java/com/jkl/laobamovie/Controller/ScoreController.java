package com.jkl.laobamovie.Controller;

import com.jkl.laobamovie.Entity.Score;
import com.jkl.laobamovie.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @Autowired
    ScoreRepository scoreRepository;

    @CrossOrigin
    @GetMapping("/findScore")
    public Score findScore(@RequestParam("userid") String userid,
                           @RequestParam("filmid") String filmid){
        return scoreRepository.findScore(userid, filmid);
    }



    @CrossOrigin
    @GetMapping("/score")
    public Score filmScore(@RequestParam("userid") String userid,
                           @RequestParam("filmid") String filmid,
                           @RequestParam("score") float score) {
        Score score1 = scoreRepository.findScore(userid, filmid);
        if (score1!=null){
            score1.setUserId(userid);
            score1.setFilmId(filmid);
            score1.setScore(score);
            return scoreRepository.save(score1);
        }else{
            score1 = new Score();
            score1.setUserId(userid);
            score1.setFilmId(filmid);
            score1.setScore(score);
            return scoreRepository.save(score1);
        }
    }
}
