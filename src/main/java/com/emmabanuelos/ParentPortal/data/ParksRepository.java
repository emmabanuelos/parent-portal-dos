package com.emmabanuelos.ParentPortal.data;

import com.emmabanuelos.ParentPortal.models.Parks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParksRepository extends CrudRepository<Parks,Integer> {
}
