package com.test.avoris.infrastructure.output.persistence.repository;

import com.test.avoris.infrastructure.output.persistence.entity.SearchEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringDataSearchRepository extends MongoRepository<SearchEntity, String> {

    Optional<SearchEntity> findBySearchId(String searchId);

    Long countByHotelId(String hotelId);
}
