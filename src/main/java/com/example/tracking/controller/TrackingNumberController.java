package com.example.tracking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tracking.response.TrackingNumberResponse;
import com.example.tracking.service.TrackingNumberService;

import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
public class TrackingNumberController {

    private final TrackingNumberService trackingNumberService;

    public TrackingNumberController(TrackingNumberService trackingNumberService) {
        this.trackingNumberService = trackingNumberService;
    }

    @GetMapping("/next-tracking-number")
    public ResponseEntity<TrackingNumberResponse> generateTrackingNumber(
            @RequestParam("origin_country_id") String originCountryId,
            @RequestParam("destination_country_id") String destinationCountryId,
            @RequestParam("weight") double weight,
            @RequestParam("created_at") String createdAt,
            @RequestParam("customer_id") UUID customerId,
            @RequestParam("customer_name") String customerName,
            @RequestParam("customer_slug") String customerSlug) {

        // Generate the tracking number
        String trackingNumber = trackingNumberService.generateTrackingNumber();

        // Get the current timestamp in RFC 3339 format
        OffsetDateTime generatedAt = OffsetDateTime.now();

        // Create the response
        TrackingNumberResponse response = new TrackingNumberResponse(trackingNumber, generatedAt);

        return ResponseEntity.ok(response);
    }
}
