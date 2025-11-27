package com.test.avoris.application.port.input.response;

import java.io.Serializable;

public class CountResponseDTO implements Serializable {

    private String searchId;

    private Search search;

    private Long count;

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public CountResponseDTO(String searchId, Search search, Long count) {
        this.searchId = searchId;
        this.count = count;
        this.search = search;
    }
}
