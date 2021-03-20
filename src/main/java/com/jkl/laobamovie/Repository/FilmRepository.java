package com.jkl.laobamovie.Repository;

import com.jkl.laobamovie.Entity.Film_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film_info,Integer> {

    @Query(value = "select * from film_info order by rate desc limit :gap",nativeQuery = true)
    public List<Film_info> find20(@Param("gap") Integer gap);

    @Query(value = "select * from film_info where id=:id",nativeQuery = true)
    public Film_info findById1(@Param("id") String Id);
}
