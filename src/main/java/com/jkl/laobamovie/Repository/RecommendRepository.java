package com.jkl.laobamovie.Repository;

import com.jkl.laobamovie.Entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface RecommendRepository extends JpaRepository<Recommend,Integer> {

    @Query(value = "select movie_id,name,rating from film_info,recommend WHERE film_info.id=recommend.movie_id AND user_id=:userid order by rating desc ", nativeQuery = true)
    List findAllByUser(@Param("userid") Integer userid);

    @Query(value = "select id,name,rate from film_info ORDER BY rate DESC limit 20",nativeQuery = true)
    List findHot();
}
