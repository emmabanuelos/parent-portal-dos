package com.emmabanuelos.TakeAHikeKid.data;

import com.emmabanuelos.TakeAHikeKid.models.Trail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailRepository extends CrudRepository <Trail, Integer> {
}
