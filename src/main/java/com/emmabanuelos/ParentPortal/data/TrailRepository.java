package com.emmabanuelos.ParentPortal.data;

import com.emmabanuelos.ParentPortal.models.Trail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailRepository extends CrudRepository <Trail, Integer> {
}
