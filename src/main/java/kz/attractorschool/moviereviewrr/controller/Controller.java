package kz.attractorschool.moviereviewrr.controller;

import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import kz.attractorschool.moviereviewrr.repository.ReviewRepository;
import kz.attractorschool.moviereviewrr.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@org.springframework.stereotype.Controller
public class Controller {
    Sort s = Sort.by(Sort.Order.asc("title"));

    MovieRepository mr;

    ReviewRepository rr;

    UserRepository ur;

    @GetMapping("/movies")
    public String getMovie(Model model) {
        model.addAttribute("movies", mr.findAll(s));
        return "movies";
    }
    @GetMapping("/users")
    public String getUsers(Model model) {
        s = Sort.by(Sort.Order.asc("name"));
        model.addAttribute("users", ur.findAll(s));
        return "users";
    }
    @GetMapping("/users/{name}")
    public String getMovieByYear(@PathVariable("name") String name, Model model) {
        model.addAttribute("users", ur.findAllByNameContaining(name));
        return "users";
    }

    @GetMapping("/movies/{year}")
    public String getMovieByYear(@PathVariable("year") int year, Model model) {
        model.addAttribute("movies", mr.findAllByReleaseYearGreaterThanEqual(year, s));
        return "movies";
    }
    @GetMapping("/reviews")
    public String getReview(Model model) {
        rr.findAll().forEach(System.out::println);
        model.addAttribute("reviews", rr.findAll());
        System.out.println("passeed");
        return "reviews";
    }
    @GetMapping("/reviews/{stars}")
    public String getReviewByStar(@PathVariable("stars") int stars, Model model) {
        s = Sort.by(Sort.Order.asc("stars"));
        model.addAttribute("reviews", rr.findTopByStarsGreaterThanEqual(stars, s));
        return "reviews";
    }

    @GetMapping("/movies/{year}/{year2}")
    public String getMovie(@PathVariable("year") int year,
                                    @PathVariable("year2") int year2,
                                    Model model) {
        model.addAttribute("movies", mr.findAllByReleaseYearBetween(year, year2, s));
        return "movies";
    }

    @GetMapping("/moviesbetween/{year}/{year2}")
    public String getMovieBetween(@PathVariable("year") int year,
                                           @PathVariable("year2") int year2,
                                           Model model) {
        model.addAttribute("movies", mr.getMoviesBetween(year, year2, s));
        return "movies";
    }
}
