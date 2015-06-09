package com.thoughtworks.fam.repository;

import com.thoughtworks.fam.domain.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByName(String name);
}
