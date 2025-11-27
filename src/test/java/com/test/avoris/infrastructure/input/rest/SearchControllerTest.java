package com.test.avoris.infrastructure.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.avoris.application.port.input.SearchUseCase;
import com.test.avoris.application.port.input.response.SearchResponseDTO;
import com.test.avoris.infrastructure.input.rest.request.SearchRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchController.class)
public class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private SearchUseCase searchUseCase;

    private SearchRequestDTO request;

    private SearchResponseDTO response;

    @BeforeEach
    void setUp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        request = new SearchRequestDTO("hotelId",  LocalDate.parse("2020-08-12", dtf), LocalDate.parse("2020-08-15", dtf), new Integer[3]);
        response = new SearchResponseDTO("searchId");
    }

    @Test
    void shouldSearch() throws Exception {
        // Given
        when(searchUseCase.search(any(SearchRequestDTO.class))).thenReturn(response);

        // When/Then
        mockMvc.perform(post("/api/v1/searches/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.searchId", is("searchId")));
    }
}
