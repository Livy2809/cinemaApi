package org.efrei.start.repositories;

import org.efrei.start.models.Review;

import java.util.List;

public interface ReviewRepository {
    void save(Review updatedReview);

    List<Review> findAll();


}
