package com.test.avoris.application.port.output;

import com.test.avoris.application.port.input.response.CountResponseDTO;
import com.test.avoris.domain.model.SearchDto;

public interface SearchRepository {

    void saveSearch(SearchDto searchDto);

    CountResponseDTO getSimilarSearches(String searchId);
}
