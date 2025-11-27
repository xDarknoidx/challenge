package com.test.avoris.application.port.input;

import com.test.avoris.application.port.input.response.CountResponseDTO;
import com.test.avoris.application.port.input.response.SearchResponseDTO;
import com.test.avoris.infrastructure.input.rest.request.SearchRequestDTO;

public interface SearchUseCase {

    SearchResponseDTO search(SearchRequestDTO request);

    CountResponseDTO count(String searchId);
}
