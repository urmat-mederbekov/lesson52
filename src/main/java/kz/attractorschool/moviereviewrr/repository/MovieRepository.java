package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
    List<Movie> findAll(Sort s);

    List<Movie> findAllByReleaseYearGreaterThanEqual(int year, Sort s);

    List<Movie> findAllByReleaseYearBetween(int year, int year2, Sort s);

    @Query("{'releaseYear' : { '$gte' : ?0, '$lte' : ?1 }}")
    List<Movie> getMoviesBetween(int year, int year2, Sort s);
}
