package com.emmabanuelos.TakeAHikeKid.data;

import com.emmabanuelos.TakeAHikeKid.models.Parks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParksRepository extends CrudRepository<Parks,Integer> {
}
