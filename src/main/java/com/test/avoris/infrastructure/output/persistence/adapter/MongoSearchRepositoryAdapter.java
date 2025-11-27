package com.test.avoris.infrastructure.output.persistence.adapter;

import com.test.avoris.application.port.input.response.CountResponseDTO;
import com.test.avoris.application.port.output.SearchRepository;
import com.test.avoris.domain.exception.CustomServiceException;
import com.test.avoris.domain.model.SearchDto;
import com.test.avoris.infrastructure.output.persistence.mapper.SearchMongoMapper;
import com.test.avoris.infrastructure.output.persistence.repository.SpringDataSearchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class MongoSearchRepositoryAdapter implements SearchRepository {

    private final SpringDataSearchRepository repository;
    private final SearchMongoMapper mapper;

    public MongoSearchRepositoryAdapter(SpringDataSearchRepository repository, SearchMongoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveSearch(SearchDto searchDto) {
        repository.save(mapper.toSearchDocument(searchDto));
    }

    @Override
    public CountResponseDTO getSimilarSearches(String searchId) {
        // Obtengo el documento asociado al searchId de entrada y si no existe devuelvo not found
        var searchEntity = repository.findBySearchId(searchId)
                .orElseThrow(() -> new CustomServiceException(HttpStatus.NOT_FOUND, "The search with id ".concat(searchId).concat(" not exist on database.")));

        // Busco segun el hotelId el numero de busquedas similares, le resto 1 para no contar el searchId que se busca y lo asigno para su mapeo de salida
        return mapper.toCountResponseDto(searchEntity,
                repository.countByHotelId(searchEntity.getHotelId()) - 1);
    }


}
