package com.test.avoris.application.service;

import com.test.avoris.domain.model.SearchDto;
import com.test.avoris.infrastructure.input.rest.request.SearchRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class SearchMapper {

    public SearchDto toSearchDto(SearchRequestDTO request, String searchId) {
        return new SearchDto(request.getHotelId(),
                request.getCheckIn(),
                request.getCheckOut(),
                request.getAges(),
                searchId);
    }
}
