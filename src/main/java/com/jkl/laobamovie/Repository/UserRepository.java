package com.jkl.laobamovie.Repository;

import com.jkl.laobamovie.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from user where username=:username", nativeQuery = true)
    public User findbyUsername(@Param("username") String username);
}
