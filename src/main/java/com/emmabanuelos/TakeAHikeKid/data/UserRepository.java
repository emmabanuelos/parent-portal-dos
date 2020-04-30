package com.emmabanuelos.TakeAHikeKid.data;

import com.emmabanuelos.TakeAHikeKid.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}




