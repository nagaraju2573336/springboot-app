package com.example.tracking.service;

import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TrackingNumberService {

    // Set to store already generated tracking numbers (in-memory for simplicity)
    private Set<String> generatedTrackingNumbers = new HashSet<>();

    // Atomic counter to ensure efficient generation
    private AtomicInteger counter = new AtomicInteger(0);

    // Method to generate a unique tracking number
    public String generateTrackingNumber() {
        String trackingNumber;
        do {
            trackingNumber = generateRandomTrackingNumber();
        } while (generatedTrackingNumbers.contains(trackingNumber));

        // Store the new unique tracking number
        generatedTrackingNumbers.add(trackingNumber);
        return trackingNumber;
    }

    // Method to generate a random tracking number
    private String generateRandomTrackingNumber() {
        StringBuilder trackingNumber = new StringBuilder();

        // Use a simple counter as part of the tracking number (for uniqueness)
        trackingNumber.append("TN").append(String.format("%06d", counter.incrementAndGet()));

        // Ensure the length of the tracking number does not exceed the regex limit
        if (trackingNumber.length() > 16) {
            trackingNumber.setLength(16); // Truncate if needed
        }

        // Return the uppercase tracking number
        return trackingNumber.toString().toUpperCase();
    }
}
