package com.jsr.api.repository;

import com.jsr.api.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u.id_usuario, u.alias_usuario, u.pass_usuario FROM users u WHERE u.alias_usuario = ?1 AND pass_usuario= SUBSTRING(SHA2(?2, 256), 1, 32)", nativeQuery=true)
    User findByCredentials(String alias_usuario, String pass_usuario);
}
