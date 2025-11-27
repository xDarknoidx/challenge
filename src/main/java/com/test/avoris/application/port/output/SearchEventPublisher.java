package com.test.avoris.application.port.output;

import com.test.avoris.domain.model.SearchDto;

public interface SearchEventPublisher {

    void publishSearch(SearchDto dto);
}
