package com.marshhawk.catsuite.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marshhawk.catsuite.model.Mij;

public interface MijRepository extends MongoRepository<Mij, String> {}