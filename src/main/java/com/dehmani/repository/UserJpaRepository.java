package com.dehmani.repository;

import com.dehmani.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJpaRepository extends JpaRepository<User, Long>{

    User findByFirstName(String name);

    User findById(Integer id);
}
