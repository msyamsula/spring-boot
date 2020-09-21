package com.example.springboot.dao;

import com.example.springboot.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.webmvc.RepositoryRestController;

// repository rest controller is for creating basic crud endpoint for free
// 1. GET /roles
// 2. GET /roles/{id}
// 3. POST /roles/
// 4. PUT /roles/{id}
// 5. DELETE /roles/{id}
public interface RoleDao extends JpaRepository<Role, Integer> {
    
}
