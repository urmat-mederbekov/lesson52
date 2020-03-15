package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Review;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {
    List<Review> findAll();
    List<Review> findTopByStarsGreaterThanEqual(int star, Sort sort);

}
