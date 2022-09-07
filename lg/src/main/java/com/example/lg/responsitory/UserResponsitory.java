package com.example.lg.responsitory;

import com.example.lg.model.Article;
import com.example.lg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserResponsitory extends JpaRepository<User,Integer> {
//    @Query("SELECT u FROM User u where u.name = :name and  u.password = :password")
    User findUserByNameAndPasswordLike(@Param("name") String name, @Param("password") String password);

}