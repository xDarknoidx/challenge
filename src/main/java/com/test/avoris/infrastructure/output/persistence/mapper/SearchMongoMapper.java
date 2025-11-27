package com.test.avoris.infrastructure.output.persistence.mapper;

import com.test.avoris.application.port.input.response.CountResponseDTO;
import com.test.avoris.application.port.input.response.Search;
import com.test.avoris.domain.model.SearchDto;
import com.test.avoris.infrastructure.output.persistence.entity.SearchEntity;
import org.springframework.stereotype.Component;

@Component
public class SearchMongoMapper {

    public SearchEntity toSearchDocument(SearchDto searchDto) {
        return new SearchEntity(null,
                searchDto.getSearchId(),
                searchDto.getHotelId(),
                searchDto.getCheckIn(),
                searchDto.getCheckOut(),
                searchDto.getAges());
    }

    public CountResponseDTO toCountResponseDto(SearchEntity entity, Long similarSearches) {
        return new CountResponseDTO(entity.getSearchId(),
                new Search(entity.getHotelId(),
                        entity.getCheckIn(),
                        entity.getCheckOut(),
                        entity.getAges()),
                similarSearches);
    }
}
