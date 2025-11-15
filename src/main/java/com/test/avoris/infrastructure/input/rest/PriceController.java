package com.test.avoris.infrastructure.input.rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * Price Controller Class.
 */
//@Slf4j
@RestController
@RequestMapping("/api/v1/prices")
@OpenAPIDefinition(tags = {
        @Tag(name = "getPrice", description = "Find a price with a brand identifier, " +
                "product identifier and a date")
})
public class PriceController {

    /**
     * Custom Constructor
     */
    public PriceController() {
    }

    /**
     * Method to get the price filtered by the data passed in the url
     *
     * @param date The timestamp date between start date and end date.
     * @param brandId The Brand Identificator.
     * @param productId The Product Identificator.
     * @return PricesRS The price filtered by date, brandId and productId.
     */
    @Operation(tags = {"getPrice"},
            summary = "Find a price.",
            description = "Find a price with a brand identifier, product identifier and a date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price find successfully.")
    })
    @GetMapping("/get-price/{date}/{brandId}/{productId}")
    public ResponseEntity<String> getPrice(@PathVariable("date") Timestamp date,
                                            @PathVariable("brandId") int brandId,
                                            @PathVariable("productId") int productId) {
//        return ResponseEntity.ok(mapper.toResponse(port.find(date, brandId, productId)));
        return ResponseEntity.ok("");
    }
}
