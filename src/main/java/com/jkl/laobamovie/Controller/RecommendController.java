package com.jkl.laobamovie.Controller;


import com.jkl.laobamovie.Entity.Recommend;
import com.jkl.laobamovie.Repository.RecommendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class RecommendController {

    @Autowired
    RecommendRepository recommendRepository;

    @GetMapping("/getRec")
    @CrossOrigin
    public List getRec(@RequestParam(value = "user_id") Integer user_id){
        if (user_id==null) return recommendRepository.findHot();
        else return recommendRepository.findAllByUser(user_id);
    }

    @GetMapping("/getHotfilm")
    @CrossOrigin
    public List getfilm(){
        return recommendRepository.findHot();

    }


}
