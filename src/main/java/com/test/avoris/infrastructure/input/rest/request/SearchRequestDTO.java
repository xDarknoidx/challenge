package com.test.avoris.infrastructure.input.rest.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public class SearchRequestDTO implements Serializable {

    @NotBlank(message = "Parameter hotelId can not be empty or null.")
    private final String hotelId;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private final LocalDate checkIn;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private final LocalDate checkOut;
    @Size(min = 1, message = "Parameter ages should be at least of one age.")
    private final Integer[] ages;

    public String getHotelId() {
        return hotelId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Integer[] getAges() {
        return ages;
    }

    public SearchRequestDTO(String hotelId, LocalDate checkIn, LocalDate checkOut, Integer[] ages) {
        this.hotelId = hotelId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.ages = ages;
    }
}
