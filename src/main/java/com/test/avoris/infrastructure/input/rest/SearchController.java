package com.test.avoris.infrastructure.input.rest;

import com.test.avoris.application.port.input.SearchUseCase;
import com.test.avoris.application.port.input.response.CountResponseDTO;
import com.test.avoris.application.port.input.response.SearchResponseDTO;
import com.test.avoris.infrastructure.input.rest.request.SearchRequestDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Price Controller Class.
 */
@Validated
@RestController
@RequestMapping("/api/v1/searches")
@OpenAPIDefinition(tags = {
        @Tag(name = "getPrice", description = "Find a price with a brand identifier, " +
                "product identifier and a date")
})
public class SearchController {

    private final SearchUseCase searchUseCase;

    /**
     * Custom Constructor
     * @param searchUseCase The Search Usecases Interface
     */
    public SearchController(final SearchUseCase searchUseCase) {
        this.searchUseCase = searchUseCase;
    }

    @Operation(tags = {"search"},
            summary = "Search an Id.",
            description = "Search an Id related to the input request.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search Id successfully.")
    })
    @PostMapping(value = "/search",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchResponseDTO> searchId(@Valid @RequestBody SearchRequestDTO request) {
        return ResponseEntity.ok(searchUseCase.search(request));
    }

    /**
     * Method to get the price filtered by the data passed in the url
     *
     * @param searchId The search identifier.
     * @return PricesRS The price filtered by date, brandId and productId.
     */
    @Operation(tags = {"count"},
            summary = "Count searches.",
            description = "Count the number of similar searches.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Count search successfully.")
    })
    @GetMapping("/count/{searchId}")
    public ResponseEntity<CountResponseDTO> countSearches(@PathVariable("searchId") String searchId) {
        return ResponseEntity.ok(searchUseCase.count(searchId));
    }
}
