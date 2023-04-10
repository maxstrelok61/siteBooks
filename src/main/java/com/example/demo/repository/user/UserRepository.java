package com.example.demo.repository.user;

import com.example.demo.Model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.status = 'ACTIVE' and  u.login = :name")
    User findByLogin(@Param("name") String name);
    @Query("select u from User u where u.status = 'ACTIVE'")
    List<User> getAll();
}
