package com.knigovert.review.repository;

import com.knigovert.review.model.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Володимир on 05.04.2018.
 */

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
