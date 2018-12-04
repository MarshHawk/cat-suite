package com.marshhawk.catsuite.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marshhawk.catsuite.model.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> { 
    Cat findByCatName(String catName);
}