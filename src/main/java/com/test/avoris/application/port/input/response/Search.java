package com.test.avoris.application.port.input.response;

import java.io.Serializable;
import java.time.LocalDate;

public class Search implements Serializable {

    private String hotelId;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Integer[] ages;

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

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setAges(Integer[] ages) {
        this.ages = ages;
    }

    public Search(String hotelId, LocalDate checkIn, LocalDate checkOut, Integer[] ages) {
        this.hotelId = hotelId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.ages = ages;
    }
}
