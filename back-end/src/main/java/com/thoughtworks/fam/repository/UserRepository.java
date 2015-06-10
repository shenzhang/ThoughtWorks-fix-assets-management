package com.thoughtworks.fam.repository;

import com.thoughtworks.fam.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByName(String name);
}
