package com.knigovert.review.repository;

import com.knigovert.review.model.Review;

import java.util.List;
import java.util.Optional;

/**
 * Created by Володимир on 05.04.2018.
 */
public interface ReviewService {
    List<Review> getList();
    Optional<Review> getReview(Long id);
    Review createReview(Long bookId, Long userId, int rating, String review );
    Review updateReview(Long id, Review updatedReview);
}
