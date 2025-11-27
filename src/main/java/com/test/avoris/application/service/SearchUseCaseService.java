package com.test.avoris.application.service;

import com.test.avoris.application.port.input.SearchUseCase;
import com.test.avoris.application.port.input.response.CountResponseDTO;
import com.test.avoris.application.port.input.response.SearchResponseDTO;
import com.test.avoris.application.port.output.SearchEventPublisher;
import com.test.avoris.application.port.output.SearchRepository;
import com.test.avoris.domain.exception.CustomServiceException;
import com.test.avoris.infrastructure.input.rest.request.SearchRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SearchUseCaseService implements SearchUseCase {

    private final SearchEventPublisher eventPublisher;
    private final SearchRepository repository;
    private final SearchMapper mapper;

    public SearchUseCaseService(final SearchMapper mapper, final SearchEventPublisher eventPublisher, final SearchRepository repository) {
        this.mapper = mapper;
        this.eventPublisher = eventPublisher;
        this.repository = repository;
    }

    @Override
    public SearchResponseDTO search(SearchRequestDTO request) {
        // Validar payload
        if(request.getCheckIn().isAfter(request.getCheckOut())) {
            throw new CustomServiceException(HttpStatus.BAD_REQUEST, "The checkIn date must be earlier than the checkOut date.");
        }

        // Generar SearchId con UUID y asignarselo al objeto antes de enviar a kafka
        SearchResponseDTO response = new SearchResponseDTO(UUID.randomUUID().toString());

        // Enviar payload al topico de kafka hotel_availability_searches en puerto 9092
        eventPublisher.publishSearch(mapper.toSearchDto(request, response.getSearchId()));

        return response;
    }

    @Override
    public CountResponseDTO count(String searchId) {
        // Buscamos que exista el searchId y  obtenemos sus busquedas similares
        return repository.getSimilarSearches(searchId);
    }


}
