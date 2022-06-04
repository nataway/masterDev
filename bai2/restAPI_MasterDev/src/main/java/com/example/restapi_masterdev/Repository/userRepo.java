package com.example.restapi_masterdev.Repository;

import com.example.restapi_masterdev.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface userRepo extends JpaRepository<User,Integer> {
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("SELECT u FROM User u WHERE u.email =: email")
//    public Optional<User> findByEmail(@Param("email") String email);

}
