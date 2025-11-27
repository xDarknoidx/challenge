package com.test.avoris.infrastructure.output.event;

import com.test.avoris.application.port.output.SearchEventPublisher;
import com.test.avoris.domain.model.SearchDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class SearchPublisher implements SearchEventPublisher {

    private static final Logger log = LoggerFactory.getLogger(SearchPublisher.class);

    private StreamBridge streamBridge;

    public SearchPublisher(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void publishSearch(SearchDto dto) {
        log.info("Starting publishing search into topic hotel_availability_searches with hotelId {}.", dto.getHotelId());

        streamBridge.send("output-out-0", dto);

        log.info("Finished publishing search into topic hotel_availability_searches with hotelId {}.", dto.getHotelId());
    }
}
