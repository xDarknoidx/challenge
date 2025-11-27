package com.test.avoris.domain.model;

import com.test.avoris.infrastructure.input.rest.request.SearchRequestDTO;

import java.time.LocalDate;

public class SearchDto extends SearchRequestDTO {

    private String searchId;

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public SearchDto(String hotelId, LocalDate checkIn, LocalDate checkOut, Integer[] ages, String searchId) {
        super(hotelId, checkIn, checkOut, ages);
        this.searchId = searchId;
    }
}
