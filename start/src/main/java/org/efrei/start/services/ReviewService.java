package org.efrei.start.services;

import org.efrei.start.models.Review;
import org.efrei.start.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository repository;

    @Autowired
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> findAll() {
        return repository.findAll();
    }

    public Review findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void create(Review review) {
        repository.save(review);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, Review review) {
        Review updatedReview = findById(id);
        if (updatedReview != null) {
            updatedReview.setContent(review.getContent());
            updatedReview.setMovie(review.getMovie());
            repository.save(updatedReview);
        }
    }
}
