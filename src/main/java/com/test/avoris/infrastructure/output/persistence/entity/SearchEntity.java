package com.test.avoris.infrastructure.output.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class SearchEntity {

    @Id
    private String _id;

    private String searchId;

    private String hotelId;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Integer[] ages;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

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

    public SearchEntity() {
    }

    public SearchEntity(String _id, String searchId, String hotelId, LocalDate checkIn, LocalDate checkOut, Integer[] ages) {
        this._id = _id;
        this.searchId = searchId;
        this.hotelId = hotelId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.ages = ages;
    }
}
