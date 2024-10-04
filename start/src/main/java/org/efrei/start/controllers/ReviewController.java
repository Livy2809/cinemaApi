package org.efrei.start.controllers;

import org.efrei.start.models.Review;
import org.efrei.start.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable("id") String id) {
        Long reviewId = Long.parseLong(id); // Convert String to Long
        return reviewService.findById(reviewId);
    }

    // Other methods (create, update, delete, etc.)
}
