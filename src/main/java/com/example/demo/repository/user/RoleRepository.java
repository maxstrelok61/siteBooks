package com.example.demo.repository.user;

import com.example.demo.Model.user.Role;
import com.example.demo.Model.user.StatusRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(StatusRole name);
}
