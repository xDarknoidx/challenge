package com.test.avoris.infrastructure.input.event;

import com.test.avoris.application.port.output.SearchRepository;
import com.test.avoris.domain.model.SearchDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

@Service
@Transactional
public class SearchConsumer {

    private static final Logger log = LoggerFactory.getLogger(SearchConsumer.class);

    private final SearchRepository repository;

    public SearchConsumer(SearchRepository repository) {
        this.repository = repository;
    }

    @Bean
    public Consumer<SearchDto> input() {
        return searchDto -> {
            System.out.println("Received searchDto: " + searchDto.getHotelId());
            log.info("Received searchDto object from kafka qeue with Id: ".concat(searchDto.getHotelId()).concat(". Starting saving on Mongo."));
            repository.saveSearch(searchDto);
            log.info("Finished saving on Mongo.");
        };
    }
}
