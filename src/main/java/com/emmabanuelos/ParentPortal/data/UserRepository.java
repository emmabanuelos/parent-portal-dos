package com.emmabanuelos.ParentPortal.data;

import com.emmabanuelos.ParentPortal.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}




