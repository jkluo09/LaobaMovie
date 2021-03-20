package com.jkl.laobamovie.Repository;

import com.jkl.laobamovie.Entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScoreRepository extends JpaRepository<Score,Integer> {

    @Query(value = "select * from score where user_id=:userid and film_id=:filmid",nativeQuery = true)
    public Score findScore(@Param("userid") String userid,
                           @Param("filmid") String filmid);
}
