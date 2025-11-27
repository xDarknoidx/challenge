package com.test.avoris.application.port.input.response;

import java.io.Serializable;

public class SearchResponseDTO implements Serializable {

    private String searchId;

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public SearchResponseDTO(String searchId) {
        this.searchId = searchId;
    }
}
