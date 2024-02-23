package com.aswin.Write.Your.Thought.Repositories;

import com.aswin.Write.Your.Thought.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //User findUserByMail (String Mail);
    //User findUserByUsername(String Username);
    //List<User> findUsersByMailOrUsername(String Mail,String Password);
    Optional<User> findUserByUsername(String username);
}
